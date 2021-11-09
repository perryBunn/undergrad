import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)

/**
 * A key on a piano keyboard. This key is associated with a keyboard 
 * key and a sound file, which is played when the key is pressed.
 * 
 * @author: M. Kölling
 * @version: 0.3
 */
public class Key extends Actor
{
    private boolean isDown;
    private String key;
    private String sound;

    /**
     * Create a new key linked to a given keyboard key, and
     * with a given sound.
     */
    public Key(String keyName, String soundFile)
    {
        key = keyName;
        sound = soundFile;
    }

    /**
     * Do the action for this key.
     */
    public void act()
    {
        if (!isDown && Greenfoot.isKeyDown(key)) {
            play();
            setImage("white-key-down.png");
            isDown = true;
        }
        if (isDown && !Greenfoot.isKeyDown(key)) {
            setImage("white-key.png");
            isDown = false;
        }
    }

    /**
     * Play the note of this key.
     */
    public void play()
    {
        Greenfoot.playSound(sound);
    }
}