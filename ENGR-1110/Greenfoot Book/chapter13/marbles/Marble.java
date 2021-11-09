import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * A marble in a marble game. The marble can move and knock other marbles on the board, 
 * and if it crosses over the board's edge, it falls down and disappears.
 * 
 * All of the movement functiuonality is implemented in the superclass, SnmoothMover.
 * 
 * @author: Michael Kölling
 * @version 1.0
 */
public class Marble extends SmoothMover
{
    private static final double DIAMETER = 54.0;
    private static final int RADIUS = 27;
    private static final int BAR_SHADOW = 10;
    
    private boolean moving;
    private boolean out;
    private boolean haveHitLastAct;   // true if last act step was a hit on a bar
    private GreenfootImage image;
    
    /**
     * Create a marble.
     */
    public Marble()
    {
        image = getImage();
    }
    
    /**
     * Do the acting. That is: either move the marble or fall down if we're off the board.
     */
    public void act() 
    {
        if (out) {
            move();
            drop();
        }
        else if (moving) {
            move();
            checkCollision();
            accelerate(0.99);  // accelerate with factor < 1 - that is: decelerate
            if (getSpeed() < 0.1) {
                setMoving(false);
            }
            checkBoardBoundary();
        }
    }
    
    /**
     * Check whether we are colliding with another marble.
     */
    private void checkCollision()
    {
        // first, get all marbles whose image intersects (we don't need to check the others)
        List<Marble> marbles = (List<Marble>) getIntersectingObjects(Marble.class);
        for (Marble marble : marbles) {
            // of those, see which really intersect properly with the marble itself (the image is
            // bigger than the marble, so that we can draw the shadow, etc).
            if ( haveHit(marble) ) {
                doCollision(marble);
            }
        }

        // Now, check for wooden bars
        List<Bar> bars = (List<Bar>) getIntersectingObjects(Bar.class);
        for (Bar bar : bars) {
            // of those, see which really intersect properly with the bar itself (the image is
            // bigger than the bar, because it includes the shadow).
            if ( haveHit(bar) ) {
                doCollision(bar);
            }
        }
    }
    
    /**
     * We have hit another marble. Perform the collision now (that is: compute the new vectors of 
     * movement for us and the other marble).
     */
    private void doCollision(Marble marble)
    {
        double dx = this.getExactX() - marble.getExactX();
        double dy = this.getExactY() - marble.getExactY();
        int direction = (int) Math.toDegrees(Math.atan2(dy, dx));
        double angle = direction - getMovement().getDirection();
        
        // if the not 90 < angle < 270 then we're hit from behind and don't want to move the other ball
        if (Math.abs(angle) < 90 || Math.abs(angle) > 270) {
            return;
        }

        Greenfoot.playSound("click.wav");
        
        double length = Math.cos(Math.toRadians(angle)) * getMovement().getLength();
        marble.addForce( new Vector (direction, length) );
        marble.setMoving(true);
        
        this.addForce (new Vector (direction + 180, length) );
        //System.out.println("dir (after): " + direction + "  " + this);
    }
    
    /**
     * We have hit another marble. Perform the collision now (that is: compute the new vectors of 
     * movement for us and the other marble).
     */
    private void doCollision(Bar bar)
    {
        int dx = Math.abs (this.getX() - bar.getX()) - bar.getImage().getWidth()/2 + BAR_SHADOW - RADIUS;
        int dy = Math.abs (this.getY() - bar.getY()) - bar.getImage().getHeight()/2 + BAR_SHADOW - RADIUS;
        boolean hitSide = dx > dy;
        boolean hitTopBottom = ! hitSide;
        
        if (Math.abs(dx-dy) <= 2) {     // If they are similar, we have hit the corner
            hitSide = hitTopBottom = true;
        }
        if (hitSide) {  // have hit from side
            getMovement().revertHorizontal();
        }
        if (hitTopBottom) {  // have hit from top or bottom
            getMovement().revertVertical();
        }
        accelerate (0.9);    // lose some speed when bouncing off

        Greenfoot.playSound("tock.wav");
    }
    
    /**
     * Check whether we have hit the given marble. We have hit it if its distance from us 
     * (measured at the centre points) is less then our diameter.
     */
    private boolean haveHit(Marble marble)
    {
        int dx = Math.abs (this.getX() - marble.getX());
        int dy = Math.abs (this.getY() - marble.getY());
        double distance = Math.sqrt(dx*dx+dy*dy);
        
        return distance < DIAMETER;
    }
    
    /**
     * Check whether we have hit a marble. We have hit one, if the distance from us (measured at the
     * centre points) is less then our diameter.
     */
    private boolean haveHit(Bar bar)
    {
        if (haveHitLastAct) {       // make sure we don't register a hit twice in a row
            haveHitLastAct = false;
            return false;
        }
        else {
            int dx = Math.abs (this.getX() - bar.getX()) - bar.getImage().getWidth()/2 + BAR_SHADOW - RADIUS;
            int dy = Math.abs (this.getY() - bar.getY()) - bar.getImage().getHeight()/2 + BAR_SHADOW - RADIUS;
            haveHitLastAct = (dx < 0) && (dy < 0);
        
            return haveHitLastAct;
        }
    }
    
    /**
     * Check whether we've gone over the edge of the board.
     */
    private void checkBoardBoundary()
    {
        Board board = (Board) getWorld();
        if ( board.isOffBoard(getX(), getY()) ) {
            out = true;
        }
    }
    
    /**
     * Do the drop motion (which is shown when we're off board). This is done by simply scaling down our 
     * picture. If it gets small enough, we disappear from the world.
     */
    private void drop()
    {
        if(getImage().getWidth() < 10) {
            Greenfoot.playSound("tock.wav");
            hasDropped();
            Board board = getBoard();
            board.removeObject(this);
            board.marbleMoving(false);
        }
        else {
            GreenfootImage img = new GreenfootImage(image);
            img.scale ( getImage().getWidth()-6, getImage().getHeight()-6 );
            setImage (img);
        }
    }

    /**
     * This marble has dropped. Do whatever is necessary.
     */
    public void hasDropped()
    {
        Board board = getBoard();
        board.steelMarbleDropped();
        int x = Math.max (getX(), 50);
        int y = Math.max (getY(), 40);
        y = Math.min (y, board.getHeight()-40);
        board.addObject (new Points("10"), x, y);
    }
    
    /**
     * Check whether we're moving.
     */
    public boolean isMoving()
    {
        return moving;
    }

    /**
     * Set this marble to moving or not moving state.
     */
    public void setMoving(boolean move)
    {
        if (moving != move) {
            getBoard().marbleMoving(move);
        }
        moving = move;
    }
    
    /**
     * Return the board we're on.
     */
    public Board getBoard()
    {
        return (Board)getWorld();
    }
}
