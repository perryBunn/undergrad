import greenfoot.*;

/**
 * One of the limbs of our figure.
 * 
 * @author Michael Kölling
 * @version 1.0
 */
public class BodyPart extends Actor
{
    private Point start;
    private Point end;
    private int xOffset;
    private int yOffset;
    private boolean stretch;
    private GreenfootImage origImage;  // the original (unstretched/-rotated) image
    
    public BodyPart(Point start, Point end)
    {
        this("line.png", start, end);
    }
    
    public BodyPart(String image, Point start, Point end)
    {
        this(image, start, end, 0, 0);
    }
    
    public BodyPart(Point start, Point end, int xOffs, int yOffs)
    {
        this("line.png", start, end, xOffs, yOffs);
    }
    
    public BodyPart(String imageName, Point start, Point end, int xOffs, int yOffs)
    {
        this(new GreenfootImage(imageName), start, end, xOffs, yOffs);
    }
    
    public BodyPart(GreenfootImage image, Point start, Point end, int xOffs, int yOffs)
    {
        origImage = image;
        this.start = start;
        this.end = end;
        xOffset = xOffs;
        yOffset = yOffs;
        stretch = true;
    }
    
    public void addedToWorld(World world)
    {
        adjustImage();
    }
    
    /**
     * Use a new image as the base image for this body part.
     */
    public void useImage(GreenfootImage image)
    {
        origImage = image;
        adjustImage();
    }
    
    /**
     * Act - do whatever the BodyPart wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        adjustImage();
    }

    public void dontStretch()
    {
        stretch = false;
    }

    /**
     * Adjust this image to fit it's two end points (i.e. position, stretch and 
     * rotate as required).
     */
    private void adjustImage()
    {
        GreenfootImage img = new GreenfootImage(origImage);
        int midX = (end.getX() + start.getX())/2;
        int midY = (end.getY() + start.getY())/2;
        int deltaX = end.getX() - start.getX();
        int deltaY = end.getY() - start.getY();
        
        if (stretch) {
            int width = img.getWidth();
            int height = (int) Math.sqrt(deltaX*deltaX + deltaY*deltaY) + 1;
            img.scale(width, height);
        }
        setImage(img);
        setRotation((int) (180 * Math.atan2(deltaY, deltaX) / Math.PI) - 90);        
        setLocation (midX+xOffset, midY+yOffset);
    }

}






