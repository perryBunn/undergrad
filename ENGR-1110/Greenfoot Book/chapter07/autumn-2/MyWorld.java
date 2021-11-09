import greenfoot.*;

/**
 * Autumn. A world with some leaves.
 * 
 * @author Michael Kölling
 * @version 1.0
 */
public class MyWorld extends World
{
    /**
     * Create the world and objects in it.
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        setUp();
    }
    
    /**
     * Create the initial objects in the world.
     */
    private void setUp()
    {
        int i = 0;
        while (i<18) {
            int x = Greenfoot.getRandomNumber(getWidth());
            int y = Greenfoot.getRandomNumber(getHeight());
            addObject( new Leaf(), x, y );
            i++;
        }
        
        addObject(new Block(), 300, 200);
    }
}
