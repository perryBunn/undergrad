import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A special node that can be dragged and can move by itself.
 */
public class StartNode extends Node
{
    private int step;
    private int originY;
    
    private Slider ampSlider;
    private Slider freqSlider;
    private Switch oscSwitch;

    public StartNode(Slider amp, Slider freq, Switch osc, Switch onSwitch)
    {
        super(null, onSwitch);
        ampSlider = amp;
        freqSlider = freq;
        oscSwitch = osc;
    }
    
    public void addedToWorld(World w)
    {
        originY = getY();
    }
    
    public void act() 
    {
        if (onSwitch.isOn()) {
            if (oscSwitch.isOn()) {
                if ( !ampSlider.isEnabled() ) {
                    ampSlider.setEnabled(true);
                    freqSlider.setEnabled(true);
                }
                doOscillate();
            }
            else {
                if ( ampSlider.isEnabled() ) {
                    ampSlider.setEnabled(false);
                    freqSlider.setEnabled(false);
                }
                doDrag();
            }
        }
    }    

    private void doOscillate()
    {
        step = (step + freqSlider.getValue()) % 360;
        int y = (int) (originY + Math.sin(Math.toRadians(step)) * ampSlider.getValue());
        setLocation (getX(), y);
    }    
    
    private void doDrag()
    {
        if (Greenfoot.mouseDragged(this)) {
            MouseInfo mouse = Greenfoot.getMouseInfo();
            setLocation(getX(), mouse.getY());
        }
    }

}
