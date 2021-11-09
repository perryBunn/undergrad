import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Max here.
 *
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Max extends Enemy
{
    private int x;
    private int y;
    private GreenfootImage max = new GreenfootImage("rock.png");
    public Max() {
        GreenfootImage image = getImage();
        image.scale(25, 25);
        setImage(image);
    }
    /**
     * Act - do whatever the Max wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        Actor hero = (Actor)getWorld().getObjects(Hero.class).get(0);
        x = getX() - hero.getX();
        y = getY() - hero.getY();
        //Enemy move 2 spaces at a time
        if((Room.timer%60)==30) {
            if(Math.abs(x) < Math.abs(y)){
                    if(Math.abs(hero.getY()) > Math.abs(getY())){
                        setLocation(getX(), getY() + 50);
                    }
                    else{
                        setLocation(getX(), getY() - 50);
                    }
            }
            else if(Math.abs(x) > Math.abs(y)){
                    if(Math.abs(hero.getX()) > Math.abs(getX())){
                        setLocation(getX() + 50, getY());
                    }
                    else{
                        setLocation(getX() - 50, getY());
                    }
            }
            //If X distance and Y distance are equal, move 1 space at random
            else{
                int randomDir = Greenfoot.getRandomNumber(4);
                if(randomDir == 0){
                    setLocation(getX() + 25, getY());
                }
                else if(randomDir == 1){
                    setLocation(getX() - 25, getY());
                }
                else if(randomDir == 2){
                    setLocation(getX(), getY() + 25);
                }
                else if(randomDir == 3){
                    setLocation(getX(), getY() - 25);
                }
            }
        }
    }
}
