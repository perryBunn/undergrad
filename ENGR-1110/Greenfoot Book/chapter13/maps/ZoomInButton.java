import greenfoot.*;

/**
 * A button to zoom in.
 * 
 * @author Michael Kölling
 * @version 1.0
 */
public class ZoomInButton extends Button
{
    /**
     * Act when the user clicks on us.
     */
    public void act() 
    {
        if (Greenfoot.mouseClicked(this)) 
        {
            ((MapViewer)getWorld()).zoomIn();
        }
    }    
}
