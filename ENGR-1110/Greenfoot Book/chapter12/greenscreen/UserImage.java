import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * An actor that displays the images of all tracked users (without background).
 * 
 * @author Michael Kölling
 * @version 1.0
 */
public class UserImage extends Actor
{
    /**
     * Get the combined user image from the Kinect, and use it as our own actor image.
     * The size of the image is the same as the world (so covers the whole background)
     * but background (non-user) pixels are transparent.
     */
    public void act() 
    {
        KinectWorld world = (KinectWorld)getWorld();
        setImage(world.getCombinedUserImage());
    }    
}

