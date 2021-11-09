import greenfoot.*;

/**
 * Class Animal serves as a superclass of all animals in this predator-prey simulation.
 * 
 * @author Michael Kölling
 * @version 1.0
 */
public class Animal extends Actor
{
    // The animal's age.
    private int age;
    // Whether the animal is alive or not.
    private boolean alive;

    /**
     * Create a new animal with age zero (a new born).
     */
    public Animal()
    {
        age = 0;
        alive = true;
    }
    
    /**
     * Check whether the animal is alive or not.
     * @return True if the animal is still alive.
     */
    public boolean isAlive()
    {
        return alive;
    }

    /**
     * Tell the animal that it's dead now :(
     */
    public void setDead()
    {
        alive = false;
        World world = getWorld();
        if (world != null) {
            world.removeObject(this);
        }
    }
    
    /**
     * Return the animal's age.
     * @return The animal's age.
     */
    public int getAge()
    {
        return age;
    }

    /**
     * Set the animal's age.
     * @param age The animal's age.
     */
    public void setAge(int age)
    {
        this.age = age;
    }
    
    /**
     * Return the field we live in.
     */
    public Field getField()
    {
        return (Field) getWorld();
    }
}
