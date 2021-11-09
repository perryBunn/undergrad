import greenfoot.*;

/**
 * An ant that collects food.
 * 
 * @author Michael Kölling
 * @version 0.1
 */
public class Ant extends Creature
{
    /** Indicate whether we have any food with us. */
    private boolean carryingFood = false;

    /**
     * Create an ant with a given home hill. The initial speed is zero (not moving).
     */
    public Ant(AntHill home)
    {
        setHomeHill(home);
    }

    /**
     * Do what an ant's gotta do.
     */
    public void act()
    {
        if (carryingFood) {
            walkTowardsHome();
            checkHome();
        }
        else {
            searchForFood();
        }
    }

    /**
     * Walk around in search of food.
     */
    private void searchForFood()
    {
        randomWalk();
        checkFood();
    }

    /**
     * Are we home? Drop the food if we are, and start heading back out.
     */
    private void checkHome()
    {
        if (atHome()) {
            dropFood();
        }
    }

    /**
     * Are we home?
     */
    private boolean atHome()
    {
        if (getHomeHill() != null) {
            return (Math.abs(getX() - getHomeHill().getX()) < 4) && (Math.abs(getY() - getHomeHill().getY()) < 4);
        }
        else {
            return false;
        }
        
    }
    /**
     * Is there any food here where we are? If so, take some!.
     */
    public void checkFood()
    {
        Food food = (Food) getOneIntersectingObject(Food.class);
        if (food != null) {
            takeFood(food);
        }
    }

    /**
     * Take some food from a fool pile.
     */
    private void takeFood(Food food)
    {
        carryingFood = true;
        food.takeSome();
        setImage("ant-with-food.gif");
    }

    /**
     * Drop our food in the ant hill.
     */
    private void dropFood()
    {
        carryingFood = false;
        getHomeHill().countFood();
        setImage("ant.gif");
    }

}