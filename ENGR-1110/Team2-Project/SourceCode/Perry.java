import greenfoot.*;
public class Perry extends Enemy
{
    private GreenfootImage perry = new GreenfootImage("rocketWithThrust.png");
    private int x;
    private int y;
    private int DifX;
    private int DifY;
    /**
     * Act - do whatever the Perry wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        //the horror! this code might work right....
        // im so sorry.
        Actor hero = (Actor)getWorld().getObjects(Hero.class).get(0);
        x = this.getX();
        y = this.getY();
        DifX = getX() - hero.getX();
        DifY = getY() - hero.getY();
        if((Room.timer%60)==30) {
            if (Math.abs(DifX) < 50 || Math.abs(DifY) < 50) {
                if (getX() != 12 & getX() != 487 & getY() != 12 & getY() != 487) {
                    if(Math.abs(DifX) < Math.abs(DifY)){
                        if(Math.abs(hero.getY()) > Math.abs(getY())){
                            setLocation(getX(), getY() - 25);
                        } else {
                            setLocation(getX(), getY() + 25);
                        }
                    } else if (Math.abs(DifX) == 0) {
                        if (getY() > 250 ) {
                            setLocation(getX(), getY() - 25);
                        } else {
                            setLocation(getX(), getY() + 25);
                        }
                    } else if (Math.abs(DifX) > Math.abs(DifY)){
                        if(Math.abs(hero.getX()) > Math.abs(getX())){
                            setLocation(getX() - 25, getY());
                        } else {
                            setLocation(getX() + 25, getY());
                        }
                    }else if (Math.abs(DifY) == 0) {
                        if (getX() > 250 ) {
                            setLocation(getX() - 25, getY());
                        } else {
                            setLocation(getX() + 25, getY());
                        }
                    } else {
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
            } else {
                if(getX() != 12 & getX() != 487 & getY() != 12 & getY() != 487) {
                    int randomDir = Greenfoot.getRandomNumber(4);
                    if(randomDir == 0){
                        setLocation(getX() - 25, getY());
                    }else if(randomDir == 1){
                        setLocation(getX() + 25, getY());
                    }else if(randomDir == 2){
                        setLocation(getX(), getY() - 25);
                    }else if(randomDir == 3){
                        setLocation(getX(), getY() + 25);
                    }
                } else {
                    if(x == 12) {
                        setLocation(getX() + 25, getY());
                    }
                    if(x == 487) {
                        setLocation(getX() - 25, getY());
                    }
                    if(y == 12) {
                        setLocation(getX(), getY() + 25);
                    }
                    if(y == 487) {
                        setLocation(getX(), getY() - 25);
                    }
                }
            }
        }
    }
}
