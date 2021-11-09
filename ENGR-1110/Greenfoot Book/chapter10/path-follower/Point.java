/**
 * A simple point with x and y coordinates.
 * 
 * @author mik
 * @version 1.0
 */
public class Point  
{
    private int x;
    private int y;

    /**
     * Constructor for objects of class Point
     */
    public Point(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    /**
     * Return the x coordinate.
     */
    public int getX()
    {
        return x;
    }

    /**
     * Return the y coordinate.
     */
    public int getY()
    {
        return y;
    }
}
