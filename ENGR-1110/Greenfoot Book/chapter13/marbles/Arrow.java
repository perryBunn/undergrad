import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This class provides an arrow that can be stretched and rotated to
 * point in different directions.
 */
public class Arrow extends Actor
{
    private GreenfootImage image;  // original, full size image
    
    public Arrow()
    {
        this (150, 150);
    }
    
    /**
     * Create an arrow. The size is defined by the x/y distance of its
     * end point from its origin.
     */
    public Arrow(int dx, int dy)
    {
        image = getImage();
        setImage(dx, dy);
    }
    
    /**
     * Change the arrow. The new size and direction is defined by the x/y 
     * distance of its end point from its origin. The arrow will be drawn from
     * this actors position (the centre point) to the specified offset.
     */
    public void setImage(int dx, int dy)
    {
        int direction = (int) Math.toDegrees(Math.atan2(dx, dy));
        int length = (int) Math.sqrt(dx*dx+dy*dy) + 30;

        GreenfootImage img = new GreenfootImage(image); // copy of original
        img.scale(length*2, 300);
        setRotation(-direction-90);
        setImage(img);
    }
}
