package com.molinab.game.main;
import com.molinab.framework.animation.Animation;
import com.molinab.framework.animation.Frame;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import java.awt.Color;

 /*************************************************************************
 * Resources
 * ----------------------------------------------------------------------
 * This class handles everything resource related, such
 * audio and images files, and assigns them into variables which
 * can be used in other classes.
 * ----------------------------------------------------------------------
 ************************************************************************/
public class Resources {
    
    public static BufferedImage welcome, iconimage;

    // loads all image and sound files
    public static void load()
    {
        welcome = loadImage("welcome.png");
        iconimage = loadImage("iconimage.png");
    }
    
    private static AudioClip loadSound(String filename)
    {
        URL fileURL = Resources.class.getResource("/resources/" + filename);
        return Applet.newAudioClip(fileURL);
    }
    
    private static BufferedImage loadImage(String filename)
    {
        BufferedImage img = null;
        try 
        {
            img = ImageIO.read(Resources.class.getResourceAsStream("/resources/" + filename));
        } 
        catch (Exception e)
        {
            System.out.println("Error while reading: " + filename);
            e.printStackTrace();
        }
        return img;
    }
    
}
