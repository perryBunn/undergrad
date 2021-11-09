import greenfoot.*;

/**
 * A simple KinectWorld: This world places an actor that can display the image of users.
 * 
 * @author Michael Kölling
 * @version 1.0
 */
public class MyWorld extends KinectWorld
{
    /**
     * Construct a world with default dimensions for the Kinect (640x480).
     */
    public MyWorld()
    {    
        super();
        addObject(new UserImage(), 640/2, 480/2);
    }

    /**
     * World act - nothing to do.
     */
    public void act()
    {
        super.act();
    }
}
