import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class sImage here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class sImage extends Actor
{
    private GreenfootImage S = new GreenfootImage("S.png");
    private GreenfootImage sDark = new GreenfootImage("Sdark.png");
    public void act() 
    {
        if(Greenfoot.isKeyDown("s")){
            setImage(sDark);
        } else {
            setImage(S);
        }
    }
}
