import greenfoot.*;

/**
 * A box with a ball in it.
 * 
 * @author mik
 * @version 1.0
 */
public class Box extends World
{    
    /**
     * Construct the box with a ball in it.
     */
    public Box()
    {    
        super(460, 320, 1);
        setPaintOrder ( Ball.class, Smoke.class ); // paint ball on top
        
        addObject ( new Ball(), getWidth() / 2, getHeight() / 2);
    }
}
