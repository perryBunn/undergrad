import greenfoot.*;

/**
 * This is the base scenario world for writing projects using the Mcrosoft Kinect.
 * 
 * @author (your name here)
 * @version 1.0
 */
public class MyWorld extends KinectWorld
{
    /**
     * Constructor for our world. Place any objects needed.
     */
    public MyWorld()
    {    
        super();
    }
    
    /**
     * World act method: Insert code for whatever you need.
     * (Don't forget: The superclass act method must be called in all Kinect scenarios.)
     */
    public void act()
    {
        super.act();
        if (!isConnected()) {
            return;
        }
    }
}
