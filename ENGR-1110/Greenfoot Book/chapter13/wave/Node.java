import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)
import java.awt.Color;

/**
 * A node in a string. A node is fixed in its X co-ordinate, but can move in its y co-ordinate.
 * It will be pulled up or down by two neighbouring nodes.
 * 
 * @author mik
 * @version 1.0
 */
public class Node extends PreciseActor
{
    private static final double DAMPING = 0.01;
    
    private Node leftNeighbour;
    private Node rightNeighbour;
    protected Switch onSwitch;

    private double movement;  // the current movement force (in vertical direction)

    /**
     * Default constructor (for interactive testing)
     */
    public Node() 
    {
        this(null, null);
    }
    
    /**
     * Construct a node, creating a link to its left neighbour (and back)
     */
    public Node(Node leftNeighbour, Switch onSwitch)
    {
        this.leftNeighbour = leftNeighbour;
        if (leftNeighbour != null) {
            leftNeighbour.setRightNeighbour(this);
        }
        this.onSwitch = onSwitch;
    }
    
    /**
     * Specify the right neighbour of ths node.
     */
    public void setRightNeighbour(Node rightNeighbour) 
    {
        this.rightNeighbour = rightNeighbour;
    }
    
    /**
     * Adjust out Y position according to the movement force calculated.
     */
    public void act() 
    {
        if (onSwitch.isOn()) {
            if (rightNeighbour != null) {    // don't move the last node
                double move = movement / 4;  // with each step, move a quarter of the movement force
                setLocation(getExactX(), getExactY() + move);
            }
        }
    }
    
    /**
     * Calculate the force on this node, by taking into account the location of the neighbours.
     */
    public void applyForce(double damping) 
    {
        if (onSwitch.isOn()) {
            if (rightNeighbour != null) {
                double middle = (leftNeighbour.getExactY() + rightNeighbour.getExactY()) / 2;
                double newForce = (middle - getExactY()) * 2;
                movement = (newForce + movement) / (1.0 + damping);
            }
        }
    }
}
