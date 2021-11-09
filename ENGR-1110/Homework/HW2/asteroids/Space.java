import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)
import java.awt.Color;

/**
 * Space. Something for rockets to fly in...
 * 
 * @author Michael Kolling
 */
public class Space extends World
{
    public Space() 
    {
        super(600, 400, 1);
        GreenfootImage background = getBackground();
        background.setColor(Color.BLACK);
        background.fill();
        createStars(500);
        createAsteroids(5);
        createRocket();
        Explosion.initialiseImages();
    }

    private void createStars(int number) 
    {
        GreenfootImage background = getBackground();             
        for(int i=0; i < number; i++) {            
            int x = Greenfoot.getRandomNumber( getWidth() );
            int y = Greenfoot.getRandomNumber( getHeight() );
            int color = 150 - Greenfoot.getRandomNumber(120);
            background.setColorAt(x,y,new Color(color,color,color));
        }
    }

    private void createAsteroids(int number) {
        for(int i=0; i < number; i++) {
            int x = Greenfoot.getRandomNumber( getWidth() );
            int y = Greenfoot.getRandomNumber( getHeight() );
            addObject(new Asteroid(), x, y);
        }
    }
    
    private void createRocket() {
        addObject(new Rocket(), 300, 350);
    }
}