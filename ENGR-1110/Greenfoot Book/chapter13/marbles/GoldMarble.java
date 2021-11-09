import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A special marble that not only has a different colour, but can be controlled
 * with the mouse. It bahaves mostly like a standard marble, but doing a drag-and-
 * release gesture with the mouse on it will push the marble off in a given 
 * direction. 
 * 
 * The marble uses an Arrow object to indicate the force being applied when doing
 * the drag thing.
 * 
 * @author: Michael Kölling
 * @version 1.0
 */
public class GoldMarble extends Marble
{
    private Arrow arrow;

    public void act() 
    {
        super.act();
        if (! isMoving()) {
            checkDrag();
        }
    }    

    /**
     * Check whether we have a mouse drag gesture. Then we need to show the force arrow.
     */
    private void checkDrag()
    {
        if(Greenfoot.mouseDragged(this)) {
            MouseInfo mouse = Greenfoot.getMouseInfo();
            int dx = mouse.getX()-getX();
            int dy = mouse.getY()-getY();
//             int dx = Math.min (mouse.getX()-getX(), 100);
//             int dy = Math.min (mouse.getY()-getY(), 100);
//             dx = Math.max (dx, -100);
//             dy = Math.max (dy, -100);
            if (arrow == null) {   // just starting to drag now
                arrow = new Arrow(dx, dy);
                getWorld().addObject( arrow, getX(), getY() );
            }
            else {
                arrow.setImage(dx, dy);
            }
        }
        if(Greenfoot.mouseDragEnded(this) && arrow != null) {
            getWorld().removeObject(arrow);
            getBoard().countRoll();
            arrow = null;
            MouseInfo mouse = Greenfoot.getMouseInfo();
            Vector force = new Vector(getExactX() - mouse.getX(), getExactY() - mouse.getY());
            force.scale(0.1);
            addForce (force);
            setMoving(true);
        }
    }
    
    /**
     * This marble has dropped. Do whatever is necessary.
     */
    public void hasDropped()
    {
        getBoard().goldMarbleDropped();
    }
}
