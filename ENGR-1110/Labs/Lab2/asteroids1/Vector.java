/**
 * A 2D vector.
 * 
 * @author Poul Henriksen
 * @author Michael Kölling
 * 
 * @version 2.0
 */
public class Vector
{
    double dx = 0;
    double dy = 0;
    int direction = 0;
    double length;
    
    /**
     * Create a default vector initialised to zero.
     */
    public Vector()
    {
    }

    /**
     * Create a vector with given direction and length.
     */
    public Vector(int direction, double length)
    {
       this.length = length;
       this.direction = direction;
       dx = length * Math.cos(Math.toRadians(direction));
       dy = length * Math.sin(Math.toRadians(direction));    
    }

    /**
     * Set the direction of this vector.
     */
    public void setDirection(int direction) 
    {
        this.direction = direction;
        dx = length * Math.cos(Math.toRadians(direction));
        dy = length * Math.sin(Math.toRadians(direction));   
    }
   
    /**
     * Add another vector to this vector.
     */
    public void add(Vector other) 
    {
        dx += other.dx;
        dy += other.dy;    
        this.direction = (int) Math.toDegrees(Math.atan2(dy, dx));
        this.length = Math.sqrt(dx*dx+dy*dy);
    }   
    
    /**
     * Return the x offset of this vector.
     */
    public double getX() 
    {
        return dx;
    }
     
    /**
     * Return the y offset of this vector.
     */
    public double getY() 
    {
        return  dy;
    }
    
    /**
     * Return the current direction (in degrees).
     */
    public int getDirection() 
    {
        return direction;
    }
    
    /**
     * Return the current length of the vector.
     */
    public double getLength() 
    {
        return length;
    }
    
    /**
     * Create a copy of this vector.
     */
    public Vector copy() 
    {
        Vector copy = new Vector();
        copy.dx = dx;
        copy.dy = dy;
        copy.direction = direction;
        copy.length = length;
        return copy;
    }    
}