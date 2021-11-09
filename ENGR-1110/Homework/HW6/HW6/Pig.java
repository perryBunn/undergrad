import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Pig here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pig extends Actor
{
    int eaten = 0;
    public void act() 
    {
        if (Greenfoot.mouseMoved(null)){
            MouseInfo mouse = Greenfoot.getMouseInfo();
            setLocation(mouse.getX(), mouse.getY());
        }
        
        if (eaten == 15) {
            Greenfoot.stop();
        }
        
        if (Greenfoot.mouseClicked(null)){
            Actor mushroom = getOneIntersectingObject(Mushroom.class);
            if (Mushroom.class != null){
                getWorld().removeObject(mushroom);
                eaten = eaten + 1;
            }
        }
    }    
}