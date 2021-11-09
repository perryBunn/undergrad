import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

/**
 * A bit of empty space for bubbles to float in.
 * 
 * @author Michael Kölling
 * @version 1.0
 */
public class Space extends World
{
    /**
     * Create Space. Make it black.
     */
    public Space()
    {
        super(900, 600, 1);
        getBackground().setColor(Color.BLACK);
        getBackground().fill();
    }
}
