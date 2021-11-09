import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)

/**
 * Pieces of rock, flying around.
 * 
 * @author mik
 * @version 1.0
 */
public class Debris extends SmoothMover
{
    private static final Vector GRAVITY = new Vector(90, 1.5);
    private static final int FORCE = 15;
    
    public Debris()
    {
        int direction = Greenfoot.getRandomNumber(360);
        int speed = Greenfoot.getRandomNumber(FORCE);
        increaseSpeed( new Vector(direction, speed));
        
        // random image size
        GreenfootImage img = getImage();
        int width = Greenfoot.getRandomNumber(30) + 1;
        int height = Greenfoot.getRandomNumber(30) + 1;
        img.scale (width, height);
        
        setRotation (Greenfoot.getRandomNumber(360));
    }
    
    /**
     * Act - do whatever the Debris wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        increaseSpeed(GRAVITY);
        move();
    }    
}
