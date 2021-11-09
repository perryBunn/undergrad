import greenfoot.*;

/**
 * A pong game paddle controlled by the player.
 * 
 * @author Michael Kölling
 * @version 1.0
 */
public class PlayerPaddle extends Paddle
{
    private UserData user;
    private final int HAND;  // right or left hand
    
    /**
     * Create a player paddle.
     * The parameters are the user data of the controlling user, 
     * and a constant specifying which hand to track.
     */
    public PlayerPaddle(UserData user, int hand)
    {
        this.user = user;
        this.HAND = hand;
    }
    
    /**
     * Place the paddle at the x-location of the hand of the user.
     */
    public void act() 
    {
        Joint hand = user.getJoint(HAND);
        setLocation(hand.getX(), getY());
    }    
}
