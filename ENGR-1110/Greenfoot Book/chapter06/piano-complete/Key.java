import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)

/**
 * A key on a piano keyboard. This key has a pair of images to show a normal
 * and depressed state, and it is associated with a keyboard key and a sound
 * file, which is played when the key is pressed.
 * 
 * @author: M. Kölling
 * @version: 1.0
 */
public class Key extends Actor
{
    private boolean isDown;
    private String key;
    private String sound;
    private String upImage;
    private String downImage;
    
    /**
     * Create a new key linked to a given keyboard key, and
     * with a given sound.
     */
    public Key(String keyName, String soundFile, String img1, String img2)
    {
        sound = soundFile;
        key = keyName;
        upImage = img1;
        downImage = img2;
        setImage(upImage);
        isDown = false;  
    }

    /**
     * Do the action for this key.
     */
    public void act()
    {
        if (!isDown && Greenfoot.isKeyDown(key)) {
            play();
            setImage(downImage);
            isDown = true;
        }
        if (isDown && !Greenfoot.isKeyDown(key)) {
            setImage(upImage);
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
