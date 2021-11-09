import greenfoot.*;

/**
 * A simple world with a flower.
 * 
 * @author Michael Kölling 
 * @version 1.0
 */
public class MyWorld  extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        super(400, 300, 1); 
        addObject (new Flower(), 200, 150);
    }
}
