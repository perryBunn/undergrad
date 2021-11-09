import greenfoot.*; 

/**
 * A world for a simple 'pong' style computer game. One player is played by the computer,
 * that other is a Kinect-controlled player.
 * 
 * @author Michael Kölling
 * @version 1.0
 */
public class PongWorld extends KinectWorld
{
    private boolean idle;

    /**
     * Create the game world with the game objects in it.
     */
    public PongWorld()
    {
        super ();
        addObject(new ComputerPaddle(), 200, 30);
        addObject(new PlayerPaddle(), 200, 450);
        addObject(new Ball(), getWidth()/2, getHeight()/2);
        idle = true;
    }
    
    /**
     * Nothing to do.
     */
    public void act()
    {
        super.act();
    }
}
