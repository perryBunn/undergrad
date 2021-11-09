import greenfoot.*;

/**
 * A bullet that can hit asteroids.
 * 
 * @author Poul Henriksen
 * @author Michael Kölling
 */
public class Bullet extends SmoothMover
{
    /** The damage this bullet will deal */
    private static final int damage = 16;
    
    /** A bullet looses one life each act, and will disappear when life = 0 */
    private int life = 30;
    
    /**
     * Default constructor for testing.
     */
    public Bullet()
    {
    }
    
    /**
     * Create a bullet with given speed and direction of movement.
     */
    public Bullet(Vector speed, int rotation)
    {
        super(speed);
        setRotation(rotation);
        addToVelocity(new Vector(rotation, 15));
        Greenfoot.playSound("EnergyGun.wav");
    }
    
    /**
     * The bullet will damage asteroids if it hits them.
     */
    public void act()
    {
        if(life <= 0) {
            getWorld().removeObject(this);
        } 
        else {
            life--;
            move();
            checkAsteroidHit();
        }
    }
    
    /**
     * Check whether we have hit an asteroid.
     */
    private void checkAsteroidHit()
    {
        Asteroid asteroid = (Asteroid) getOneIntersectingObject(Asteroid.class);
        if (asteroid != null)
        {
            getWorld().removeObject(this);
            asteroid.hit(damage);
        }
    }
}