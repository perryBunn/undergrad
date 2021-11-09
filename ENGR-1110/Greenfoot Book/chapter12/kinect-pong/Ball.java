import greenfoot.*;

/**
 * The ball in the game. It moves and bounces off the walls.
 * 
 * @author mik
 * @version 1.0
 */
public class Ball extends Actor
{
    private int deltaX;         // x movement speed
    private int deltaY;         // y movement speed
    private int radius;
    private int delay;
    private int playerScore;
    private int computerScore;
    
    /**
     * Create a bouncing ball.
     */
    public Ball()
    {
        deltaX = 2;
        deltaY = 3;
        radius = getImage().getWidth() / 2;
        delay = 200;
        playerScore = 0;
        computerScore = 0;
    }

    /**
     * When this ball is added to the world, show the initial scores.
     */
    public void addedToWorld(World world)
    {
        showScores();
    }
    
    /**
     * Move and bounce.
     */
    public void act() 
    {
        if (delay > 0) {
            delay--;
            return;
        }
        
        checkWalls();
        checkPaddle();
        setLocation (getX() + deltaX, getY() + deltaY);
        checkOut();
    }
    
    /**
     * Check whether we've hit one of the walls. Reverse direction if necessary.
     */
    private void checkWalls()
    {
        if (getX() <= radius || getX() >= getWorld().getWidth()-radius) {
            deltaX = -deltaX;
        }
    }
    
    /**
     * Reverse vertical direction if we hit a paddle.
     */
    private void checkPaddle()
    {
        Actor paddle = getOneIntersectingObject(Paddle.class);
        if (paddle != null) {
            deltaY = -deltaY;
            deltaX = (getX()-paddle.getX()) / 9;
        }
    }
    
    /**
     * Check whether the ball is out of play (top or bottom of screen).
     */
    private void checkOut()
    {
        if (getY() < 10  ||  getY() > getWorld().getHeight()-10) {
            // ball is out
            if (getY() < 10) {
                playerScore++;
            }
            else {
                computerScore++;
            }
            showScores();

            // reset ball
            setLocation (getWorld().getWidth()/2, getWorld().getHeight()/2);
            delay = 200;
            deltaX = 1;
        }
    }
    
    /**
     * Show the current scores on screen.
     */
    private void showScores()
    {
        getWorld().showText("Score: "+playerScore, 60, 260);
        getWorld().showText("Score: "+computerScore, 60, 220);
    }
}
