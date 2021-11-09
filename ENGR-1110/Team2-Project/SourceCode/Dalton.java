import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class kangaroo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Dalton extends Enemy
{
    private int x;
    private int y;
    private GreenfootImage dalton = new GreenfootImage("greenfoot.png");
    /**
     * Act - do whatever the Dalton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (Room.timer%60 == 30){
            if (Greenfoot.getRandomNumber(5) == 2) {
            x = Greenfoot.getRandomNumber(500);
            y = Greenfoot.getRandomNumber(500);
            setLocation((x + (12 - (x % 25))), (y+ (12 - (y % 25))));
        }
        }
    }    
}