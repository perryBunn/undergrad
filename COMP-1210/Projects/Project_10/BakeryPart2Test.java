import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Perry Bunn
 * @version 4/17/2017
 */
public class BakeryPart2Test {
   /**
    *
    * @throws Exception throws exception because it might
    */
   @Before
   public void setUp() throws Exception {
      BakedItemList.resetListCount();
   }

   /**
    *
    * @throws Exception throws exception because it might
    */
   @Test
   public void main1() throws Exception {
      BakeryPart2 app = new BakeryPart2();
      String[] args = {null};
      BakeryPart2.main(args);
      Assert.assertEquals(0, BakedItemList.getListCount());
   }

   /**
    *
    * @throws Exception throws exception because it might
    */
   @Test
   public void main2() throws Exception {
      BakeryPart2 app = new BakeryPart2();
      String[] args = {"baked_item_data.csv"};
      BakeryPart2.main(args);
      Assert.assertEquals(1, BakedItemList.getListCount());
   }
   
   /**
    *
    * @throws Exception throws exception because it might
    */
   @Test
   public void main3() throws Exception {
      BakeryPart2 app = new BakeryPart2();
      String[] args = {""};
      BakeryPart2.main(args);
      Assert.assertEquals(0, BakedItemList.getListCount());
   }

   /**
    *
    * @throws Exception throws exception because it might
    */
   @Test
   public void main4() throws Exception {
      BakeryPart2 app = new BakeryPart2();
      String[] args = {null};
      BakeryPart2.main(args);
      Assert.assertEquals(0, BakedItemList.getListCount());
   }
}