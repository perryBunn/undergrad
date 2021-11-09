import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Red blood cells float in the blood stream, carrying oxygen. They don't interact
 * with the white blood cells - they just float past.
 * 
 * @author Michael Kölling
 * @version 1.0
 */
public class RedCell extends Actor
{
    private int speed;
    
    /**
     * Contructor: Initialise the floating speed to a random value.
     */
    public RedCell()
    {
        speed = Greenfoot.getRandomNumber(2) + 1;
        setRotation(Greenfoot.getRandomNumber(360));
    }
    
    /**
     * Float along, right to left. Disappear when reaching the left edge.
     */
    public void act() 
    {
        setLocation(getX()-speed, getY());
        turn(1);
        
        if (getX() == 0) 
        {
            getWorld().removeObject(this);
        }
    }    
}
