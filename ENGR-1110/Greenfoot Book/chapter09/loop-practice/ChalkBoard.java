import greenfoot.*;

/**
 * A board to scribble on.
 * 
 * @author Michael Kölling 
 * @version 1.0
 */
public class ChalkBoard extends World
{
    // Where to write the next text:
    private int x;
    private int y;
    
    /**
     * Create a new chalk board.
     */
    public ChalkBoard()
    {
        super(800, 600, 1); 
        clear();
        practice();
    }
    
    /**
     * This is the method for you to practice. Add your code here.
     */
    public void practice()
    {
        write(7);  // an example of writing a number
        
        // Replace this with your own code
    }
    
    /**
     * Write a number onto the board.
     */
    public void write(int number)
    {
        write(String.valueOf(number));
    }
    
    /**
     * Write a character onto the board.
     */
    public void write(char character)
    {
        write(String.valueOf(character));
    }
    
    /**
     * Write some text onto the board.
     */
    public void write(String text)
    {
        addObject(new Text(text), x, y);
        x += 120;
        if (x > getWidth()-100) {
            x = 100;
            y += 80;
        }
    }
    
    /**
     * Wipe the board.
     */
    public void clear()
    {
        removeObjects(getObjects(Text.class));
        x = 100;
        y = 100;
    }
}
