import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of this class here.
 * 
 * @author Dean Hendrix (dh@auburn.edu) 
 * @version 2016-02-11
 */
public class ButtonWorld extends World
{

    /**
     * Constructor for objects of class ButtonWorld.
     * 
     */
    public ButtonWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        
        Ball myBall = new Ball();
        addObject(myBall, 500, 400);
        
        Ball removedB;
        
        Button myButton = new Button();
        addObject(myButton, Greenfoot.getRandomNumber(600), Greenfoot.getRandomNumber(400));
        Button myButton1 = new Button();
        addObject(myButton1, Greenfoot.getRandomNumber(600), Greenfoot.getRandomNumber(400));
        Button myButton2 = new Button();
        addObject(myButton2, Greenfoot.getRandomNumber(600), Greenfoot.getRandomNumber(400));
        Button myButton3 = new Button();
        addObject(myButton3, Greenfoot.getRandomNumber(600), Greenfoot.getRandomNumber(400));
        Button myButton4 = new Button();
        addObject(myButton4, Greenfoot.getRandomNumber(600), Greenfoot.getRandomNumber(400));
        Button myButton5 = new Button();
        addObject(myButton5, Greenfoot.getRandomNumber(600), Greenfoot.getRandomNumber(400));
        Button myButton6 = new Button();
        addObject(myButton6, Greenfoot.getRandomNumber(600), Greenfoot.getRandomNumber(400));
        Button myButton7 = new Button();
        addObject(myButton7, Greenfoot.getRandomNumber(600), Greenfoot.getRandomNumber(400));
        Button myButton8 = new Button();
        addObject(myButton8, Greenfoot.getRandomNumber(600), Greenfoot.getRandomNumber(400));
        Button myButton9 = new Button();
        addObject(myButton9, Greenfoot.getRandomNumber(600), Greenfoot.getRandomNumber(400));
    }
}
