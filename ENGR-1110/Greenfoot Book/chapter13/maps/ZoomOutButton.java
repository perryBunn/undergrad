import greenfoot.*;

/**
 * A button to zoom out.
 * 
 * @author Michael Kölling
 * @version 1.0
 */
public class ZoomOutButton extends Button
{
    /**
     * Act when the user clicks on us.
     */
    public void act() 
    {
        if (Greenfoot.mouseClicked(this)) 
        {
            ((MapViewer)getWorld()).zoomOut();
        }
    }    
}
