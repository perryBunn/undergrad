import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)

/**
 * A rock in space.
 * 
 * @author Poul Henriksen
 * @author Michael Kölling
 * 
 * @version 2.0
 */
public class Asteroid extends Mover
{
    /** Size of this asteroid */
    private int size;

    /** When the stability reaches 0 the asteroid will break up */
    private int stability;

    /**
     * Create an asteroid with default size and speed.
     */
    public Asteroid()
    {
        this(64);
    }
    
    /**
     * Create an asteroid with a given size, random movement direction and 
     * default speed.
     */
    public Asteroid(int size)
    {
        this(size, new Vector(Greenfoot.getRandomNumber(360), 2));
    }
    
    /**
     * Create an asteroid with a given size size, direction, and speed.
     */
    private Asteroid(int size, Vector speed)
    {
        super(speed);
        setSize(size);
    }
    
    /**
     * Let the asteroid act. That is: fly around.
     */
    public void act()
    {         
        move();
    }

    /**
     * Set the size of this asteroid. Note that stability is directly
     * related to size. Smaller asteroids are less stable.
     */
    public void setSize(int size) 
    {
        this.size = size;
        stability = size;
        GreenfootImage image = getImage();
        image.scale(size, size);
    }

    /**
     * Return the current stability of this asteroid. (If it goes down to 
     * zero, it breaks up.)
     */
    public int getStability() 
    {
        return stability;
    }
    
    /**
     * Hit this asteroid dealing the given amount of damage.
     */
    public void hit(int damage) 
    {
        stability = stability - damage;
        if (stability <= 0) {
            breakUp();       
        }
    }
    
    /**
     * Break up this asteroid into two smaller asteroids (or, if it is 
     * already very small, just disappear).
     */
    private void breakUp() 
    {
        Greenfoot.playSound("Explosion.wav");
        
        if (size <= 16) {
            // if we are already very small, just disappear
            getWorld().removeObject(this);
            return;
        }
        else {
            // otherwise, create two asteroids with half size
            int r = getMovement().getDirection() + Greenfoot.getRandomNumber(45);
            double l = getMovement().getLength();
            Vector speed1 = new Vector(r + 60, l * 1.2);
            Vector speed2 = new Vector(r - 60, l * 1.2);        
            Asteroid a1 = new Asteroid(size/2, speed1);
            Asteroid a2 = new Asteroid(size/2, speed2);
            getWorld().addObject(a1, getX(), getY());
            getWorld().addObject(a2, getX(), getY());        
            a1.move();
            a2.move();
        
            getWorld().removeObject(this);
        }
    }
}