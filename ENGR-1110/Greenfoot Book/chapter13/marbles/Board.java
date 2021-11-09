import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * The game board. 
 * 
 * This class provides the background, including the board and the area for
 * detail and score display.
 * 
 * @author: Michael Kölling
 * @version 1.0
 */
public class Board extends World
{
    private int board;
    private int tries;
    private int rolls;
    private int score;
    private Text boardLabel;
    private Text tryLabel;
    private Text rollsLabel;
    private Text scoreLabel;
    private int marblesMoving;
    private boolean failed;
    private boolean cleared;
    private boolean displayPoints = false;
    /**
     * Definition of the board setups.
     *   One row defines one board setup.
     *   The first number is the number of rolls for this board.
     *   The 2nd and 3rd are the coordinates for the gold marble.
     *   Following that: every pair places a steel marble, unless:
     *     if the next number is 0, then following is a horizontal bar;
     *     if the next number is 1, then following is a vertical bar
     */
    private static final int[][] setups = {  // board = 640x640
        { 1, 320, 480, 320, 200 },
        { 2, 320, 320, 180, 320, 460, 320 },
        { 2, 320, 480, 200, 200, 440, 200 },
        { 3, 320, 320, 290, 480, 200, 190, 470, 230 },
        { 1, 120, 520, 420, 120, 520, 180 },
        { 2, 320, 480, 320, 180 , 0, 225, 315},        
        { 1, 140, 400, 470, 400 , 1, 320, 433, 0, 320, 100},                          // indirect over 1 bar
        { 1, 320, 480, 320, 90, 320, 200, 320, 310 },
        { 4, 320, 320, 200, 320, 440, 320, 260, 220, 380, 220, 260, 420, 380, 420 },  // six star
        { 1, 300, 520, 90, 320, 300, 100, 0, 390, 320},
        { 2, 360, 500, 90, 340, 325, 100, 570, 250, 0, 360, 330},
        { 2, 320, 320, 450, 95, 560, 140, 190, 545, 80, 500 },
        { 4, 320, 480, 120, 120, 120, 220, 220, 120, 220, 220, 320, 120, 320, 220,    // 10 in 2-rows
             420, 120, 420, 220, 520, 120, 520, 220 },
        { 1, 284, 546, 387, 293 , 1, 75, 320, 0, 320, 75, 0, 420, 380 },              // indirect over 2 bars
        { 3, 536, 130, 146, 508 , 0, 410, 230, 0, 230, 410 },            
        { 4, 320, 135, 110, 200, 530, 200, 240, 470, 400, 470, 0, 320, 340 }, 
    };
    
    public Board()
    {    
        // Create a new world with 20x20 cells with a cell size of 10x10 pixels.
        super (840, 640, 1);
        Greenfoot.setSpeed (52);
        setPaintOrder (ScoreBoard.class, Points.class, Marble.class, Arrow.class);

        board = 1;
        tries = 3;
        score = 0;
        
        createCounters ();
        setUp (board);
    }

    /**
     * Do the acting for the board: check whether w succeeded or failed.
     */
    public void act() 
    {
        if (cleared) {
            Marble goldMarble = getGoldMarble();
            if (goldMarble != null) {
                addObject (new Points ("200"), goldMarble.getX()+70, goldMarble.getY()-30);
                Greenfoot.playSound("ping.wav");
                addScore (300 + rolls*300); // 100 for clearing the board 
                                           // 200 for gold marble still on it,
                                           // plus 300 per unused roll
            }
            else {
                addScore (100 + rolls*300); // 100 for clearing the board
                                           // plus 300 per unused roll
            }
            cleared = false;
            displayPoints = true;
        }
        else if (displayPoints) {
            if ( pointsImageGone() ) {
                displayPoints = false;
                nextBoard();
            }
        }
        else if (failed) {
            lostBoard ();
        }
    }
    
    /**
     * Record that a marble has started or stopped moving.
     */
    public void marbleMoving(boolean moves)
    {
        if (moves) {
            marblesMoving++;
        }
        else {
            marblesMoving--;
            if (marblesMoving == 0) {           // all movement stopped
                if ( isBoardClear() ) {
                    cleared = true;
                }
                else if (rolls == 0) {
                    failed = true;
                }
                else if (! haveGoldMarble()) {
                    failed = true;
                }
            }
        }
    }

