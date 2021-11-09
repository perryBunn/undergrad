import greenfoot.*;

/**
 * A rocket that can be controlled by the arrowkeys: up, left, right.
 * The gun is fired by hitting the 'space' key. 'z' releases a proton wave.
 * 
 * @author Poul Henriksen
 * @author Michael Kölling
 * 
 * @version 1.0
 */
public class Rocket extends SmoothMover
{
    private static final int gunReloadTime = 5;         // The minimum delay between firing the gun.
    private static final int protonReloadTime = 500;    // The minimum delay between proton wave bursts.

    private int reloadDelayCount;               // How long ago we fired the gun the last time.
    private int protonDelayCount;               // How long ago we fired the proton wave the last time.
    
    private GreenfootImage rocket = new GreenfootImage("rocket.png");    
    private GreenfootImage rocketWithThrust = new GreenfootImage("rocketWithThrust.png");

    /**
     * Initialise this rocket.
     */
    public Rocket()
    {
        reloadDelayCount = 5;
        protonDelayCount = 500;
        addToVelocity(new Vector(13, 0.7));    // initially slowly drifting
    }

    /**
     * Do what a rocket's gotta do. (Which is: mostly flying about, and turning,
     * accelerating and shooting when the right keys are pressed.)
     */
    public void act()
    {
        move();
        checkKeys();
        checkCollision();
        reloadDelayCount++;
        protonDelayCount++;
    }
    
    /**
     * Check whether there are any key pressed and react to them.
     */
    private void checkKeys() 
    {
        ignite(Greenfoot.isKeyDown("up"));
        
        if (Greenfoot.isKeyDown("left")) 
        {
            turn(-5);
        }
        if (Greenfoot.isKeyDown("right")) 
        {
            turn(5);
        }
        if (Greenfoot.isKeyDown("space")) 
        {
            fire();
        }
        if (Greenfoot.isKeyDown("z")) 
        {
            startProtonWave();
        }
    }
    
    /**
     * Check whether we are colliding with an asteroid.
     */
    private void checkCollision() 
    {
        Asteroid a = (Asteroid) getOneIntersectingObject(Asteroid.class);
        if (a != null) 
        {
            Space space = (Space) getWorld();
            space.addObject(new Explosion(), getX(), getY());
            space.removeObject(this);
            space.gameOver();
        }
    }
    
    /**
     * Should the rocket be ignited?
     */
    private void ignite(boolean boosterOn) 
    {
        if (boosterOn) 
        {
            setImage(rocketWithThrust);
            addToVelocity(new Vector(getRotation(), 0.3));
        }
        else 
        {
            setImage(rocket);        
        }
    }
    
    /**
     * Fire a bullet if the gun is ready.
     */
    private void fire() 
    {
        if (reloadDelayCount >= gunReloadTime) 
        {
            Bullet bullet = new Bullet (getVelocity(), getRotation());
            getWorld().addObject (bullet, getX(), getY());
            bullet.move ();
            reloadDelayCount = 0;
        }
    }
    
    /**
     * Release a proton wave (if it is loaded).
     */
    private void startProtonWave() 
    {
        if (protonDelayCount >= protonReloadTime) 
        {
            ProtonWave wave = new ProtonWave();
            getWorld().addObject (wave, getX(), getY());
            protonDelayCount = 0;
        }
    }

}