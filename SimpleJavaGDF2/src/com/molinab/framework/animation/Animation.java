
package com.molinab.framework.animation;
import java.awt.Graphics;

 /*************************************************************************
 * Animation
 * ----------------------------------------------------------------------
 * This class handles all animated objects in the game by accepting
 * Frame objects, storing them in an array and storing their corresponding 
 * durations in a separate array, and then allows them to be rendered to the
 * screen.
 * 
 * Input:
 * One or multiple Frame objects.
 * 
 * Output: 
 * Draws the final animation to the screen.
 * 
 * ----------------------------------------------------------------------
 ************************************************************************/
public class Animation {
    
    private Frame[] frames;         // holds each picture of an animation in an array
    private double[] frameEndTimes; // holds the duration each picture is displayed for in an array
    private int currentFrameIndex = 0;
    private double totalDuration  = 0;
    private double currentTime    = 0; 
    
    // Class Constructor. Accepts a variable amount of frame objects
    public Animation(Frame... frames)
    {
        // copy object
        this.frames = frames; 
        // create paralell array with the same size as the frame array
        frameEndTimes = new double[frames.length];  
        
        for(int i = 0; i < frames.length; i++)
        {
            // calculates amount of time it takes to complete animation
            Frame tempFrame = frames[i];
            totalDuration += tempFrame.getDuration();
            // stores duration of each frame into the parallel array.
            frameEndTimes[i] = totalDuration;
        }
    }
    
    // *** Synchronized Keyword: ensures that animation will update accurately 
    // in a multi-threaded environment ***
    public synchronized void update(float increment) 
    {
        // holds animation running time
        currentTime += increment;

        // if the animation has been completed, restart it.
        if (currentTime > totalDuration) 
        {
                // repeats animation
                wrapAnimation();
        }
        while (currentTime > frameEndTimes[currentFrameIndex])
        {
                currentFrameIndex++;
        }
    }

    // keeps the animation repeating
    private synchronized void wrapAnimation() 
    {
        currentFrameIndex = 0;
        // calculates how many seconds PAST the end of 
        // the animation we were before resetting the animation.
        currentTime = currentTime % totalDuration; // equal to cT = cT % tD
    }

    // allows an object to drawn at x,y. Does not allow to specify size of object
    public synchronized void render(Graphics g, int x, int y) 
    {
        g.drawImage(frames[currentFrameIndex].getImage(), x, y, null);
    }

    // allows an object of size width,heigh to be drawn at x,y.
    public synchronized void render(Graphics g, int x, int y, int width, int height) 
    {
        g.drawImage(frames[currentFrameIndex].getImage(), x, y, width, height, null);
    }
    
}
