import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Jarrett here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Jarrett extends Enemy
{
    private int x;
    private int y;
    private GreenfootImage Jarrett = new GreenfootImage("bananas.png");
    public Jarrett() {
        GreenfootImage image = getImage();
        image.scale(25, 25);
        setImage(image);
    }
    /**
     * Act - do whatever the Jarrett wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (Room.timer%60 == 30){
            if (Greenfoot.getRandomNumber(20) == 2) {
                if((Room.numberJarrett < 10)) {
                    Jarrett jarrett = new Jarrett();
                    x = Greenfoot.getRandomNumber(500);
                    y = Greenfoot.getRandomNumber(500);
                    getWorld().addObject(jarrett, (x + (12 - (x % 25))), (y+ (12 - (y % 25))));
                    Room.numberJarrett++;
                    Room.totalPeeps++;
                }
            }
        }
    }    
}
