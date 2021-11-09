import greenfoot.*; 
import java.awt.Color;

/**
 * This Greep is a small creatures that likes to walk on a path.
 * It will follow a path if it is set on one.
 * It recognises the path by colour: everything that looks reddish/brownish is a path.
 * 
 * @author Michael Kölling
 * @version 1.0
 */
public class Greep extends Actor
{
    /**
     * Constructor for Greep - nothing to do.
     */
    public Greep()
    {
    }
    
    /**
     * Move and follow the path. This is done by looking at the colour of the ground
     * at the position of the eyes. If the ground is not brown, turn a bit sideways.
     */
    public void act()
    {
        if ( !isPath(leftEyeColor()) )
        {
            turn(20);
        }
        else if ( !isPath(rightEyeColor()) )
        {
            turn(-20);
        }
        move(2);
    }
    
    /**
     * Return the color under the left eye.
     */
    private Color leftEyeColor()
    {
        Point eyePos = leftEye();
        
        // work to do here!
        
        return null;  // this is incomplete - fix it
    }

    /**
     * Return the color under the right eye.
     */
    private Color rightEyeColor()
    {
        Point eyePos = rightEye();
        
        // work to do here!
        
        return null;  // this is incomplete - fix it
    }
    
    /**
     * Return true if the given colour is recognised as the path to follow.
     */
    private boolean isPath (Color col)
    {
        // work to do here!        
        return true;  // this is incomplete - fix it
    }
    
    // The location of the eyes, measured from the Greep's position and direction
    private int EYE_OFFSET = 16;
    private int EYE_ANGLE = 20;
    
    /**
     * Return the position of the left eye.
     */
    public Point leftEye()
    {
        return eyePosition(-EYE_ANGLE, EYE_OFFSET);
    }

    /**
     * Return the position of the right eye.
     */
    public Point rightEye()
    {
        return eyePosition(EYE_ANGLE, EYE_OFFSET);
    }

    /**
     * Return the position of an eye. The parameters define the eye's location
     * on the greep's body.
     * 
     * @param angle The angle of the vector to the eye from the current rotation.
     * @param distance The distance of the eye from our centre point.
     * @return The Point (in global coordinates) where the eye is.
     */
    public Point eyePosition(int angle, int distance)
    {
        double angleRad = Math.toRadians( getRotation() + angle);
        int x = (int) Math.round(getX() + Math.cos(angleRad) * distance);
        int y = (int) Math.round(getY() + Math.sin(angleRad) * distance);
        
        return new Point(x, y);
    }

}