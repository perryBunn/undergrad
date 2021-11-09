import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * .
 * @author Perry Bunn
 * @version 4/17/2017
 */
public class PriceComparatorTest {
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
            + "Report for Auburn's Best Bakery (by Price)\n"
            + "---------------------------------------\n\n"
            + "Cookie: Chips Delight - Chocolate Chip   "
            + "Quantity: 12   Price: $4.20\n"
            + "(Ingredients: flour, sugar, dark chocolate chips, butter, baking"
            + " soda, \nsalt)\n\n"
            + "Cake: Birthday - Chocolate   Quantity: 1   "
            + "Price: $8.00\n"
            + "(Ingredients: flour, sugar, cocoa powder, vanilla, eggs, \n"
            + "butter, baking soda, baking powder, salt)\n\n"
            + "Pie: Weekly Special - Apple   Quantity: 1   "
            + "Price: $12.00\n"
            + "(Ingredients: flour, sugar, apple, cinnamon, butter, \n"
            + "baking soda, salt)\n\n"
            + "Pie: Summer Special - Key Lime   Quantity: 1"
            + "   Price: $14.00\n"
            + "(Ingredients: flour, sugar, lime juice, lemon juice, graham "
            + "crackers, \nbutter, baking soda, salt)\n\n"
            + "Cake: 2-Layer - Red Velvet   Quantity: 1   "
            + "Price: $16.00\n"
            + "(Ingredients: flour, sugar, cocoa powder, food coloring, eggs, "
            + "\nbutter, baking soda, baking powder, salt)\n\n"
            + "WeddingCake: 3-Layer/3-Tier - Vanilla   "
            + "Quantity: 1   Price: $135.00\n(Ingredients: flour, sugar, "
            + "buttermilk, coffee, eggs, \nbutter, baking soda, baking powder,"
            + " salt)\n\n",
            b.generateReportByPrice());
   }
   
   /**
    *
    * @throws Exception throws exception because it might
    */
   @Test
   public void compare2() throws Exception {
      BakedItemList b = new BakedItemList();
      b.readItemFile("baked_item_data2.csv");
      b.getItemList()[0].setQuantity(40);
      Assert.assertEquals("---------------------------------------\n"
            + "Report for Auburn's Best Bakery (by Price)\n"
            + "---------------------------------------\n\n"
            + "Cake: Birthday - Chocolate   Quantity: 1   "
            + "Price: $8.00\n"
            + "(Ingredients: flour, sugar, cocoa powder, vanilla, eggs, \n"
            + "butter, baking soda, baking powder, salt)\n\n"
            + "Pie: Weekly Special - Apple   Quantity: 1   "
            + "Price: $12.00\n"
            + "(Ingredients: flour, sugar, apple, cinnamon, butter, \n"
            + "baking soda, salt)\n\n"
            + "Cookie: Chips Delight - Chocolate Chip   "
            + "Quantity: 40   Price: $14.00\n"
            + "(Ingredients: flour, sugar, dark chocolate chips, butter, baking"
            + " soda, \nsalt)\n\n"
            + "Pie: Summer Special - Key Lime   Quantity: 1"
            + "   Price: $14.00\n"
            + "(Ingredients: flour, sugar, lime juice, lemon juice, graham "
            + "crackers, \nbutter, baking soda, salt)\n\n"
            + "Cake: 2-Layer - Red Velvet   Quantity: 1   "
            + "Price: $16.00\n"
            + "(Ingredients: flour, sugar, cocoa powder, food coloring, eggs, "
            + "\nbutter, baking soda, baking powder, salt)\n\n"
            + "WeddingCake: 3-Layer/3-Tier - Vanilla   "
            + "Quantity: 1   Price: $135.00\n(Ingredients: flour, sugar, "
            + "buttermilk, coffee, eggs, \nbutter, baking soda, baking powder,"
            + " salt)\n\n",
            b.generateReportByPrice());
   }
}