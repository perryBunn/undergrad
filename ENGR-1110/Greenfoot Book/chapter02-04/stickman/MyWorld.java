import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The Stickman world. Very simple; just place a stickman.
 * 
 * @author mik
 * @version 1.0
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     */
    public MyWorld()
    {    
        super(750, 500, 1); 
        addObject(new Stickman(), 375, 325);
    }
}
