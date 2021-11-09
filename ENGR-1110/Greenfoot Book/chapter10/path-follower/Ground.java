import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A background with a path drawn on it. Two different backgrounds are available.
 * 
 * @author Michael Kölling
 * @version 1.0
 */
public class Ground  extends World
{

    /**
     * Create the field.
     */
    public Ground()
    {    
        // Create a new world with 20x20 cells with a cell size of 10x10 pixels.
        super(800, 540, 1);
        showMap2();
        addObject( new Greep(), 180, 450);
    }
    
    public void showMap1()
    {
        setBackground("ground.png");
    }
    
    public void showMap2()
    {
        setBackground("ground2.png");
    }

}
