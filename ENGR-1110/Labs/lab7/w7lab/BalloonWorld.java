import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/** 
 *
 * A world of balloons. Based on a scenario created by Poul Henriksen.
 * 
 * Balloons will be created and flow from the bottom to the top of the screen.
 * 
 */
public class BalloonWorld extends World 
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */   
    public BalloonWorld() {    
        super(800, 600, 1, false);
        addObject(new Dart(), 400, 300);
        addObject(new Bomb(), 750, 480);
        addObject(new Bomb(), 750, 410);
        setPaintOrder(Bomb.class, Dart.class, Balloon.class);
    }

    /**
     * Randomly create balloons at the bottom of the world
     * on approximately 3% of act cycles.
     */
    public void act() {
        if (Greenfoot.getRandomNumber(100) < 3) {
            addObject(new Balloon(),
                Greenfoot.getRandomNumber(700), 600);
        }
    }

}