    /**
     * Record that a roll has been completed.
     */
    public void countRoll()
    {
        rolls--;
        rollsLabel.setText("Rolls left: " + rolls);
    }

    /**
     * A steel marble dropped off the board.
     */
    public void steelMarbleDropped()
    {
        addScore(10);
    }
    
    /**
     * The gold marble dropped off the board.
     */
    public void goldMarbleDropped()
    {
        // nothing to do - we wait until all movement has stopped before doing anything
        //failed = true;
    }
    
    /**
     * Check whether the board has been cleared.
     */
    private boolean isBoardClear()
    {
        int marbles = getObjects (Marble.class).size();
        int gold = getObjects (GoldMarble.class).size();
        return marbles - gold == 0;
    }
    
    /**
     * Check whether we still have the gold marble on the board.
     */
    private boolean haveGoldMarble()
    {
        return getGoldMarble() != null;
    }
    
    /**
     * Check whether the board has been cleared.
     */
    private boolean pointsImageGone()
    {
        return getObjects (Points.class).size() == 0;
    }
    
    /**
     * Check whether the gold marble is on the board.
     */
    private Marble getGoldMarble()
    {
        List<Actor> marbles = getObjects (GoldMarble.class);
        if (marbles.size() == 0) {
            return null;
        }
        else {
            return (Marble) marbles.get(0);
        }
    }
    
    /**
     * Record the fact that an attempt at a board has been unsuccessful.
     * Start over if there are tries left, else game over.
     */
    public void lostBoard() 
    {
        tries--;
        tryLabel.setText ("Tries left: " + tries);
        if (tries == 0) {
            Greenfoot.playSound("sad-trombone.wav");
            gameOver("Game Over");
        }
        else {
            Greenfoot.delay(100);
            setUp (board);
        }
    }
    
    /**
     * Game's up.
     */
    public void gameOver(String message) 
    {
        addObject (new ScoreBoard(message, score), 320, getHeight()/2);
        Greenfoot.stop();
    }

    /**
     * Record a score.
     */
    public void addScore(int points)
    {
        score = score + points;
        scoreLabel.setText ("Score: " + score + "      ");
    }
    
    /**
     * Check whether a given point is off the board.
     */
    public boolean isOffBoard (int x, int y) 
    {
        return (x < 20 || x > 620 || y < 20 || y > 620);
    }

    /**
     * Show the next board (if there is one). Otherwise game's over with a win.
     */
    private void nextBoard()
    {
        Greenfoot.delay(60);
        board++;
        if (board % 3 == 0) {
            tries++;
            tryLabel.setText("Tries left: " + tries);
        }
        if (board <= setups.length) {
            boardLabel.setText("BOARD " + board);
            setUp (board);
        }
        else {
            gameOver ("You win!");
        }
    }
    
    private void setUp(int boardNumber)
    {
        removeObjects (getObjects (Marble.class));
        removeObjects (getObjects (Bar.class));
        
        int[] current = setups[boardNumber-1];
        int i = 0;
        rolls = current[i++];
        
        addObject ( new GoldMarble(), current[i++], current[i++]);

        while (i < current.length) {
            int next = current[i++];
            if (next == 0) {
                addObject ( new Bar(false), current[i++], current[i++]);
            }
            else if (next == 1) {
                addObject ( new Bar(true), current[i++], current[i++]);
            }
            else {
                addObject ( new Marble(), next, current[i++]);
            }
        }
        
        rollsLabel.setText ("Rolls left: " + rolls);
        failed = false;
        cleared = false;
        marblesMoving = 0;
    }
    
    private void createCounters()
    {
        boardLabel = new Text("BOARD " + board);
        addObject (boardLabel, 670, 120);
        tryLabel = new Text("Tries left: " + tries);
        addObject (tryLabel, 670, 150);
        rollsLabel = new Text("Rolls left: " + rolls);
        addObject (rollsLabel, 670, 200);
        scoreLabel = new Text("Score: " + score + "      ");
        addObject (scoreLabel, 670, 230);
    }
}
