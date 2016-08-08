
package com.molinab.framework.util;

import java.util.Random;

 /*************************************************************************
 * RandomNumberGenerator
 * ----------------------------------------------------------------------
 * This class represents a random number generator.
 * 
 * Input: 
 * lowerBound (int) - a lower bound digit
 * upperBound (int) - a upper bound digit
 * 
 * Return:
 * a randomized digit based on the bound specifications 
 *
 * ----------------------------------------------------------------------
 ************************************************************************/
public class RandomNumberGenerator {
    
    private static Random rand = new Random();
    
    public static int getRandIntBetween(int lowerBound, int upperBound)
    {
        return rand.nextInt(upperBound) + lowerBound;
    }
    
    public static int getRandInt(int upperBound)
    {
        return rand.nextInt(upperBound);
    }
    
}
