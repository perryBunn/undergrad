import greenfoot.*;
import java.awt.Color;

/**
 * A canvas for a Kinect user to paint on. One canvas is created per user, and the user can paint
 * on it with her hands (right hand paints, left-hand-up erases, right-foot-up changes colour).
 * 
 * The canvas size is the same as the world size, and is initially entirely transparent. Essentially,
 * every user has their own transparent layer to paint on.
 * 
 * @author Neil Brown, Michael Kölling
 * @version 1.4
 */
public class Canvas extends Actor
{
    private static Color[] colors = { Color.GREEN, Color.RED, Color.BLUE, Color.BLACK, Color.GRAY, 
                                      Color.MAGENTA, Color.ORANGE, Color.PINK, Color.YELLOW };
    private UserData user;
    
    /**
     * Create a new canvas with a fully transparent image, initialized to a random paint color,
     * for the given user.
     */
    public Canvas(int width, int height, UserData user)
    {
        this.user = user;
        setImage(new GreenfootImage(width, height));
        getImage().setColor(randomColor());
    }

    /**
     * Interpret the user's gestures and do the appropriate action.
     */
    public void act() 
    {
        // paint
        Joint rightHand = user.getJoint(Joint.RIGHT_HAND);
        if (user.getNearestJoint() == Joint.RIGHT_HAND) {
            getImage().fillOval(rightHand.getX(), rightHand.getY(), 20, 20);
        }

        // erase if left hand up
        if (user.getJoint(Joint.LEFT_HAND).getY() < user.getJoint(Joint.HEAD).getY())
        {
            getImage().clear();
        }

        // change colour if right foot up
        if (user.getJoint(Joint.RIGHT_FOOT).getY() < user.getJoint(Joint.LEFT_KNEE).getY())
        {
            getImage().setColor(randomColor());
        }
    }
    
    /**
     * Select a random color from the color array provided.
     */
    private Color randomColor()
    {
        return colors[Greenfoot.getRandomNumber(colors.length)];
    }
}
