import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Point - .
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Point 
{
    private double x;
    private double y;
    private double yOffset;
    
    public Point()
    {
    }

    /**
     * Define an offset for the reported position from the actual position in the y axis.
     */
    public void setYOffset(double offset)
    {
        yOffset = offset;
    }
    
    public void set(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
    
    /**
     * Return the current X coordinate.
     */
    public int getX()
    {
        return (int)x;
    }

    /**
     * Return the current Y coordinate.
     */
    public int getY()
    {
        return (int)(y + yOffset);
    }

    public String toString()
    {
        return "Point (" + x +"," + y + ")";
    }
}
