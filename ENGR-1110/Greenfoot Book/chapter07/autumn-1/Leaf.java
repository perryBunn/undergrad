import greenfoot.*;

/**
 * A floating leaf that blows across the screen.
 *
 * @author Michael Kölling
 * @version 1.0
 */
public class Leaf extends Actor
{
    private int speed;
    GreenfootImage img1 = new GreenfootImage("leaf-green.png");
    GreenfootImage img2 = new GreenfootImage("leaf-brown.png");
    
    /**
     * Create the leaf.
     */
    public Leaf()
    {
        setImage(img1);
        speed = Greenfoot.getRandomNumber(3) + 1;      // random speed: 1 to 3
        setRotation(Greenfoot.getRandomNumber(360));
    }
    
    /**
     * Move around.
     */
    public void act() 
    {
        if (isAtEdge()) 
        {
            turn(180);
        }
        
        move(speed);
        
        if (Greenfoot.getRandomNumber(100) < 50) 
        {
            turn(Greenfoot.getRandomNumber(5) - 2);   // -2 to 2
        }
    }
    
    /**
     * Change the image to another leaf image. This toggles back and
     * forth between two images.
     */
    public void changeImage()
    {
        if (getImage() == img1) 
        {
            setImage(img2);
        }
        else {
            setImage(img1);
        }
    }
}
