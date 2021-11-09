import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * .
 * @author Perry Bunn
 * @version 4/17/2017
 */
public class FlavorComparatorTest {
   /**
    *
    * @throws Exception throws exception because it might
    */
   @Before
   public void setUp() throws Exception {

   }

   /**
    *
    * @throws Exception throws exception because it might
    */
   @Test
   public void compare() throws Exception {
      BakedItemList b = new BakedItemList();
      b.readItemFile("baked_item_data2.csv");
      Assert.assertEquals("---------------------------------------\n"
            + "Report for Auburn's Best Bakery (by Flavor)\n"
            + "---------------------------------------\n\n"
            + "Cookie: Chips Delight - Chocolate Chip   "
            + "Quantity: 12   Price: $4.20\n"
            + "(Ingredients: flour, sugar, dark chocolate chips, butter, "
            + "baking soda, \n"
            + "salt)\n\n"
            + "Pie: Weekly Special - Apple   Quantity: 1   "
            + "Price: $12.00\n"
            + "(Ingredients: flour, sugar, apple, cinnamon, butter, \n"
            + "baking soda, salt)\n\n"
            + "Pie: Summer Special - Key Lime   Quantity: 1"
            + "   Price: $14.00\n"
            + "(Ingredients: flour, sugar, lime juice, lemon juice, graham "
            + "crackers, \n"
            + "butter, baking soda, salt)\n\n"
            + "Cake: Birthday - Chocolate   Quantity: 1   "
            + "Price: $8.00\n"
            + "(Ingredients: flour, sugar, cocoa powder, vanilla, eggs, \n"
            + "butter, baking soda, baking powder, salt)\n\n"
            + "Cake: 2-Layer - Red Velvet   Quantity: 1   "
            + "Price: $16.00\n"
            + "(Ingredients: flour, sugar, cocoa powder, food coloring, eggs, "
            + "\n"
            + "butter, baking soda, baking powder, salt)\n\n"
            + "WeddingCake: 3-Layer/3-Tier - Vanilla"
            + "   Quantity: 1   Price: $135.00\n"
            + "(Ingredients: flour, sugar, buttermilk, coffee, eggs, \n"
            + "butter, baking soda, baking powder, salt)\n"
            + "\n", b.generateReportByFlavor());
   }
}