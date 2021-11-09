import greenfoot.*; 

/**
 * The game board. The board had a paddle that can move.
 * 
 * @author mik
 * @version 1.0
 */
public class Board extends World
{
    private Paddle paddle;
    
    /**
     * Constructor for objects of class Board.
     * 
     */
    public Board()
    {    
        super(460, 520, 1);
        setPaintOrder ( Ball.class, Smoke.class );
        
        paddle = new Paddle();
        addObject ( paddle, getWidth() / 2, getHeight() - 40);
    }
    
    public void ballIsOut()
    {
        paddle.newBall();
    }
}
