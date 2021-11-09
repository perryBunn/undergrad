import greenfoot.*;

/**
 * A chart to display colors.
 * 
 * @author Michael Kölling
 * @version 1.0
 */
public class Chart  extends World
{
    private static final int HEIGHT = 20;
    private static final int WIDTH = 80;
    
    /**
     * Create a color chart.
     */
    public Chart()
    {    
        super(500, 740, 1);
        
        for (int r = 0; r < 6; r++) {
            for (int g = 0; g < 6; g++) {
                for (int b = 0; b < 6; b++) {
                    ColorPatch c = new ColorPatch (r * 51, g * 51, b * 51);
                    addObject (c, 50 + b*WIDTH, 20 + r*HEIGHT*6 + g*HEIGHT);
                }
            }
        }
    }
}
