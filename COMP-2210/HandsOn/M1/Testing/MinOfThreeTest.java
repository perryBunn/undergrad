import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 *
 * @author Perry Bunn
 * @version 8/29/2017
 */
public class MinOfThreeTest {
   @Before
   public void setUp() throws Exception {
   }

   @Test
   public void min1() throws Exception {
      int i = 0;
      int j = 0;
      int k = 4;
      int expected = 0;
      int actual = MinOfThree.min1(i, j, k);
      Assert.assertEquals(expected, actual);
   }

   @Test
   public void min2() throws Exception {
      int i = 0;
      int j = 0;
      int k = 4;
      int expected = 0;
      int actual = MinOfThree.min2(i, j, k);
      Assert.assertEquals(expected, actual);
   }

   @Test
   public void min1_1() throws Exception {
      int i = 4;
      int j = 4;
      int k = 4;
      int expected = 4;
      int actual = MinOfThree.min2(i, j, k);
      Assert.assertEquals(expected, actual);
   }

   @Test
   public void min2_1() throws Exception {
      int i = 3;
      int j = 3;
      int k = 3;
      int expected = 3;
      int actual = MinOfThree.min2(i, j, k);
      Assert.assertEquals(expected, actual);
   }

   @Test
   public void min1_2() throws Exception {
      int i = 1;
      int j = 2;
      int k = 3;
      int expected = 1;
      int actual = MinOfThree.min2(i, j, k);
      Assert.assertEquals(expected, actual);
   }

   @Test
   public void min2_2() throws Exception {
      int i = 2;
      int j = 3;
      int k = 4;
      int expected = 2;
      int actual = MinOfThree.min2(i, j, k);
      Assert.assertEquals(expected, actual);
   }
}