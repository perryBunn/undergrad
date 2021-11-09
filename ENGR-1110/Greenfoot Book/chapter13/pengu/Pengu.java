import greenfoot.*;

/**
 * A little penguin that wants to get to the other side.
 */
public class Pengu extends Mover
{
    private static final int jumpStrength = 16;
    
    public void act() 
    {
        checkKeys();        
        checkFall();
    }
    
    private void checkKeys()
    {
        if (Greenfoot.isKeyDown("left") )
        {
            setImage("pengu-left.png");
            moveLeft();
        }
        if (Greenfoot.isKeyDown("right") )
        {
            setImage("pengu-right.png");
            moveRight();
        }
        if (Greenfoot.isKeyDown("space") )
        {
            if (onGround())
                jump();
        }
    }    
    
    private void jump()
    {
        setVSpeed(-jumpStrength);
        fall();
    }
    
    private void checkFall()
    {
        if (onGround()) {
            setVSpeed(0);
        }
        else {
            fall();
        }
    }
}

    