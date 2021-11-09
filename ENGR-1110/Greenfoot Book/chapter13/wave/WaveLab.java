import greenfoot.*; 
import java.awt.Color;

/**
 * The world in which our wave lab is assembled.
 * 
 * @author Michael Kölling
 * @version 1.0
 */
public class WaveLab extends World
{
    static private final int NO_BALLS = 59;
    static private final int SPACING = 14;
    static private final int LINE_START_X = 80;
    static private final int LINE_START_Y = 300;
    
    private Node[] balls;
    
    private Slider amplitudeSlider;
    private Slider frequencySlider;
    private Slider dampingSlider;
    private Switch oscillateSwitch;
    private Switch onSwitch;
    
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public WaveLab()
    {    
        super(960, 500, 1);

        GreenfootImage bg = getBackground();
        bg.setColor( new Color (0, 0, 0, 128));
        bg.drawLine(LINE_START_X, LINE_START_Y, LINE_START_X+820, LINE_START_Y);

        createControls();
        balls = createBalls();
    }

    public void act() 
    {
        for (Node node : balls) {
            node.applyForce(dampingSlider.getValue() / 100.0);
        }
    }
   
    private void createControls() 
    {
        oscillateSwitch = new Switch ("Manual", "Oscillate");
        addObject (oscillateSwitch, 100, 65);
        
        amplitudeSlider = new Slider ("Amplitude", 0, 100);
        addObject (amplitudeSlider, 260, 65);

        frequencySlider = new Slider ("Frequency", 3, 25);
        addObject (frequencySlider, 470, 65);
        
        dampingSlider = new Slider ("Damping", 0, 10);
        addObject (dampingSlider, 680, 65);
        
        onSwitch = new Switch ("Pause", "Go");
        onSwitch.toggle();
        addObject (onSwitch, 840, 65);
        
        addObject (new Sign(), 100, 390);

    }
    
    private Node[] createBalls() 
    {
        Node [] nodes = new Node[NO_BALLS];
        Node start = new StartNode(amplitudeSlider, frequencySlider, oscillateSwitch, onSwitch);
        addObject (start, LINE_START_X - SPACING - 1, LINE_START_Y);
        Node prev = start;
        for (int i = 0; i < NO_BALLS; i++) {
            nodes[i] = new Node(prev, onSwitch);
            addObject (nodes[i], LINE_START_X + i*SPACING, LINE_START_Y);
            prev = nodes[i];
        }
        return nodes;
    }
}
