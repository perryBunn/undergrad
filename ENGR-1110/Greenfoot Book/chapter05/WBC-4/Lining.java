import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The Lining are objects at the edge of the vein.
 * 
 * @author Michael Kölling
 * @version 1.0
 */
public class Lining extends Actor
{
    /**
     * Move the lining along at regular speed.
     */
    public void act() 
    {
        setLocation(getX()-1, getY());
        
        if (getX() == 0) 
        {
            getWorld().removeObject(this);
        }
    }    
}
