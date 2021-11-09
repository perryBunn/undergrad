import greenfoot.*; 
import java.awt.Color;
import java.util.HashMap;
import java.util.Collection;

/**
 * A Kinect world that lets you paint with your hands.
 * 
 * @author Neil Brown, Michael Kölling
 * @version 1.4
 */
public class PaintWorld extends KinectWorld
{
    private static final int THUMBNAIL_WIDTH = 80;
    private static final int THUMBNAIL_HEIGHT = 60;

    private final int WIDTH = getWidth();
    private final int HEIGHT = getHeight();

    private HashMap<UserData, Canvas> users;

    /**
     * Create our paint world with a small thumbnail camera image in the bottom corner.
     */
    public PaintWorld()
    {    
        super(THUMBNAIL_WIDTH, THUMBNAIL_HEIGHT, 1.0, false);

        users = new HashMap<UserData, Canvas>();
        addObject(new Thumbnail(), WIDTH - THUMBNAIL_WIDTH/2, HEIGHT - THUMBNAIL_HEIGHT/2);
    }

    /**
     * Act: show users as stick figures.
     */
    public void act()
    {
        super.act();
        processUsers();
    } 

    /**
     * For every tracked user, paint a stick figure and maintain a canvas.
     */
    private void processUsers()
    {
        UserData[] trackedUsers = getTrackedUsers();
        
        paintStickFigures(trackedUsers);
        manageCanvases(trackedUsers);
    }

    /**
     * Make sure canvas objects match tracked users: Create new canvas objects if
     * we see new users entering our image, and remove canvas objects for users 
     * no longer there.
     */
    private void manageCanvases(UserData[] trackedUsers)
    {
        HashMap<UserData, Canvas> tmpUsers = new HashMap<UserData, Canvas>();

        for (UserData user: trackedUsers)
        {
            Canvas canvas = users.get(user);
            if (canvas == null) {               // not found - this is a new user
                Canvas newCanvas = new Canvas(WIDTH, HEIGHT, user);
                tmpUsers.put(user, newCanvas);
                addObject(newCanvas, WIDTH/2, HEIGHT/2);
            }
            else {
                // move existing user to new list
                tmpUsers.put(user, canvas);
                users.remove(user);
            }
        }

        // remove canvasses of users that are no longer tracked
        Collection<Canvas> canvasses = users.values();
        removeObjects(canvasses);

        users = tmpUsers;
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
