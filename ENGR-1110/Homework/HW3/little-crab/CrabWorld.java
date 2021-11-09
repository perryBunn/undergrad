import greenfoot.*;  // (Actor, World, Greenfoot, GreenfootImage)

public class CrabWorld extends World
{
    private GreenfootImage gull;
    /**
     * Create the crab world (the beach). Our world has a size 
     * of 560x560 cells, where every cell is just 1 pixel.
     */
    public CrabWorld() 
    {
        super(560, 560, 1);
        addObject(new Crab(), 280, 280);
        gull = new GreenfootImage("gull.png");
        getBackground().drawImage(gull, 25, 25);
    }
}