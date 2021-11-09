import greenfoot.*;  // (Actor, World, Greenfoot, GreenfootImage)

public class CrabWorld extends World
{
    /**
     * Create the crab world (the beach). Our world has a size 
     * of 560x560 cells, where every cell is just 1 pixel.
     */
    public CrabWorld() 
    {
        super(560, 560, 1);
        int score;
        boolean isHungry = true;
        int year = 2014;
        year = 2015;
        //int children = doughters + sons;
        //int area = width*length;
        int x = 23;
        int y = 17;
        
        Crab myCrab = new Crab();
        addObject(myCrab, 250, 200);
        
        Lobster myLobster = new Lobster();
        addObject(myLobster, Greenfoot.getRandomNumber(500)+20, Greenfoot.getRandomNumber(500)+20);
        addObject(myLobster, Greenfoot.getRandomNumber(500)+20, Greenfoot.getRandomNumber(500)+20);
        addObject(myLobster, Greenfoot.getRandomNumber(500)+20, Greenfoot.getRandomNumber(500)+20);
        
        Worm myWorm = new Worm();
        addObject(myWorm, Greenfoot.getRandomNumber(500)+20, Greenfoot.getRandomNumber(500)+20);
        addObject(myWorm, Greenfoot.getRandomNumber(500)+20, Greenfoot.getRandomNumber(500)+20);
        
    }
}
