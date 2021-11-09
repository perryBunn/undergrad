import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 */
public class DodecahedronTest {

   // variables and objects
   private Dodecahedron d = new Dodecahedron("test", "cyan", 2.5);
   private Dodecahedron dTrue = new Dodecahedron("test", "cyan", 2.5);
   private Dodecahedron dFalse = new Dodecahedron("false", "fasle", .25);
   private double edge = d.getEdge();

   /**
    *
    * @throws Exception thows exception bc it might
    */
   @Before
   public void setUp() throws Exception {

   }

   /**
    *
    * @throws Exception thows exception bc it might
    */
   @Test
   public void getLabel() throws Exception {
      Assert.assertEquals("test", d.getLabel());
   }

   /**
    *
    * @throws Exception thows exception bc it might
    */
   @Test
   public void setLabel() throws Exception {
      Assert.assertEquals(true, d.setLabel("test2"));
   }

   /**
    *
    * @throws Exception thows exception bc it might
    */
   @Test
   public void getColor() throws Exception {
      Assert.assertEquals("cyan", d.getColor());
   }

   /**
    *
    * @throws Exception thows exception bc it might
    */
   @Test
   public void setColor() throws Exception {
      Assert.assertEquals(true, d.setColor("blue"));
   }

   /**
    *
    * @throws Exception thows exception bc it might
    */
   @Test
   public void getEdge() throws Exception {
      Assert.assertEquals(2.5, d.getEdge(), .001);
   }

   /**
    *
    * @throws Exception thows exception bc it might
    */
   @Test
   public void setEdge() throws Exception {
      Assert.assertEquals(true, d.setEdge(.25));
   }

   /**
    *
    * @throws Exception thows exception bc it might
    */
   @Test
   public void surfaceArea() throws Exception {
      Assert.assertEquals(3 * Math.sqrt(25 + 10 * Math.sqrt(5))
                                 * Math.pow(edge, 2), d.surfaceArea(), .001);
   }

   /**
    *
    * @throws Exception thows exception bc it might
    */
   @Test
   public void volume() throws Exception {
      Assert.assertEquals("Check your volume equation", ((15 + 7
               * Math.sqrt(5)) / (4)) * Math.pow(edge, 3), d.volume(), .001);
   }

   /**
    *
    * @throws Exception thows exception bc it might
    */
   @Test
   public void surfaceToVolumeRatio() throws Exception {
      Assert.assertEquals(
             (3 * Math.sqrt(25 + 10 * Math.sqrt(5)) * Math.pow(edge, 2)) 
                    / (((15 + 7 * Math.sqrt(5)) / (4)) * Math.pow(edge, 3)),
              d.surfaceToVolumeRatio(), .001
      );
   }

   /**
    *
    * @throws Exception thows exception bc it might
    */
   @Test
   public void toStringTest() {
      Dodecahedron[] dodObjList = new Dodecahedron[10];
      for (int i = 0; i < 5; i++) {
         Dodecahedron dodObj = new Dodecahedron("test" + i, "color" + i, 
                                                               i + .25);
         dodObjList[i] = dodObj;
      }
      Assert.assertEquals("", true, dodObjList[4].toString().contains("4.25"));
   }

   /**
    * wont grade if not comented out
    * @throws Exception thows exception bc it might
    */
    /*
   @Test
   public void resetCount() throws Exception {
      Dodecahedron.resetCount();
      Assert.assertEquals(true, count == 0);
   }
   */

   /**
    *
    * @throws Exception thows exception bc it might
    */
   @Test
   public void equalsTest() throws Exception {
      Assert.assertFalse(d.equals(dFalse));
      Assert.assertTrue(d.equals(dTrue));
   }

   /**
    *
    * @throws Exception thows exception bc it might
    */
   @Test
   public void hashCodeTest() {
      Assert.assertTrue(0 == d.hashCode());
   }
}