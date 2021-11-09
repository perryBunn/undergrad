import greenfoot.*;

/**
 * This is a very simple demo world using the Kinect: This world shows the image from the
 * Kinect camera as the world background.
 * 
 * @author Michael Kölling
 * @version 1.0
 */
public class MyWorld extends KinectWorld
{
    /**
     * Constructor for our world. Nothing to do.
     */
    public MyWorld()
    {    
        super();
    }
    
    /**
     * In every act cycle, get the image from the Kinect and use it as our background image.
     * (Don't forget: The superclass act method must be called in all Kinect scenarios.)
     */
    public void act()
    {
        super.act();

        GreenfootImage cameraImage = getThumbnailUnscaled();
        setBackground(cameraImage);
    }
}
