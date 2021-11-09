import greenfoot.*; 
import java.awt.Color;
import java.awt.Font;

/**
 * A representation of a given RGB color value.
 * 
 * @author Michael Kölling
 * @version 1.1
 */
public class ColorPatch extends Actor
{
    /**
     * Create a color patch with given RGB value.
     */
    public ColorPatch(int r, int g, int b)
    {
        GreenfootImage img = new GreenfootImage (80, 20);
        img.setColor (new Color(r, g, b));
        img.fill();
        
        if (g < 128) {
            img.setColor (Color.WHITE);
        }
        else {
            img.setColor (Color.BLACK);
        }
        img.setFont (img.getFont().deriveFont(Font.BOLD, 10.0f));
        img.drawString (r + "," + g + "," + b, 10, 14);

        setImage (img);
    }
}
