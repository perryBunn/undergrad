import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class startGame here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class startGame extends Actor
{
    private GreenfootImage startGame = new GreenfootImage("startButton.png");
    public startGame() {
        GreenfootImage image = getImage();
        setImage(image);
    }
    public void act() 
    {
         if (Greenfoot.mouseClicked(this))
        {
            Greenfoot.setWorld(new Room());
        }
    }    
}