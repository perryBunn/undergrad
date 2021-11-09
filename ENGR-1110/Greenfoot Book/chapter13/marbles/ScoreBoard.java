import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)
import java.awt.Color;
import java.awt.Font;
import java.util.Calendar;

/**
 * The ScoreBoard is used to display results on the screen. It can display some
 * text and several numbers.
 * 
 * @author M Kölling
 * @version 1.0
 */
public class ScoreBoard extends Actor
{
    public static final float FONT_SIZE = 48.0f;
    public static final int WIDTH = 400;
    public static final int HEIGHT = 300;
    
    /**
     * Create a score board with dummy result for testing.
     */
    public ScoreBoard()
    {
        this(100);
    }

    /**
     * Create a score board for the final result.
     */
    public ScoreBoard(int score)
    {
        makeImage("Game Over", "Score: ", score);
    }

    /**
     * Create a score board for the final result.
     */
    public ScoreBoard(String text, int score)
    {
        makeImage(text, "Score: ", score);
    }

    /**
     * Make the score board image.
     */
    private void makeImage(String title, String prefix, int score)
    {
        GreenfootImage image = new GreenfootImage(WIDTH, HEIGHT);

        image.setColor(new Color(252,208,102, 128));
        image.fillRect(0, 0, WIDTH, HEIGHT);
        image.setColor(new Color(146, 103, 1, 128));
        image.fillRect(5, 5, WIDTH-10, HEIGHT-10);
        Font font = image.getFont();
        font = font.deriveFont(FONT_SIZE);
        image.setFont(font);
        image.setColor(Color.WHITE);
        image.drawString(title, 60, 100);
        image.drawString(prefix + score, 60, 200);
        setImage(image);
    }
}
