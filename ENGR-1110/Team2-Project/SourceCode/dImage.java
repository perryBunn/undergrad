import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class dImage here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class dImage extends Actor
{
    private GreenfootImage D = new GreenfootImage("D.png");
    private GreenfootImage dDark = new GreenfootImage("Ddark.png");
    public void act() 
    {
        if(Greenfoot.isKeyDown("d")){
            setImage(dDark);
        } else {
            setImage(D);
        }
    } 
}    

