
package com.molinab.game.main;
import javax.swing.JFrame;


 /*************************************************************************
 * GameMain (Using Java Game Development Framework V.2)
 * ----------------------------------------------------------------------
 * This class acts as a main container for the Game Object. 
 *  *** Overview of JPanel and JFrame ***
 * JFrame: The main container, which acts as the main window. 
 *         Contains the JPanel.
 * JPanel: A container that holds other GUI components, 
 *         such as buttons, textfields, ect. 
 * ----------------------------------------------------------------------
 ************************************************************************/
public class GameMain {
    
    private static final String GAME_TITLE = "Ellio";
    public static final int GAME_WIDTH = 800;
    public static final int GAME_HEIGHT = 450;
   
    public static Game sGame;
    
    public static void main(String[] agrs)
    {
        // Create the main window.
        JFrame frame = new JFrame(GAME_TITLE);
        
        // Set Main Window attributes
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        
        // create game and add it to the main frame
        sGame = new Game(GAME_WIDTH, GAME_HEIGHT);
        frame.add(sGame);
        // tells the JFrame object to resize to the preffered size
        frame.pack();
        frame.setVisible(true);
        frame.setIconImage(Resources.iconimage);
       
    }
    
}
