
package com.molinab.framework.animation;

import java.awt.Image;

 /*************************************************************************
 * Frame
 * ----------------------------------------------------------------------
 * This class handles each individual picture of an animation. (An animation 
 * consists of multiple pictures to allude the sense of actual movement). 
 * A Frame object(s) is instantiated and is sent to Animation(Frame... frames), 
 * where it is then rendered to the screen.
 * 
 * Input:
 * 1). An image of type Image.
 * 2). The duration that you want the image to last for of type double. 
 * 
 * Output: 
 *  - none
 * 
 * ----------------------------------------------------------------------
 ************************************************************************/
public class Frame {
    
    private Image image;
    private double duration;
    
    // class constructor
    public Frame(Image image, double duration)
    {
        this.image    = image;
        this.duration = duration;
    }
    
    public double getDuration()
    {
        return duration;
    }
    
    public Image getImage()
    {
        return image;
    }
    
    
}
