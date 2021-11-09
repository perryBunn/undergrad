import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 *  A bomb can be used to explode balloons. 
 *  Based on a class created by Poul Henriksen.
 */
public class Bomb extends Actor
{

    /**
     * Check the mouse and make the bomb draggable.  
     *
     */  
    public void act() { 
        if (Greenfoot.mouseDragged(this)) {
            MouseInfo mouse = Greenfoot.getMouseInfo();
            setLocation(mouse.getX(), mouse.getY());
        }
        
        if (Greenfoot.mouseDragEnded(this)) {
            getWorld().addObject(new Explosion(), getX(), getY());
            List<Balloon> balloons = getObjectsInRange(100, Balloon.class);
            for (Balloon b : balloons) {
                getWorld().removeObject(b);
            }
            getWorld().removeObject(this);
        }
    }    

}
