import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)

/**
 * It's just a cliff.
 */
public class Cliff extends Actor
{
    public Cliff()
    {
    }
    
    public Cliff(boolean flip)
    {
        if (flip) {
            getImage().mirrorHorizontally();
        }
    }
    
    public void act() 
    {
        // No action required - the cliff doesn't do anything
    }    
}
