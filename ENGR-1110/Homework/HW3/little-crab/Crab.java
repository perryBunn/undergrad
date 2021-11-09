import greenfoot.*;

/**
 * This class defines a crab. Crabs live on the beach.
 */
public class Crab extends Actor
{
    public void act()
    {
        if (isAtEdge()){
            if(getY() == 0){
                move(-150);
            }
            backUp(1);
            turnLeft();
        }
        move(5);
    }
    
    /** Turns the crab to face left from its current perspective. */
    public void turnLeft() {
        turn(-90);
    }
    
    /** Moves the crab backwards the given distance. */
    public void backUp(int distance) {
        move(-50);
    }
}


