import greenfoot.*;

/**
 * The ball of the game. It moves and bounces off the walls.
 * 
 * @author mik
 * @version 1.0
 */
public class Ball extends Actor
{
    private int deltaX;         // x movement speed
    private int deltaY;         // y movement speed
    private int count = 2;
    
    /**
     * Create a ball with random movement.
     */
    public Ball()
    {
        deltaX = Greenfoot.getRandomNumber(11) - 5;
        deltaY = Greenfoot.getRandomNumber(11) - 5;
    }
    
    /**
     * Act. Move and produce smoke.
     */
    public void act() 
    {
        makeSmoke();
        move();
    }
    
    /**
     * Move the ball. Then check whether we've hit a wall.
     */
    public void move()
    {
        setLocation (getX() + deltaX, getY() + deltaY);
        checkWalls();
    }
    
    /**
     * Check whether we've hit one of the walls. Reverse direction if necessary.
     */
    private void checkWalls()
    {
        if (getX() == 0 || getX() == getWorld().getWidth()-1) {
            deltaX = -deltaX;
        }
        if (getY() == 0 || getY() == getWorld().getHeight()-1) {
            deltaY = -deltaY;
        }
    }
    
    /**
     * Put out a puff of smoke (only on every second call).
     */
    private void makeSmoke()
    {
        count--;
        if (count == 0) {
            getWorld().addObject (new Smoke(), getX(), getY());
            count = 2;
        }
    }
}
