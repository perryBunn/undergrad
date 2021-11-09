import greenfoot.*;

/**
 * A puff of smoke that fades away and vanishes.
 * 
 * @author M. Kölling
 * @version 1.0
 */
public class Smoke  extends Actor
{
    private GreenfootImage image;   // the original image
    private int fade;               // the rate of fading

    public Smoke()
    {
        image = getImage();
        fade = Greenfoot.getRandomNumber(4) + 1;  // 1 to 4
        if (fade > 3) {
          fade = 2;  // change 4 to 2, to have double probability for 2
        }
    }
    
    /**
     * In every step, get smaller until we disappear.
     */
    public void act() 
    {
        shrink();
    }    
    
    /**
     * Make the image of this actor a little smaller. If it gets very small,
     * delete the actor.
     */
    private void shrink()
    {
        if(getImage().getWidth() < 10) {
            getWorld().removeObject(this);
        }
        else {
            GreenfootImage img = new GreenfootImage(image);
            img.scale( getImage().getWidth()-fade, getImage().getHeight()-fade );
            img.setTransparency( getImage().getTransparency() - (fade*5) );
            setImage (img);
        }
    }
}
