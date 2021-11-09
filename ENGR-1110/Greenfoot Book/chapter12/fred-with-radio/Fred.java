import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * A kinect user avatar.
 * 
 * @author Michael Kölling
 * @version 1.1
 */
public class Fred extends Actor
{
    private static final GreenfootImage noImage = new GreenfootImage(1, 1);
    private static final GreenfootImage seeUser = new GreenfootImage("see-user.png");

    //                    HEAD/NECK/TORS/L-SH/L-EB/L-HD/R-SH/R-EB/R-HD/L-HP/L-KN/L-FT/R-HP/R-KN/R-FT
    float[] defaultX   = {400, 400, 400, 365, 325, 360, 435, 500, 450, 375, 355, 380, 425, 445, 425};
    float[] defaultY   = {155, 215, 275, 215, 285, 350, 215, 275, 340, 335, 415, 520, 335, 415, 520};

    private Point[] dot;
    private BodyPart[] body;
    private UserData defaultPose;
    private GreenfootImage[] heads;
   

    public Fred()
    {
        defaultPose = setUpPose(defaultX, defaultY);
    }

    public void addedToWorld(World world)
    {
        createBody(world);
    }

    /**
     */
    public void act() 
    {
        UserData user = ((MyWorld)getWorld()).getUser(0);

        if ((user != null) && user.isTracking()) {
            trackUser(user);
        }
        else {
            // no user visible
            trackUser(defaultPose);
        }
        checkHands();
    }    

    /**
     * Display a tracked user on screen
     */
    private void trackUser(UserData user)
    {
        for (int i = 0; i < Joint.NUM_JOINTS; i++) {
            Joint joint = user.getJoint(i);
            dot[i].set (joint.getX(), joint.getY());
        }
    }

    private void createBody(World world)
    {
        // Create a Point to follow each joint position
        dot = new Point[Joint.NUM_JOINTS];
        for (int i = 0; i < dot.length; i++) {
            dot[i] = new Point();
        }
        dot[2].setYOffset(80);  // move centre body point down to use as hip point
        trackUser(defaultPose); // set up dots for default pose
        
        // Create body part between softPoints
        body = new BodyPart[10];
        body[0] = new BodyPart("head.png", dot[0], dot[1], 0, -20);    // head
        body[0].dontStretch();
        body[1] = new BodyPart("arm.png", dot[3], dot[4]);                  // left arm
        body[2] = new BodyPart("arm.png", dot[6], dot[7]);                  // right arm
        body[3] = new BodyPart("left-hand.png", dot[5], dot[4]);
        body[4] = new BodyPart("right-hand.png", dot[8], dot[7]);
        body[5] = new BodyPart("left-leg.png", dot[9], dot[10], 0, -10);                 // left leg
        body[6] = new BodyPart("right-leg.png", dot[12], dot[13], 0, -10);                 // right leg
        body[7] = new BodyPart("left-foot.png", dot[10], dot[11], 0, -40);
        body[8] = new BodyPart("right-foot.png", dot[13], dot[14], 0, -40);
        body[9] = new BodyPart("body.png", dot[1], dot[2]);                 // body centre

        for (int i = body.length-1; i >= 0; i--) {
            world.addObject(body[i], world.getWidth()/2, world.getHeight()/2);
        }
    }

    /**
     * Initialise the coordinates for the default body poses (used when we cannot
     * see a user).
     */
    private UserData setUpPose(float[] x, float[] y)
    {
        UserData pose = new UserData(-1);

        for (int i = 0; i < x.length; i++) {
            float cx = (float) (x[i] * MyWorld.SCALE);
            float cy = (float) (y[i] * MyWorld.SCALE);
            pose.setJoint(i, new Joint(i, 1.0f, null, new Point3D(cx, cy, 0.0f)));
        }

        return pose;
    }

    /**
     * Check whether a hand (of any user) touches the radio. Play radio if it does.
     */
    public void checkHands()
    {        
        MyWorld world = (MyWorld)getWorld();
        UserData[] users = world.getTrackedUsers();
        
        for (UserData user : users)
        {
            Joint rightHand = user.getJoint(Joint.RIGHT_HAND);            
            Radio radio = getRadio(rightHand.getX(), rightHand.getY());
            
            if(radio != null) {  // yes, there was a radio
                radio.play(1);
            }
            else {
                Joint leftHand = user.getJoint(Joint.LEFT_HAND);
                radio = getRadio(leftHand.getX(), leftHand.getY());
                if(radio != null) {  
                    radio.play(2);
                }
            }
        }
    }
    
    /**
     * Check whether there is a radio at coordinate x,y. Return the radio if there
     * is, or return null if there is no radio.
     */
    private Radio getRadio(int x, int y)
    {
        List<Radio> radioList = getWorld().getObjectsAt(x, y, Radio.class);
        if(!radioList.isEmpty()) {
            return radioList.get(0);
        }
        else {
            return null;
        }
    }
    
}
