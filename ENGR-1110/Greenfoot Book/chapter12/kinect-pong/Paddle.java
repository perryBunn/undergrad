import greenfoot.*;

/**
 * A simple paddle for a pong game. Used as superclass for specific kinds of paddle.
 * 
 * @author Michael Kölling
 * @version 1.0
 */
public class Paddle extends Actor
{
    /**
     * Move to the left.
     */
    protected void moveLeft()
    {
        setLocation (getX()-2, getY());
    }    

    /**
     * Move to the right.
     */
    protected void moveRight()
    {
        setLocation (getX()+2, getY());
    }    
}
