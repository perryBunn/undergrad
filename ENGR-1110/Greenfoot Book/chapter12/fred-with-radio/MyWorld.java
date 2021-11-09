import greenfoot.*;

/**
 * A user avatar world with a playable radio.
 * 
 * @author Michael Kölling
 * @version 1.2
 */
public class MyWorld extends KinectWorld
{
    public static final double SCALE = 1.0;

    private static final int THUMBNAIL_WIDTH = 80;
    private static final int THUMBNAIL_HEIGHT = 60;

    private Fred fred;
    private UserData[] users;

    public MyWorld()
    {    
        super(THUMBNAIL_WIDTH, THUMBNAIL_HEIGHT, SCALE, false);
        
        final int width = getWidth();
        final int height = getHeight();
        
        addObject(new Thumbnail(), width - THUMBNAIL_WIDTH/2, height - THUMBNAIL_HEIGHT/2);
        
        users = new UserData[0];
        fred = new Fred();
        addObject(new Radio(), width/2+100, 80);
        addObject(fred, (int)(400*SCALE), (int)(300*SCALE));
    }
    
    public void act()
    {
        super.act();
        users = getTrackedUsers();
    }

    public UserData getUser(int ID)
    {
        if (ID >= users.length) {
            return null;
        }
        return users[ID];
    }
}
