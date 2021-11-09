import greenfoot.*;

/**
 * A pong game paddle controlled by the player.
 * 
 * @author Michael Kölling
 * @version 1.0
 */
public class PlayerPaddle extends Paddle
{
    /**
     * Create a player paddle.
     */
    public PlayerPaddle()
    {
    }
    
    /**
     * Place the paddle at the x-location of the hand of the user.
     */
    public void act() 
    {
        if (Greenfoot.isKeyDown("left")) {
            moveLeft();
        }
        if (Greenfoot.isKeyDown("right")) {
            moveRight();
        }
    }    
}
