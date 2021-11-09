import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A playable radio. It can play two songs (1 or 2).
 * 
 * @author Michael Kölling
 * @version 1.2
 */
public class Radio extends Actor
{
    private static final int PLAYTIME = 20;
    
    private GreenfootSound[] music;
    private int playing;
    
    private int playTimer;
    
    public Radio()
    {
        music = new GreenfootSound[2];
        music[0] = new GreenfootSound("song1.wav");
        music[1] = new GreenfootSound("song2.wav");
        playing = 0;
    }
    
    /**
     * Play a song. There are only two valid parameter values: 1 or 2.
     */
    public void play(int song)
    {
        if (song < 1 || song > 2) {
            return;
        }
        
        playTimer = PLAYTIME;

        if (playing != 0 && playing != song) {     // something else is playing
            music[playing-1].pause();
        }
        
        if (playing != song) {
            playing = song;
            music[playing-1].play();
        }
    }
    
    public void stop()
    {
        if(playing > 0) {
            music[playing-1].pause();
            playing = 0;
        }
    }
    
    public void act()
    {
        if (playTimer <= 0) {
            stop();
        }
        else {
            playTimer--;
        }
    }
}
