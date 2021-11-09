import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A balloon flows from bottom to top.
 * Based on a class created by Poul Henriksen.
 */
public class Balloon extends Actor {
    
    /**
     * Move vertically one pixel. Stop the scenario if
     * this balloon is past the top edge of the visible
     * world.
     */
    public void act() {
        setLocation(getX(), getY() - 1);
        if (getY() < (0 - getImage().getHeight())) {
            Greenfoot.stop();
        }
    }

}
