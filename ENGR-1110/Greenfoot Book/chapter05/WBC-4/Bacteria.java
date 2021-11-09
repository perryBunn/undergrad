import greenfoot.*;  

/**
 * Bacteria fload along in the bloodstream. They are bad. Best to destroy
 * them if you can.
 * 
 * @author Michael Kölling
 * @version 1.0
 */
public class Bacteria extends Actor
{
    private int speed;

    /**
     * Constructor: Initialise the speed to a somewhat random value.
     */
    public Bacteria()
    {
        speed = Greenfoot.getRandomNumber(5) + 1;
    }
    
    /**
     * Float along the bloodstream, slowly rotating.
     */
    public void act() 
    {
        setLocation(getX()-speed, getY());
        turn(1);
        
        if (getX() == 0) 
        {
            Bloodstream bloodstream = (Bloodstream)getWorld();
            bloodstream.addScore(-15);
            bloodstream.removeObject(this);
        }
    }
    
}
