import org.junit.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 *
 */
public class BakeryPart1Test {


   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
      BakedItem.resetCount();
   }


   /**
    *
    */
   @Test public void mainTest() {
      BakeryPart1 bp1 = new BakeryPart1();
      BakedItem.resetCount();
      BakeryPart1.main(null);
      Assert.assertEquals("", 7, BakedItem.getCount());
   }
   /**
    *
    */
   @After public void after() {
      BakedItem.resetCount();
   }
}
