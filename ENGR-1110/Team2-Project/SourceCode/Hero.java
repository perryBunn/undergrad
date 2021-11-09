import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)
import java.awt.Color;
import java.util.*;
public class Hero extends Actor
{
    private GreenfootImage hero = new GreenfootImage("Hero.png");
    private int moveOnce = 0;
    private int HP = 10;
    private int mercy = 0;
    private int Score = 0;
    private Object img;
    GreenfootSound damageSound = new GreenfootSound("damageSound.wav");
    GreenfootSound killEnemy = new GreenfootSound("killEnemy.wav");
    public Hero()
    {
       setImage(hero);
    }
    public void act()
    {
        if((Room.timer%60)>30){
            moveOnce = 0;
        }
        if((Room.timer%30)>15){
            mercy = 0;
        }
        checkKeys();
        checkCollision();
        if( Score >= 15 ) {
            if ( HP != 10) {
                HP++;
                Score = Score - 15;
            }
        }
        getWorld().showText("Health: " + HP, 50, 10);
        getWorld().showText("Score: " + Score, 200, 10);
    }
    /**
     * Check whether we are colliding with an asteroid.
     */
    private void checkCollision() 
    {
        for(int i = 0; i < getWorld().getObjects(Actor.class).size(); i++) {
            if (((getWorld().getObjects(Actor.class).get(i)).getX()) == getX() 
                & (((getWorld().getObjects(Actor.class).get(i)).getY()) == getY())) {
                    if (getWorld().getObjects(Actor.class).get(i) != this) {
                        getWorld().removeObject(getWorld().getObjects(Actor.class).get(i));
                        Room.totalPeeps--;
                        Score = Score + 7;
                        killEnemy.play();
                    }
            }
        }
            if (Room.totalPeeps == 1) {
              setLocation(250,250);
              GreenfootImage img = getImage();
              img.setFont(img.getFont().deriveFont(30f));
              setImage(new GreenfootImage("YOU WIN!!" , 75, Color.WHITE, Color.BLACK));
              Greenfoot.stop();
        }
    }
    
    /**
     * Check whether there are any key pressed and react to them.
     */
    private void checkKeys() 
    {
        if((Greenfoot.getKey() != null) & (Room.timer%60)>30){
            if(mercy == 0){
                HP -= 1;
                Score = Score - 6;
                damageSound.play();
                mercy = 1;
                if(HP == 0){
                    setLocation(250,250);
                    GreenfootImage img = getImage();
                    img.setFont(img.getFont().deriveFont(30f));
                    setImage(new GreenfootImage("YOU LOSE" , 75, Color.WHITE, Color.BLACK));
                    Greenfoot.stop();
                }
            }
        }
        if(Greenfoot.isKeyDown("w")& (Room.timer%60)<30){
            if(moveOnce == 0 & getY()>12){
                setLocation(getX(), getY()-25);
                moveOnce = 1;
                Score++;
            }
        }
        if(Greenfoot.isKeyDown("a")& (Room.timer%60)<30) {
            if(moveOnce == 0 & getX()>12){
                setLocation(getX()-25, getY());
                moveOnce = 1;
                Score++;
            }
        }        
        if(Greenfoot.isKeyDown("d")& (Room.timer%60)<30) {
            if(moveOnce == 0 & getY()<488){
                setLocation(getX()+25, getY());
                moveOnce = 1;
                Score++;
            }
        }     
        if(Greenfoot.isKeyDown("s")& (Room.timer%60)<30){
            if(moveOnce == 0 & getY()<488){
                setLocation(getX(), getY()+25);
                moveOnce = 1;
                Score++;
            }
        }
    }
}