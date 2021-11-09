import greenfoot.*;

/**
 * The Slider class provides a slider control to get numeric values from a user.
 * At runtime, the slider can be changed using the mouse or programmatically, using
 * the setValue method.
 * 
 * The slider value can be read using the getValue() method.
 * 
 * This class depends on the SliderHand and Text classes.
 * 
 * @author M. Kölling
 * @version 1.0
 */
public class Slider extends Actor
{
    private static final int MIN_X = -82;   // min and max offset in pixels on the slider image
    private static final int MAX_X = 81;
    private static final double RANGE_X = MAX_X - MIN_X;

    private SliderHand hand;                // the object representing the hand
    private Text value;                     // an object for the numeric value display
    private Text label;                     // an object for displaying the label

    private int val;
    private int min;
    private int max;
    private int range;
    
    /**
     * Create a default slider (range [0..100], no label).
     */
    public Slider()
    {
        this(" ", 0, 100);
    }
    
    /**
     * Create a slider with the specified minimum and maximum values. The labelText will
     * be shown under the slider.
     */
    public Slider(String labelText, int min, int max)
    {
        this.min = min;
        this.max = max;
        range = max - min;
        
        label = new Text(labelText);
    }
    
    /**
     * Create and add the helper objects (hand and labels).
     */
    public void addedToWorld(World world)
    {
        hand = new SliderHand(this);
        getWorld().addObject (hand, getX(), getY()-4);

        value = new Text(3);
        getWorld().addObject (value, getX(), getY()-30);

        getWorld().addObject (label, getX(), getY()+30);

        setValueFromX(hand.getX());
    }
    
    public void act() 
    {
        // Add your action code here.
    }
    
    /**
     * Return the currect value of the slider.
     */
    public int getValue()
    {
        return val;
    }
    
    /**
     * Set the value of the slider.
     */
    public void setValue(int val)
    {
        if (val < min || val > max) {
            System.err.println("Value for slider out of range (" + val + ") - ignored");
            return;
        }
        
        int x = MIN_X + (int) ( (val - min) * (RANGE_X / range) );
        hand.setLocation (getX() + x, hand.getY());

        this.val = val;
        value.setText (""+val);
    }
    
    public void setEnabled(boolean enable) 
    {
        hand.setEnabled(enable);
    }
    

    public boolean isEnabled() 
    {
        return hand.isEnabled();
    }

    /**
     * Set the value of the slider from a global X co-ordinate. This is used by the slider
     * hand, and should not usually be called by other classes.
     */
    public void setValueFromX(int x) 
    {
        x -= getX();   // convert from absolute to relative offset
        
        val = min + (int) ( (x - MIN_X) * ( range / RANGE_X) );
        value.setText (""+val);
    }
    
    /**
     * Get the minimum X offset (in pixels) for the slider hand.
     */
    public int getMinX()
    {
        return getX() + MIN_X;
    }
    
    /**
     * Get the maximum X offset (in pixels) for the slider hand.
     */
    public int getMaxX()
    {
        return getX() + MAX_X;
    }
    
    /**
     * Overide setLocation to also move child objects (hand and labels).
     */
    public void setLocation(int x, int y) 
    {
        super.setLocation(x, y);
        if(hand != null) {
            hand.setLocation(x, y-4);
            value.setLocation(x, y-30);
            label.setLocation(x, y+30);
        }
    }
}
