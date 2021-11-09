import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.font.FontRenderContext;
import java.awt.Graphics2D;

/**
 * This class provides objects that just show a bit of text on the screen.
 */
public class Text extends Actor
{
    public Text(int length)
    {
        setImage(new GreenfootImage(length * 12, 16));
    }

    public Text(String text)
    {
        this (text.length());
        setText(text);
    }

    public void setText(String text)
    {
        GreenfootImage image = getImage();
        image.clear();

        // calculate width of text in pixels
        FontRenderContext frc = ((Graphics2D)getImage().getAwtImage().getGraphics()).getFontRenderContext();
        int textWidth = (int)image.getFont().getStringBounds(text, frc).getWidth();
        
        image.drawString(text, (image.getWidth() - textWidth) / 2, 12);
    }
}
