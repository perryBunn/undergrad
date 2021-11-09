import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)
import java.awt.Color;

/**
 * Space. Something for rockets to fly in...
 * 
 * @author Michael Kölling
 * @version 2.0
 */
public class Space extends World
{
    /**
     * Create the space world with black background and stars.
     */
    public Space() 
    {
        super(800, 600, 1);
        GreenfootImage background = getBackground();
        background.setColor(Color.BLACK);
        background.fill();
        createStars(300);
        Explosion.initialiseImages();
    }
    
    /**
     * Create some random stars in the world
     */
    private void createStars(int number) 
    {
        GreenfootImage background = getBackground();             
        for (int i=0; i < number; i++) {            
             int x = Greenfoot.getRandomNumber( getWidth() );
             int y = Greenfoot.getRandomNumber( getHeight() );
             int color = 150 - Greenfoot.getRandomNumber(120);
             background.setColorAt(x, y, new Color(color,color,color));
        }
    }
}