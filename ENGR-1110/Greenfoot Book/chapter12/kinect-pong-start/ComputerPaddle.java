import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * A pong paddle controlled by the computer.
 * 
 * @author Michael Kölling
 * @version 1.0
 */
public class ComputerPaddle extends Paddle
{
    private int idleMove = 1;

    /**
     * Create a computer paddle.
     */
    public ComputerPaddle()
    {
    }

    /**
     * Move towards the ball. When there is no ball, go into waiting mode (move slowly
     * back and forth).
     */
    public void act() 
    {
        List balls = getWorld().getObjects(Ball.class);

        if (balls.isEmpty()) {
            idleMove();
        }
        else {
            Ball ball = (Ball) balls.get(0);

            if (getX() < ball.getX()) {
                moveRight();
            }
            else {
                moveLeft();
            }
        }
    }

    /**
     * Move slowly back and forth.
     */
    private void idleMove()
    {
        setLocation(getX() + idleMove, getY());
        if (getX() < 100 || getX() > getWorld().getWidth() - 100) {
            idleMove = -idleMove;
        }
    }
}
