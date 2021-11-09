import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A button that moves randomly around the World.
 * 
 * @author  Dean Hendrix (dh@auburn.edu)
 * @author  YOUR NAME
 * @version 2016-02-05
 */
public class Button extends Actor
{
    /**
     * Changes the location of this button approximately
     * 2% of the time.
     */
    public void act() {
        if (Greenfoot.getRandomNumber(100) < 2) {
            changeLocation();
        }
    }   
    
    /**
     * Sets the location of this Button object to a new (x, y) 
     * coordinate selected at random. The x coordinate wil be in 
     * the range 100 to 500 inclusive, and the y coordinate will 
     * be the range 100 to 300 inclusive.
     */
    public void changeLocation() {
        setLocation(Greenfoot.getRandomNumber(400)+100, Greenfoot.getRandomNumber(200)+100);
    }
}
