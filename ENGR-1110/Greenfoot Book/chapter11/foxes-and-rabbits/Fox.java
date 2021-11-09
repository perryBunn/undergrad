import greenfoot.*;
import java.util.List;

/**
 * A fox in a predator/prey simulation. Foxes move around, eat rabbits and breed.
 * They may starve if they do not eat for a long time.
 * 
 * @author Michael Kölling
 * @version 1.0
 */
public class Fox extends Animal
{
    // Characteristics shared by all foxes (static fields).
    
    // The age to which a fox can live.
    private static final int MAX_AGE = 150;
    // The age at which a fox can start to breed.
    private static final int BREEDING_AGE = 10;
    // The likelihood of a fox breeding (in percent).
    private static final int BREEDING_PROBABILITY = 8;
    // The maximum number of births.
    private static final int MAX_LITTER_SIZE = 3;
    // The food value of a single rabbit. In effect, this is the
    // number of steps a fox can go before it has to eat again.
    private static final int RABBIT_FOOD_VALUE = 6;
    
    // Individual characteristics (instance fields).

    // The fox's food level, which is increased by eating rabbits.
    private int foodLevel;

    /**
     * Default constructor for testing.
     */
    public Fox()
    {
        this(true);
    }

    /**
     * Create a fox. A fox can be created as a new born (age zero
     * and not hungry) or with random age.
     * @param randomAge If true, the fox will have random age and hunger level.
     */
    public Fox(boolean randomAge)
    {
        super();
        if(randomAge) {
            setAge(Greenfoot.getRandomNumber(MAX_AGE));
            foodLevel = Greenfoot.getRandomNumber(RABBIT_FOOD_VALUE);
        }
        else {
            // leave age at 0
            foodLevel = RABBIT_FOOD_VALUE;
        }
    }
    
    /**
     * This is what the fox does most of the time: it hunts for
     * rabbits. In the process, it might breed, die of hunger,
     * or die of old age.
     */
    public void act() 
    {
        incrementAge();
        incrementHunger();
        if (isAlive()) {
            // New foxes are born into adjacent locations.
            int births = breed();
            for(int b = 0; b < births; b++) {
                Location loc = getField().freeAdjacentLocation(getX(), getY());
                if (loc != null) {
                    Fox newFox = new Fox(false);
                    getField().addObject(newFox, loc.getX(), loc.getY());
                }
            }
            // Move towards the source of food if found.
            Location newLocation = findFood(getX(), getY());
            if(newLocation == null) {  // no food found - move randomly
                newLocation = getField().freeAdjacentLocation(getX(), getY());
            }
            if(newLocation != null) {
                setLocation(newLocation.getX(), newLocation.getY());
            }
            else {
                // can neither move nor stay - overcrowding - all locations taken
                setDead();
            }
        }
    }    
    
    /**
     * Increase the age. This could result in the fox's death.
     */
    private void incrementAge()
    {
        setAge(getAge() + 1);
        if(getAge() > MAX_AGE) {
            setDead();
        }
    }
    
    /**
     * Make this fox more hungry. This could result in the fox's death.
     */
    private void incrementHunger()
    {
        foodLevel--;
        if(foodLevel <= 0) {
            setDead();
        }
    }
    
    /**
     * Tell the fox to look for rabbits adjacent to its current location.
     * Only the first live rabbit is eaten.
     * @param field The field in which it must look.
     * @param location Where in the field it is located.
     * @return Where food was found, or null if it wasn't.
     */
    private Location findFood(int x, int y)
    {
        List rabbits = getNeighbours(1, true, Rabbit.class);
        // do I need to shuffle?
        if (rabbits.isEmpty()) {
            return null;
        }
        else {
            Rabbit rabbit = (Rabbit) rabbits.get(0);
            Location loc = new Location(rabbit.getX(), rabbit.getY());
            rabbit.setDead();  // eat it
            foodLevel = RABBIT_FOOD_VALUE;
            return loc;
        }
    }
        
    /**
     * Generate a number representing the number of births,
     * if it can breed.
     * Return the number of births (may be zero).
     */
    private int breed()
    {
        int births = 0;
        if(canBreed() && Greenfoot.getRandomNumber(100) <= BREEDING_PROBABILITY) {
            births = Greenfoot.getRandomNumber(MAX_LITTER_SIZE) + 1;
        }
        return births;
    }
    
    /**
     * A fox can breed if it has reached the breeding age.
     */
    private boolean canBreed()
    {
        return getAge() >= BREEDING_AGE;
    }
}
