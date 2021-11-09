import greenfoot.*; 
import java.awt.Color;

/**
 * A very simple Kinect world showing the stick figure feature.
 * 
 * @author Michael Kölling
 * @version 1.0
 */
public class StickWorld extends KinectWorld
{
    private static final int THUMBNAIL_WIDTH = 80;
    private static final int THUMBNAIL_HEIGHT = 60;

    /**
     * Create our paint world with a small thumbnail camera image in the bottom corner.
     */
    public StickWorld()
    {    
        super(THUMBNAIL_WIDTH, THUMBNAIL_HEIGHT, 1.0, false);
    }

    /**
     * Act: show users as stick figures.
     */
    public void act()
    {
        super.act();
        UserData[] trackedUsers = getTrackedUsers();
        paintStickFigures(trackedUsers);
    }

    /**
     * Paint stick figures on the world background for every user we can see.
     */
    private void paintStickFigures(UserData[] trackedUsers)
    {
        eraseBackground();

        for (UserData user: trackedUsers)
        {
            user.drawStickFigure(getBackground(), 60);
        }
    }

    /**
     * Erase the world backgorund.
     */
    private void eraseBackground()
    {
        getBackground().setColor(Color.WHITE);
        getBackground().fill();
    }   
}
