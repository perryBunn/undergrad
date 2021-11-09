import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class aImage here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class aImage extends Actor
{
    private GreenfootImage A = new GreenfootImage("A.png");
    private GreenfootImage aDark = new GreenfootImage("Adark.png");
    public void act() 
    {
        if(Greenfoot.isKeyDown("a")){
            setImage(aDark);
        } else {
            setImage(A);
        }
    }    
}
