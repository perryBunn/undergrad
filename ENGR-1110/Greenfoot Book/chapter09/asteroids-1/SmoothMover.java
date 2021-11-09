import greenfoot.*;

/**
 * A variation of an actor that maintains precise location (using doubles for the co-ordinates
 * instead of ints). It also maintains a current velocity in form of a velocity vector.
 * 
 * This is a variation of the SmoothMover class presented ealier in the book (version 2.0).
 * This version implements wrap-around movement: when the actor moves out of the world at one
 * side, it enters it again at the opposite edge.
 * 
 * @author Poul Henriksen
 * @author Michael Kölling
 * 
 * @version 2.3
 */
public abstract class SmoothMover extends Actor
{
    private Vector velocity;
    
    private double exactX;
    private double exactY;
    
    public SmoothMover()
    {
        this(new Vector());
    }
    
    /**
     * Create new Mover initialised with given velocity.
     */
    public SmoothMover(Vector velocity)
    {
        this.velocity = velocity;
    }
    
    /**
     * Move in the direction of the velocity vector. This simulates movement in one 
     * time unit (dt==1). Wrap around to the opposite edge of the screen if moving out of the world.
     */
    public void move() 
    {
        exactX = exactX + velocity.getX();
        exactY = exactY + velocity.getY();
        if (exactX >= getWorld().getWidth()) {
            exactX = 0;
        }
        if (exactX < 0) {
            exactX = getWorld().getWidth() - 1;
        }
        if (exactY >= getWorld().getHeight()) {
            exactY = 0;
        }
        if (exactY < 0) {
            exactY = getWorld().getHeight() - 1;
        }
        super.setLocation((int) exactX, (int) exactY);
    }
    
    /**
     * Set the location using exact (double) co-ordinates.
     */
    public void setLocation(double x, double y) 
    {
        exactX = x;
        exactY = y;
        super.setLocation((int) x, (int) y);
    }
    
    /**
     * Set the location of this actor. Redefinition of the standard Greenfoot 
     * method to make sure the exact co-ordinates are updated in sync.
     */
    public void setLocation(int x, int y) 
    {
        exactX = x;
        exactY = y;
        super.setLocation(x, y);
    }

    /**
     * Return the exact x-coordinate (as a double).
     */
    public double getExactX() 
    {
        return exactX;
    }

    /**
     * Return the exact y-coordinate (as a double).
     */
    public double getExactY() 
    {
        return exactY;
    }

    /**
     * Modify velocity by adding another velocity vector.
     */
    public void addToVelocity(Vector boost) 
    {
        velocity.add(boost);
    }
    
    /**
     * Accelerate the speed of this mover by the given factor. (Factors less than 1 will
     * decelerate.) The direction remains unchanged.
     */
    public void accelerate(double factor)
    {
        velocity.scale(factor);
        if (velocity.getLength() < 0.15) 
        {
            velocity.setNeutral();
        }
    }
    
    /**
     * Return the speed of this actor.
     */
    public double getSpeed()
    {
        return velocity.getLength();
    }
    
    /**
     * Revert velocity horizontally.
     */
    public void invertHorizontalVelocity()
    {
        velocity.revertHorizontal();
    }
    
    /**
     * Revert velocity vertically.
     */
    public void invertVerticalVelocity()
    {
        velocity.revertVertical();
    }
    
    /**
     * Return the current speed.
     */
    public Vector getVelocity() 
    {
        return velocity.copy();
    }
}
