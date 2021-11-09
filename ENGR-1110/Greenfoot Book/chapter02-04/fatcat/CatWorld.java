import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * An empty small world with a cat.
 * 
 * @author Michael Kölling
 * @version 1.0
 */
public class CatWorld  extends World
{

    /**
     * Constructor for objects of class CatWorld.
     * 
     */
    public CatWorld()
    {    
        // Create a new world with 20x20 cells with a cell size of 10x10 pixels.
        super(600, 340, 1);
        addObject (new MyCat(), 300, 200);
    }
}
