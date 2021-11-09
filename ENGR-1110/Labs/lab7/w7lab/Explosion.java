import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

import java.util.*;

/**
 * An explosion. It starts by expanding and then collapsing. 
 * The explosion will explode other objects that the explosion intersects.
 * 
 * Based on a class created by Poul Henriksen.
 */
public class Explosion extends Actor {
    private final double SCALE_FACTOR = 1.25;
    private final int MAX_SIZE = 8;
    private int size;
    
    public Explosion() {
        setImage(new GreenfootImage("explosion.png"));
        size = 1;
    }
    
    public void act() {
        GreenfootImage img = getImage();
        int width = (int)(img.getWidth() * SCALE_FACTOR);
        int height = (int)(img.getHeight() * SCALE_FACTOR);
        img.scale(width, height);
        size = size + 1;
        if (size == MAX_SIZE) {
            getWorld().removeObject(this);
        }
    }
    
}
