import greenfoot.*; 
import java.awt.Color;

/**
 * A world for the boids.
 * 
 * @author Poul Henriksen 
 * @version 2.0
 */
public class Sky extends World
{

    /**
     * Constructor for objects of class Sky.
     * 
     */
    public Sky()
    {    
        super(800, 600, 1);
        getBackground().setColor(new Color(220,220,100));
        
        getBackground().fill();
        populateTrees(100);
        populateBoids(50);
    }
    
    public void populateBoids(int number) {
        for(int i=0; i < number; i++) {            
             int x = (int) (Math.random() * getWidth());          
             int y = (int) (Math.random() * getHeight());
             Boid b = new Boid();
             addObject(b, x, y);
        }
    }
    
    public void populateTrees(int number) {
        // Size of block in pixels
        int blockSize = 70; 
        // Trees per block
        int treesPrBlock = 10;
        // How close together trees in a block are. Higher number, the closer they are.
        int blockCoherence = 1;
        for(int block = 0; block < number / treesPrBlock; block++) {           
             int x = Greenfoot.getRandomNumber(getWidth()/blockSize) * blockSize;   
             int y = Greenfoot.getRandomNumber(getHeight()/blockSize) * blockSize;  
             for(int t = 0; t < treesPrBlock; t++) {
                 int dx = Greenfoot.getRandomNumber(blockSize/blockCoherence);
                 int dy = Greenfoot.getRandomNumber(blockSize/blockCoherence);
                 Tree b = new Tree();
                 addObject(b, x  + dx, y + dy);                
             }    
        }        
    }
    
    
}
