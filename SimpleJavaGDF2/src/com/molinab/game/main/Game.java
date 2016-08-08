
package com.molinab.game.main;
import com.molinab.framework.util.InputHandler;
import com.molinab.game.state.State;
import com.molinab.game.state.LoadState;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Graphics;

@SuppressWarnings("serial")

 /*************************************************************************
 * Game
 * ----------------------------------------------------------------------
 * This class is JPanel sub-class and is called within GameMain.java; it also
 * serves as the main game loop.
 *  *** Overview of JPanel and JFrame ***
 * JFrame: The main container, which acts as the main window. 
 *         Contains the JPanel.
 * JPanel: A container that holds other GUI components, 
 *         such as buttons, textfields, ect. 
 * 
 * This class 'implements Runnable' which allows a Game object to be used 
 * as a Runnable object
 * ----------------------------------------------------------------------
 ************************************************************************/
public class Game extends JPanel implements Runnable{
    
    private int gameWidth;
    private int gameHeight;
    
    private Image gameImage;
    private Thread gameThread;
    private InputHandler inputHandler; 
    
    // *** Definition of Volatile: Eliminates ambiguity between different
    // threads accessing the same variable ***
    
    // variable that determines if game is running or not
    private volatile boolean running;
    // variable that tracks the games current state
    private volatile State currentState;

    
    // Game Constructor
    public Game(int gameWidth, int gameHeight)
    {
        this.gameHeight = gameHeight;
        this.gameWidth  = gameWidth;
        // provided by extending JPanel
        setPreferredSize(new Dimension(gameWidth,gameHeight));
        setBackground(Color.BLACK);
        // makes keyboard events and buttons available to the Game object
        setFocusable(true);
        requestFocus();
    }
    
    // safe place to start setting up graphics, game state and user input
    @Override
    public void addNotify()
    {
        super.addNotify(); // calls JPanel's addNotify method (hence super.)
        initInput();       // activates ability to listen for mouse/key clicks
        setCurrentState(new LoadState()); 
        initGame();        // start main game thread   
    }
    
   
    // Sets the current state of a State object. (menuState, loadState, ect)
    public void setCurrentState(State newState)
    {
        // cleans system and removes any unused objects from program
        System.gc();
        newState.init();
        currentState = newState;
        inputHandler.setCurrentState(currentState);
    }
    
    // starts main game thread
    private void initGame()
    {
        running = true;
        // Thread object needs a Runnable object (A list of instructions to execute)
        // therefore the 'implements Runnable' must be included in the class declaration
        // to allow 'this' to be passed through the thread object.
        gameThread = new Thread(this, "Game Thread");
        // calls the run() method.
        gameThread.start();
        
    }
    
    // listens for user input
    private void initInput()
    {
        inputHandler = new InputHandler();
        addKeyListener(inputHandler);
        addMouseListener(inputHandler);     
    }

    // Brought over from the Runnable interface
    // The main purpose of run() is to update and render objects to the screen
    // ** not explicitly called, but is automatically called when the main game thread starts **
    @Override
    public void run() {
        
        long updateDurationMillis = 0; // measures update and render
        long sleepDurationMillis  = 0; // measures sleep
         
        while(running)
        {
            long beforeUpdateRender = System.nanoTime();
            // calculates duration of a single loop
            long deltaMillis = updateDurationMillis + sleepDurationMillis;
            
            updateAndRender(deltaMillis);
            
            updateDurationMillis = (System.nanoTime() - beforeUpdateRender) / 1000000L;
            // thread will sleep for a min of 2 and a max of 17 milliseconds
            sleepDurationMillis  = Math.max(2, 17 - updateDurationMillis); 
            
            try {
                  Thread.sleep(sleepDurationMillis);
                } 
            catch(InterruptedException e) {
                        e.printStackTrace();
                }
        }
        
        // End game immediately when running becomes false
        System.exit(0);

    }

    // used for main game loop
    private void updateAndRender(long deltaMillis) {
        currentState.update(deltaMillis/1000f);
        prepareGameImage();
        currentState.render(gameImage.getGraphics());
        renderGameImage(getGraphics());
    }
    
    // ends the game
    public void exit()
    {
        running = false;
    }
    
    // Prepares an Off-Screen image, prior to rendering the current state's scene
    // (all the objects in the current state).
    private void prepareGameImage()
    {
        if(gameImage == null)
        {
            gameImage = createImage(gameWidth, gameHeight);
        }
        
        // ensures that images from the previous frame do not
        // bleed into the current frame.
        Graphics g = gameImage.getGraphics();
        g.clearRect(0, 0, gameWidth, gameHeight);
    }
    
    // this method is called within the repaint() method.
    // it renders the image to the screen
    private void renderGameImage(Graphics g) 
    {
        if (gameImage != null) 
        {
                g.drawImage(gameImage, 0, 0, null);
        }
        g.dispose();
    }
    
    
}
