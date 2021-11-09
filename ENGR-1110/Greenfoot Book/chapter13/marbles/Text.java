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
        image.drawString(text, 2, 12);
    }
    
    /**
     * Adapt location to make placement left-justified.
     */
    public void setLocation(int x, int y)
    {
        super.setLocation(x + getImage().getWidth() / 2, y);
    }
}
