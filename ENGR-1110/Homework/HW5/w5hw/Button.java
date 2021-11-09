import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A button that moves randomly around the World.
 * 
 * @author  Dean Hendrix (dh@auburn.edu)
 * @author  YOUR NAME
 * @version 2016-02-11
 */
public class Button extends Actor
{
    
    private GreenfootImage image1;
    private GreenfootImage image2;
    public Button(){
        image1 = new GreenfootImage("button-green.png");
        image2 = new GreenfootImage("button-red.png");
        setImage(image2);
    }
    
    /**
     * Changes the location of this button approximately
     * 2% of the time.
     */
    public void act() {
        if (Greenfoot.getRandomNumber(100) < 2) {
            changeLocation();
        }
        else if (Greenfoot.getRandomNumber(100) > 98) {
            changeImage();
        }
        else {
            move(1);
        }
    }   
    
    /**
     * Sets the location of this Button object to a new (x, y) 
     * coordinate selected at random. The x coordinate wil be in 
     * the range 100 to 500 inclusive, and the y coordinate will 
     * be the range 100 to 300 inclusive.
     */
    public void changeLocation() {
        setLocation(Greenfoot.getRandomNumber(401) + 100, Greenfoot.getRandomNumber(201) + 100);
    }
    
    public void changeImage() {
        if (getImage() == image1){
            setImage(image2);
        }
        else {
            setImage(image1);
        }
    }
}
