import greenfoot.*; 

/**
 * Map is a world that displays a Google map image as its background.
 * 
 * @author Michael Kölling
 * @version 1.0
 */
public class MapViewer extends World
{
    private static final int WIDTH = 600;
    private static final int HEIGHT = 500;

    private Map map;

    /**
     * Create a new map viewer centered on the University of Kent, but fairly
     * far zoomed out.
     */
    public MapViewer()
    {
        super(WIDTH, HEIGHT, 1);
        
        // locations can be specified by name, post code, or long/lat coordinates
        
        String location = "CT2 7NF, UK";

        // other locations to try:
        
        //String location = "Paris, France";
        //String location = "Brazil";
        //String location = "Taj Mahal";
        //String location = "Brooklyn Bridge, New York, NY";
        //String location = "51.178882,-1.826216";
        
        map = new Map(location, WIDTH, HEIGHT, 4);
        setBackground(map.getImage());
        
        //setType("hybrid");

        prepare();
    }

    /**
     * Zoom in at the current view.
     */
    public void zoomIn() 
    {
        map.zoomIn(1);
        setBackground(map.getImage());
    }

    /**
     * Zoom in out the current view.
     */
    public void zoomOut() 
    {
        map.zoomOut(1);
        setBackground(map.getImage());
    }

    /**
     * Set the map type. Possible parameters are "roadmap", "satellite", "hybrid" or "terrain".
     */
    public void setType(String type) 
    {
        map.setType(type);
        setBackground(map.getImage());
    }

    /**
     * Prepare the world for the start of the program. That is: create the initial
     * objects and add them to the world.
     */
    private void prepare()
    {
        ZoomInButton zoominbutton = new ZoomInButton();
        addObject(zoominbutton, 50, 60);
        ZoomOutButton zoomoutbutton = new ZoomOutButton();
        addObject(zoomoutbutton, 50, 110);
    }
}
