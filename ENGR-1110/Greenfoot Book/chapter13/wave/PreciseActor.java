import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)

/**
 * An actor superclass that maintains precision location (doubles instead of ints).
 * 
 * @author M Kolling
 * @version 1.0
 */
public abstract class PreciseActor extends Actor
{
    private double x;
    private double y;
    
    public double getExactX() {
        return x;
    }
     
    public double getExactY() {
        return y;
    }
    
    /**
     * A new setLocation method that uses rounded values for display on screen, but
     * maintains precision values for further movement and computation.
     */
    public void setLocation(double x, double y) 
    {
        this.x = x;
        this.y = y;
        super.setLocation((int) x, (int)y);
    }
    
    /**
     * Overriding the inherited setLocation method so that we store the location locally
     * before using it to set the location.
     */
    public void setLocation(int x, int y) 
    {
        this.x = x;
        this.y = y;
        super.setLocation(x, y);
    }
}
