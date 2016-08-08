
package com.molinab.game.state;
// needed to access Resources Class
import com.molinab.game.main.Resources;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

 /*************************************************************************
 * LoadState
 * ----------------------------------------------------------------------
 * This class extends the State class. It represents the loading screen of
 * a game, where it will request the Resources class to load all of the
 * game resources.
 * ----------------------------------------------------------------------
 ************************************************************************/
public class LoadState extends State {

    @Override
    public void init() {
        Resources.load();
        System.out.println("Loaded Successfully");
    }

    @Override
    public void update(float delta)
    {
        setCurrentState(new MenuState());
    }

    @Override
    public void render(Graphics g) {
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
