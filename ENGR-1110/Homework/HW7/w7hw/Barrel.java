import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class Barrel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Barrel extends Actor
{
    private final double SCALE_FACTOR = 1.05;
    private final int MAX_SIZE = 10;
    private int size;
    /**
     * Automatically called by Greenfoot whenever a Barrel object
     * is placed in a world. In this assigment, we use it to remember
     * the initial state of this barrel - its (x,y) position and its
     * original image size.
     */
    public void addedToWorld(World world) {
        setLocation(565,350);
        size = 1;
    }
    
    /**
     * Returns how many mushrooms this barrel has stored.
     */
    public int getMushrooms() {
        return size;
    }
    
    /**
     * Follows mouse drag-and-drop motion. Eats nearby mushrooms when
     * dropped and increases its current image scale by 25%. If this barrel
     * stores more than 10 mushrooms, this barrel has itself removed from
     * this world.
     */
    public void act() {
        if (Greenfoot.mouseDragged(this)) {
            MouseInfo mouse = Greenfoot.getMouseInfo();
            setLocation(mouse.getX(), mouse.getY());
        }
        if (Greenfoot.mouseDragEnded(this)) {
            List<Mushroom> Mushroom  = getObjectsInRange(75, Mushroom.class);
            for (Mushroom M : Mushroom) {
                getWorld().removeObject(M);
                GreenfootImage img = getImage();
                int width = (int) (img.getWidth()*SCALE_FACTOR);
                int height = (int) (img.getHeight()*SCALE_FACTOR);
                img.scale(width, height);
                size = size + 1;
                if(size == MAX_SIZE) {
                    getWorld().removeObject(this);
                }
            }
        }
    }   
    
    /**
     * Returns this barrel to its original (x,y) location and its
     * original image scale.
     */
    public void reset() {
        setLocation(565, 360);
        size = 1;
    }
 
}
