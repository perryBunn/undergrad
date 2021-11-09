import greenfoot.*;
import javax.imageio.ImageIO;

/**
 * A helper class that fetch a googleMap for a specific location
 * as an Image.
 * 
 * <pre>
 * public class MapActor extends Actor
 * {
 *     Map map;
 *     public MapActor() 
 *     {
 *         map = new Map("Brazil");
 *         setImage(map.getImage());
 *     }
 *     
 *     public void act() 
 *     {
 *         map.zoomIn(1);
 *         setImage(map.getImage());
 *     }
 *     
 *     public void setType(String type) 
 *     {
 *         map.setType(type);
 *         setImage(map.getImage());
 *     }
 * }
 * </pre>
 * 
 * @author amjad
 * @version 2.0
 */
public class Map {

    private final String urlBase = "http://maps.googleapis.com/maps/api/staticmap?sensor=false";
    
    private int zoom;
    private int width;
    private int height;
    private String location;

    private GreenfootImage image;
    
    private enum MapType { ROADMAP, SATELLITE, HYBRID, TERRAIN;}
    private MapType type = MapType.ROADMAP;
    
    /**
     * Constructs a map object that build a map of a specific location,
     * e.g."-15.800513, -47.91378" or "Brooklyn Bridge, New York, NY".
     * The width and height fields will be set to default values as 600 x 400.
     * The zoom field will be set to default as 5.
     * 
     *  @param location  the location represents the center the map.
     */
    public Map(String location)
    {
        this(location, 600, 400, 5);
    }
    
    /**
     * Constructs a map object that build a map of a specific location,
     * e.g."-15.800513, -47.91378" or "Brooklyn Bridge, New York, NY".
     * 
     *  @param location  the location represents the center the map.
     *  @param width     the image's width.
     *  @param height    the image's height.
     *  @param zoom      the zoom factor of the map [0-20].
     */
    public Map(String location, int width, int height, int zoom)
    {
        this.location = location;
        this.width = width;
        this.height = height;
        setZoom(zoom);
    }
    
    /**
     * Sets the zoom factor insuring it is in the range [0-20].
     * 
     * @param value the zoom factor.
     */
    public void setZoom(int value)
    {
        zoom = value;
        if (zoom > 20) {
            zoom = 20;
        }
        if (zoom < 0) {
            zoom = 0;
        }
        buildImage();
    }
    
    /**
     * Prepares the url of the map and retrievs an image represention of this map.
     */
    private void buildImage()
    {
        String urlAddress = urlBase;
        urlAddress += "&center=" + location.replace(" ", "+");
        urlAddress += "&size=" + width + "x" + height;
        urlAddress += "&zoom=" + zoom;
        urlAddress += "&maptype=" + type.toString().toLowerCase();
        
        image = new GreenfootImage(urlAddress);
    }
    
    /**
     * Sets the location.
     * 
     * @param location  the new location.
     */
    public void setLocation(String location)
    {
        this.location = location;
        buildImage();
    }
    
    /**
     * Returns the map represented as GreenfootImage.
     * 
     * @return GreenfootImage of the map. 
     */
    public GreenfootImage getImage()
    {
        return image;
    }
    
    /**
     * Sets the type of the map as one of: roadmap, satellite, hybrid or terrain.
     * 
     * @param type  the type of the map.
     * @exception if the passed parameter is not one of the predefined types.
     */
    public void setType(String type)
    {
        try {
            this.type = MapType.valueOf(type.toUpperCase());
        }
        catch(IllegalArgumentException ex) {
            System.err.println(type + " is not a valid map type. Please use: roadmap, satellite, hybrid or terrain");
        }
        buildImage();
    }
    
    /**
     * Increases the zoom factor.
     * 
     * @param value  the change of the zoom factor.
     */
    public void zoomIn(int value)
    {
        setZoom(zoom + value);
    }
    
    /**
     * Decreases the zoom factor.
     * 
     * @param value  the change of the zoom factor.
     */
    public void zoomOut(int value)
    {
        setZoom(zoom - value);
    }
}