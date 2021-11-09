import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The hand indicating the current value of a slider.
 * 
 * @author M. Kölling
 * @version 1.0
 */
public class SliderHand extends Actor
{
    private Slider slider;
    private boolean enabled = true;
    
    public SliderHand(Slider slider)
    {
        this.slider = slider;
    }
    
    public void act() 
    {
        if (enabled && Greenfoot.mouseDragged(this)) {
            int oldX = getX();
            
            MouseInfo mouse = Greenfoot.getMouseInfo();
            int x = mouse.getX();
            
            if (x < slider.getMinX())
                x = slider.getMinX();

            if (x > slider.getMaxX())
                x = slider.getMaxX();

            if (x != oldX) {
                setLocation(x, getY());
                slider.setValueFromX(x);
            }
        }
    }    
    
    public void setEnabled(boolean enable) 
    {
        if (enable)
            setImage("slider-hand.png");
        else
            setImage("slider-hand-grey.png");
            
        enabled = enable;
    }

    public boolean isEnabled() 
    {
        return enabled;
    }
}
