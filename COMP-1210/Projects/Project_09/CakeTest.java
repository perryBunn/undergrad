import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 */
public class CakeTest {

   // Class Objects
   private Cake c1 = new Cake("Birthday", "Chocolate", 1, 1,
                        "flour", "sugar", "cocoa powder", "vanilla", "eggs",
                        "butter", "baking soda", "baking powder", "salt");
   private Cake c2 = new Cake("2-Layer", "Red Velvet", 1, 2,
                        "flour", "sugar", "cocoa powder", "food coloring",
                        "eggs", "butter", "baking soda", "baking powder",
                        "salt");

   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }
   /**
    *
    */
   @Test public void getLayersTest() {
      int result1 = c1.getLayers();
      Assert.assertEquals("", 1, result1);
      int result2 = c2.getLayers();
      Assert.assertFalse("", 0 == result2);
   }
   /**
    *
    */
   @Test public void setLayersTest() {
      c1.setLayers(4);
      int result1 = c1.getLayers();
      Assert.assertEquals("", 4, result1);
      c2.setLayers(1);
      int result2 = c1.getLayers();
      Assert.assertFalse("", 0 == result2);
   }
   /**
    *
    */
   @Test public void priceTest() {
      Assert.assertEquals("", 8, c1.price(), .001);
      Assert.assertFalse("", 12 == c2.price());
   }
}
