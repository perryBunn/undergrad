import greenfoot.*;

/**
 * A small thumbnail image of the Kinect camera image.
 * 
 * @author Neil Brown, Michael Kölling
 * @version 1.0
 */
public class Thumbnail extends Actor
{
    public Thumbnail()
    {
    }

    /**
     * Update the image.
     */
    public void act() 
    {
        KinectWorld world = (KinectWorld)getWorld();
        setImage(world.getThumbnailUnscaled());
    }
}
