
package com.molinab.game.state;
import com.molinab.game.main.Resources;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
 

 /*************************************************************************
 * MenuState
 * ----------------------------------------------------------------------
 * This class extends the State class. It represents the Menu State of
 * the game.
 * ----------------------------------------------------------------------
 ************************************************************************/
public class MenuState extends State{

    @Override
    public void init() {
    }
    
    @Override
    public void update(float delta)
    {
        
    }

    // Draws Resources.welcome to screen
    @Override
    public void render(Graphics g) {
        g.drawImage(Resources.welcome, 0, 0, null);
    }

    @Override
    public void onClick(MouseEvent e) {
    }

    @Override
    public void onKeyPress(KeyEvent e) {
    }

    @Override
    public void onKeyRelease(KeyEvent e) {

    }
    
}
