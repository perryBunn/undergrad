import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Mushroom here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Mushroom extends Actor
{

    public void act() 
    {
        setLocation(getX(), getY() + 1);
        if (getY() > (400 + getImage().getHeight())){
            Greenfoot.stop();
        }
    }    
}
