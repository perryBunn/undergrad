import greenfoot.*;
import java.awt.Color;

/**
 * A canvas for a Kinect user to paint on. One canvas is created per user.
 * 
 * The canvas size is the same as the world size, and is initially entirely transparent. Essentially,
 * every user has their own transparent layer to paint on.
 * 
 * @author Michael Kölling
 * @version 0.5
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
        // use variable 'user' to get access to user data for the user associated with this canvas
    }
    
    /**
     * Select a random color from the color array provided.
     */
    private Color randomColor()
    {
        return colors[Greenfoot.getRandomNumber(colors.length)];
    }
}
