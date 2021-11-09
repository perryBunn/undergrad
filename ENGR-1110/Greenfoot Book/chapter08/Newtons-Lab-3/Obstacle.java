import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * An obstacle in our "Newton's Lab". An obstacle is a stationary object, that has no mass (gravity
 * does not interact with it) and does not move. However, when it is touched by a Body object, it makes
 * a sound.
 * 
 * @author Michael Kšlling 
 * @version 1.0
 */
public class Obstacle extends Actor
{
    private String sound;
    private boolean touched = false;
    
    /**
     * Create an obstacle with an associated sound file.
     */
    public Obstacle(String soundFile)
    {
        sound = soundFile;
    }
    
    /**
     * Each act cycle, check whether we were hit. If we were, play our sound.
     */
    public void act() 
    {
        Actor body = getOneIntersectingObject(Body.class);
        if (touched && body == null)   // not touched anymore
        { 
            touched = false;
            setImage ("block.png");
        }
        else if (!touched && body != null)   // just being touched now
        {
            touched = true;
            setImage ("block-light.png");
            Greenfoot.playSound(sound);
        }
    }    
    
    public void playSound()
    {
        Greenfoot.playSound(sound);
    }
}
