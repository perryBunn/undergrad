import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

/**
 * Space. The final frontier. 
 * 
 * @author Michael Kšlling
 * @version 1.1
 */
public class Space extends World
{
    private String[] soundFiles = { "2c", "2d", "2e", "2f", "2g", "2a", "2b", "3c", "3d", "3e", "3f", "3g", "3a", "3b" };
    
    /**
     * Constructor for objects of class Space.
     * 
     */
    public Space()
    {    
        super(960, 620, 1);
        
        createObstacles();
        randomBodies(5);
    }
    
    /**
     * Create a row of obstacles across the middle of our world.
     */
    public void createObstacles()
    {
        int i = 0;
        while (i < soundFiles.length) 
        {
            addObject (new Obstacle (soundFiles[i] + ".wav"), 80 + i*60, 310);
            i++;
        }
    }
    
    /**
     * Create a given number of bodies in the universe. Each body has a random initial state (size,
     * mass, direction, speed, color, location).
     */
    public void randomBodies(int number)
    {
        while (number > 0) 
        {
            int size = 20 + Greenfoot.getRandomNumber(30);
            double mass = size * 7.0;
            int direction = Greenfoot.getRandomNumber(360);
            double speed = Greenfoot.getRandomNumber(150) / 100.0;
            int x = Greenfoot.getRandomNumber(getWidth());
            int y = Greenfoot.getRandomNumber(getHeight());
            int r =  Greenfoot.getRandomNumber(255);
            int g =  Greenfoot.getRandomNumber(255);
            int b =  Greenfoot.getRandomNumber(255);
            addObject (new Body (size, mass, new Vector(direction, speed), new Color(r, g, b)), x, y);
            number--;
        }
    }
}
