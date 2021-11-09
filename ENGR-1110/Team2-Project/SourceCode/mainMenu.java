import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
import java.util.*;
/**
 * Write a description of class mainMenu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class mainMenu extends World
{
    
    public mainMenu()
    {
       super(500, 500, 1); 
       startGame start = new startGame();
       addObject(start, 250, 300);
       aImage a = new aImage();
       addObject(a, 130, 100);
       dImage d = new dImage();
       addObject(d, 220, 100);
       sImage s = new sImage();
       addObject(s, 175, 100);
       wImage w = new wImage();
       addObject(w, 175, 55);
    }
    public void act()
    {
        showText("use the keys 'W' 'S' 'A' 'D' to move around",250,20);
    }
}

