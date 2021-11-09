import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class wImage here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class wImage extends Actor
{
    private GreenfootImage W = new GreenfootImage("W.png");
    private GreenfootImage WDark = new GreenfootImage("Wdark.png");
    public void act() 
    {
        if(Greenfoot.isKeyDown("w")){
            setImage(WDark);
        } else {
            setImage(W);
        }
    }
}
