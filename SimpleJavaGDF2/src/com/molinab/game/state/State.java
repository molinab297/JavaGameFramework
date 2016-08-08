
package com.molinab.game.state;
import com.molinab.game.main.GameMain;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
 

 /*************************************************************************
 * State
 * ----------------------------------------------------------------------
 * This class Does NOT represent an actual screen in the game. It
 * serves as a generic template (a super-class) when other state classes
 * are created (hence the ABSTRACT keyword).
 * ----------------------------------------------------------------------
 ************************************************************************/
public abstract class State {
    
    // ********************
    // * Abstract methods *
    // ********************
    // where game objects will be initialized throughout the game
    public abstract void init();
    // will be called by the game loop on every frame. Updates every
    // game object within the game state
    public abstract void update(float delta);
    // will be called by the game loop on every frame. 
    // It renders the game images to the screen
    public abstract void render(Graphics g);
    // receives information from user mouse click
    public abstract void onClick(MouseEvent e);
    // recieves information from user key click
    public abstract void onKeyPress(KeyEvent e);
    // recieves information from user key release
    public abstract void onKeyRelease(KeyEvent e);
    
    // ********************
    // * Concrete methods *
    // ********************
    public void setCurrentState(State newState)
    {
        GameMain.sGame.setCurrentState(newState);
    }
    
    
    
}
