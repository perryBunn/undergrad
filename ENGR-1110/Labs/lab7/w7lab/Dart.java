import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A dart is used to pop balloons.
 * Based on class created by Poul Henriksen.
 */
public class Dart extends Actor
{
    /**
     * Make the dart follow the mouse and check for mouseclicks.
     */
    public void act() {
        if (Greenfoot.mouseMoved(null)) {
            MouseInfo mouse = Greenfoot.getMouseInfo();
            setLocation(mouse.getX(), mouse.getY());
        }
        if (Greenfoot.mouseClicked(null)) {
            Actor balloon = getOneIntersectingObject(Balloon.class);
            if (balloon != null) {
                getWorld().removeObject(balloon);
            }
        }
    }    
}
