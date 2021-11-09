import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)

public class Key extends Actor
{
    private boolean isDown;

    /**
     * Create a new key.
     */
    public Key()
    {
    }

    /**
     * Do the action for this key.
     */
    public void act()
    {
        if ( !isDown && Greenfoot.isKeyDown("g") ) {
            play();
            setImage("white-key-down.png");
            isDown = true;
        }
        if ( isDown && !Greenfoot.isKeyDown("g") ) {
            setImage("white-key.png");
            isDown = false;
        }
    }

    /**
     * Play the note of this key.
     */
    public void play()
    {
        Greenfoot.playSound("3a.wav");
    }
}