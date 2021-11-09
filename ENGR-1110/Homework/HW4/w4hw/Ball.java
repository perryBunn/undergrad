import greenfoot.*;

/**
 * A ball with motion controlled by the keyboard and the ability
 * to remove buttons from the world.
 * 
 * @author  Dean Hendrix (dh@auburn.edu)
 * @author  YOUR NAME
 * @version 2016-02-05
 */
public class Ball extends Actor
{
    /**
     * Responds to motion control from the arrow keys and removes
     * any buttons from the world when it intersects them.
     */
    public void act()     {
        handleKeyPress();
        lookForButton();
    }   

    /**
     * Checks to see if the ball is "touching" an object of the Button class. 
     * If it is, then the ball removes from the World a Button that it touches. 
     * If the ball isn't touching an object of the Button class, then this 
     * method does nothing.
     */
    public void lookForButton() {
        if (isTouching(Button.class)) {
            removeTouching(Button.class);
        }
    }

    /**
     * Handles input from the arrow keys.
     */
    public void handleKeyPress() {
        checkLeftArrow();
        checkRightArrow();
        checkUpArrow();
        checkDownArrow();
    }

    /**
     * Checks to see if the left arrow key is being pressed. 
     * If it is, then the ball sets its rotation angle to zero degrees 
     * and moves backward 5 units. If it is not being pressed, 
     * this method does nothing.
     */
    public void checkLeftArrow() {
        if (Greenfoot.isKeyDown("left")) {
            setRotation(0);
            move(-5);
        }
    }

    /**
     * Checks to see if the right arrow key is being pressed. 
     * If it is, then the ball sets its rotation angle to zero degrees 
     * and moves forward 5 units. If it is not being pressed, 
     * this method does nothing.
     */
    public void checkRightArrow() {
        if (Greenfoot.isKeyDown("right")) {
            setRotation(0);
            move(5);
        }
    }

    /**
     * Checks to see if the up arrow key is being pressed. 
     * If it is, then the ball sets its rotation angle to 270 degrees 
     * and moves forward 5 units. If it is not being pressed, 
     * this method does nothing.
     */
    public void checkUpArrow() {
        if (Greenfoot.isKeyDown("up")) {
            setRotation(270);
            move(5);
        }
    }

    /**
     * Checks to see if the down arrow key is being pressed. 
     * If it is, then the ball sets its rotation angle to 90 degrees 
     * and moves forward 5 units. If it is not being pressed, 
     * this method does nothing.
     */
    public void checkDownArrow() {
        if (Greenfoot.isKeyDown("down")) {
            setRotation(90);
            move(5);
        }
    }
}
