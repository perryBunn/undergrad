import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)

public class Room extends World
{
    public static int timer = 0;
    public static int totalPeeps = 0;
    int x = Greenfoot.getRandomNumber(500);
    int y = Greenfoot.getRandomNumber(500);
    int x1 = Greenfoot.getRandomNumber(500);
    int y1 = Greenfoot.getRandomNumber(500);
    int x2 = Greenfoot.getRandomNumber(500);
    int y2 = Greenfoot.getRandomNumber(500);
    int x3 = Greenfoot.getRandomNumber(500);
    int y3 = Greenfoot.getRandomNumber(500);
    public static int numberJarrett = 0;
    GreenfootSound backgroundMusic = new GreenfootSound("backgroundMusic.wav");
    public Room() 
    {
        super(500, 500, 1);
        Greenfoot.setSpeed(50);
        GreenfootImage background = new GreenfootImage("RoomBack1.png");
        GreenfootImage background2 = new GreenfootImage("RoomBack2.png");
        setBackground(background);
        Hero hero = new Hero();
        addObject(hero, 237, 237);
        Perry perry = new Perry();
        addObject(perry,(x + (12 - (x % 25))), (y+ (12 - (y % 25))));
        Dalton dalton = new Dalton();
        addObject(dalton, (x1 + (12 - (x1 % 25))), (y1+ (12 - (y1 % 25))));
        Max max = new Max();
        addObject(max, (x2 + (12 - (x2 % 25))), (y2+ (12 - (y2 % 25))));
        Jarrett jarrett = new Jarrett();
        addObject(jarrett, (x3 + (12 - (x3 % 25))), (y3 + (12 - (y3 % 25))));
        setPaintOrder(Hero.class, Dalton.class, Max.class, Perry.class);
        totalPeeps = getObjects(null).size();
    }
    public void act(){
        GreenfootImage background = new GreenfootImage("RoomBack1.png");
        GreenfootImage background2 = new GreenfootImage("RoomBack2.png");
        backgroundMusic.playLoop();
        if((timer%60)==0){
            setBackground(background);
         }
        if((timer%60)==30){
            setBackground(background2);
         }
        timer += 1;
    }
    public void stopped() {
        backgroundMusic.stop();
    }
}
