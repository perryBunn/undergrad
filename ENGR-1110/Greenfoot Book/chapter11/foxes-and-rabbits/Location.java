/**
 * Represent a location in a rectangular grid.
 * 
 * @author mik
 * @version 1.0
 */
public class Location
{
     // x and y coordinates.
    private final int x;
    private final int y;

    /**
     * Represent a coordinate.
     * @param x The horizontal coordinate.
     * @param y The vertical coordinate.
     */
    public Location(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
    
    /**
     * Implement content equality.
     */
    public boolean equals(Object obj)
    {
        if(obj instanceof Location) {
            Location other = (Location) obj;
            return x == other.getX() && y == other.getY();
        }
        else {
            return false;
        }
    }
    
    /**
     * Return a string of the form x,y
     * @return A string representation of the location.
     */
    public String toString()
    {
        return x + "," + y;
    }
    
    /**
     * Use the top 16 bits for the x value and the bottom for
     * the y. Except for very big grids, this should give a
     * unique hash code for each (x, y) pair.
     * @return A hashcode for the location.
     */
    public int hashCode()
    {
        return (x << 16) + y;
    }
    
    /**
     * @return The x.
     */
    public int getX()
    {
        return x;
    }
    
    /**
     * @return The y.
     */
    public int getY()
    {
        return y;
    }
}
