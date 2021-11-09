import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)

/**
 * A lump of Rock.
 * 
 * @author mik
 * @version 1.0
 */
public class Rock extends Actor
{
    private static final int NUM_FRAGMENTS = 40;
    
    /**
     * Act - do whatever the Rock wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        String key = Greenfoot.getKey();
        if (key != null) {
            explode();
        }
    }
    
    public void explode()
    {
        placeDebris (getX(), getY(), NUM_FRAGMENTS);
        getWorld().removeObject(this);
    }
    
    private void placeDebris(int x, int y, int numFragments)
    {
        for (int i=0; i < numFragments; i++) {
            getWorld().addObject ( new Debris(), x, y );
        }
    }
}
