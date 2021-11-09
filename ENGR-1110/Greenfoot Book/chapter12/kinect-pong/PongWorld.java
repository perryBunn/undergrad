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
        addObject(new ComputerPaddle(), 100, 30);
        idle = true;
    }
    
    /**
     * Watch for a user appearing or disappearing, and start/stop the game accordingly.
     */
    public void act()
    {
        super.act();
        UserData[] users = getTrackedUsers();

        if (idle) {
            // check whether a user has arrived
            if (users.length > 0) {
                // discovered a new user
                startGame(users[0]);
                idle = false;
            }
        }
        else {
            // check whether user left
            if (users.length == 0) {
                // user has left
                stopGame();
                idle = true;
            }
        }
    }

    /**
     * Start a new game: create the paddles for the player and the ball.
     */
    private void startGame(UserData user)
    {
        addObject(new PlayerPaddle(user, Joint.RIGHT_HAND), 200, 450);
        addObject(new PlayerPaddle(user, Joint.LEFT_HAND), 200, 450);
        addObject(new Ball(), getWidth()/2, getHeight()/2);
    }
    
    /**
     * Stop the game: Remove the player paddles and ball.
     */
    private void stopGame()
    {
        removeObjects(getObjects(PlayerPaddle.class));
        removeObjects(getObjects(Ball.class));
    }
}
