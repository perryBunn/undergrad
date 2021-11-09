import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

/**
 * This is a colored floating bubble.
 *
 * @author Michael Kölling
 * @version 1.0
 */
public class Bubble extends Actor
{
    private int speed;
    
    /**
     * Create a Bubble that floats, with random size and random color.
     */
    public Bubble()
    {
        // create a random size, between 10 and 110 pixels
        this(Greenfoot.getRandomNumber(100) + 10);
    }
    
    /**
     * Create a Bubble that floats, with a given size and random color.
     */
    public Bubble(int size)
    {
        GreenfootImage img = new GreenfootImage(size, size);

        // create a random color, with every color channel between 30 and 230
        int red = Greenfoot.getRandomNumber(200) + 30;
        int green = Greenfoot.getRandomNumber(200) + 30;
        int blue = Greenfoot.getRandomNumber(200) + 30;
        int alpha = Greenfoot.getRandomNumber(190) + 60;
        
        img.setColor(new Color(red, green, blue, alpha));
        img.fillOval(0, 0, size-1, size-1);
        setImage(img);
        
        // random speed: 1 to 4
        speed = Greenfoot.getRandomNumber(4) + 1;
    }
    
    /**
     * Create a Bubble that floats, with given size and initial float direction.
     */
    public Bubble(int size, int direction)
    {
        this(size);
        setRotation(direction);
    }
    
    /**
     * Float.
     */
    public void act() 
    {
        if (isAtEdge()) {
            turn(180);
        }
        
        move(speed);
        
        if (Greenfoot.getRandomNumber(100) < 50) {
            turn(Greenfoot.getRandomNumber(5) - 2);   // -2 to 2
        }
    }
}
