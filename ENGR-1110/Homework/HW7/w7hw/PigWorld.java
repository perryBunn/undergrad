import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PigWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PigWorld extends World
{

    /**
     * Builds a PigWorld object.
     * 
     */
    public PigWorld()
    {    
        super(600, 400, 1, false); 
        setPaintOrder(Barrel.class, Pig.class, Mushroom.class);
        addObject(new Pig(), 400, 300);
        addObject(new Barrel(), 565, 350);
    }
    
    /**
     *  Adds mushrooms at the top of the screen at given intervals.
     */
    public void act() {
        if (Greenfoot.getRandomNumber(100) < 3) {
            addObject(new Mushroom(), Greenfoot.getRandomNumber(550), 0);
        }
    }
}
