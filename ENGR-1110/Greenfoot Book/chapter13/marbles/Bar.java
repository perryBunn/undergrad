import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bar extends Actor
{
    public Bar()
    {
        this (false);
    }
    
    public Bar(boolean vertical)
    {
        if (vertical) {
            setImage ("bar-vertical.png");
        }
        else {
            setImage ("bar.png");
        }
    }
    
    /**
     * Act - do whatever the Bar wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
}
