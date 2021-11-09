import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PigWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PigWorld extends World
{
    public PigWorld(){
        super(600, 400, 1, false);
        Pig ogPig = new Pig();
        addObject(ogPig, 400, 300);
        setPaintOrder(Pig.class,Mushroom.class);
    }

    public void act() {
        Mushroom newMushroom = new Mushroom();
        if (Greenfoot.getRandomNumber(100) < 3) {
            addObject(newMushroom,Greenfoot.getRandomNumber(601),0);
        }
    }
}