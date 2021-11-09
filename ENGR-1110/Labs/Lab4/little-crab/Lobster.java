import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Lobster here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Lobster extends Actor
{
    /**
     * Act - do whatever the Lobster wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        turnAtEdge();
        randomTurn();
        move(5);
        lookForCrab();
    }
    public void lookForCrab() {
        if (isTouching(Crab.class)) {
            removeTouching(Crab.class);
            Greenfoot.stop();
        }
    }
    public void randomTurn(){
         if ( Greenfoot.getRandomNumber(100) < 5 ) {
            turn(Greenfoot.getRandomNumber(90) - 45 );
        }
    }
    public void turnAtEdge() {
        if (isAtEdge() ) {
                turn(5);
        }
    } 
}