import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 */
public class PieTest {

   // Test objects
   private Pie p1 = new Pie("Weekly Special", "Apple", 1, 0,
                     "flour", "sugar", "apples", "cinnamon",
                     "butter", "baking soda", "salt");
   private Pie p2 = new Pie("Summer Special", "Key Lime", 1, 2.0,
                     "flour", "sugar", "lime juice", "lemon juice",
                     "graham crackers", "butter", "baking soda", "salt");
            
   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }
   /**
    *
    */
   @Test public void getCrustCostTest() {
      // assert equals
      double result1 = p1.getCrustCost();
      Assert.assertEquals("", 0.0, result1, .001);
      // assert false
      double result2 = p2.getCrustCost();
      Assert.assertFalse("", 0.0 == result2);
   }
   /**
    *
    */
   @Test public void setCrustCostTest() {
      p1.setCrustCost(2);
      double result = p1.getCrustCost();
      Assert.assertEquals("", 2.0, result, .001);
   }
   /**
    *
    */
   @Test public void priceTest() {
      Assert.assertEquals("", 12, p1.price(), .001);
      Assert.assertFalse("", 12 == p2.price());
   }
}
