import greenfoot.*;

/**
 * This class defines a crab. Crabs live on the beach.
 */
public class Crab extends Actor
{
    public void act()
    {
        checkKeyPress();
        move(5);
        lookForWorm();
    }
    public void lookForWorm() {
        if (isTouching(Worm.class)) {
            removeTouching(Worm.class);
            Greenfoot.playSound("slurp.wav");
        }
    }
    public void checkKeyPress() {
        if (Greenfoot.isKeyDown("\t")){
            turn(-4);
        }
        if (Greenfoot.isKeyDown("right")){
            turn(4);
        }
    }
}
