import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Perry Bunn
 * @version 4/17/2017
 */
public class BakedItemListTest {
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
   public void getListName() throws Exception {
      BakedItemList b = new BakedItemList();
      Assert.assertEquals("", b.getListName());
   }

   /**
    *
    * @throws Exception throws exception because it might
    */
   @Test
   public void setListName() throws Exception {
      BakedItemList b = new BakedItemList();
      b.setListName("Test");
      Assert.assertEquals("Test", b.getListName());
   }

   /**
    *
    * @throws Exception throws exception because it might
    */
   @Test
   public void getItemList() throws Exception {
      BakedItemList b = new BakedItemList();
      BakedItem[] itemList = {null};
      Assert.assertEquals(itemList[0], b.getItemList()[0]);
   }

   /**
    *
    * @throws Exception throws exception because it might
    */
   @Test
   public void setItemList() throws Exception {
      BakedItemList b = new BakedItemList();
      String[] ingredientsTrim = {"test"};
      Cookie c = new Cookie("test", "test", 1,
            ingredientsTrim);
      BakedItem[] itemList = {c};
      b.setItemList(itemList);
      Assert.assertEquals(c, b.getItemList()[0]);
   }

   /**
    *
    * @throws Exception throws exception because it might
    */
   @Test
   public void getItemCount() throws Exception {
      BakedItemList b = new BakedItemList();
      Assert.assertEquals(0, b.getItemCount());
   }

   /**
    *
    * @throws Exception throws exception because it might
    */
   @Test
   public void setItemCount() throws Exception {
      BakedItemList b = new BakedItemList();
      b.setItemCount(1);
      Assert.assertEquals(1, b.getItemCount());
   }

   /**
    *
    * @throws Exception throws exception because it might
    */
   @Test
   public void getExcludedRecords() throws Exception {
      BakedItemList b = new BakedItemList();
      String[] excludedRecords = {null};
      Assert.assertEquals(excludedRecords[0], b.getExcludedRecords()[0]);
   }

   /**
    *
    * @throws Exception throws exception because it might
    */
   @Test
   public void setExcludedRecords() throws Exception {
      BakedItemList b = new BakedItemList();
      String[] excludedRecords = {"Test,test,test,0,test,test,test,test"};
      b.setExcludedRecords(excludedRecords);
      Assert.assertEquals(excludedRecords[0], b.getExcludedRecords()[0]);
   }

   /**
    *
    * @throws Exception throws exception because it might
    */
   @Test
   public void getExcludedCount() throws Exception {
      BakedItemList b = new BakedItemList();
      Assert.assertEquals(0, b.getExcludedCount());
   }

   /**
    *
    * @throws Exception throws exception because it might
    */
   @Test
   public void setExcludedCount() throws Exception {
      BakedItemList b = new BakedItemList();
      b.setExcludedCount(1);
      Assert.assertEquals(1, b.getExcludedCount());
   }

   /**
    *
    * @throws Exception throws exception because it might
    */
   @Test
   public void getListCount() throws Exception {
      BakedItemList b = new BakedItemList();
      Assert.assertEquals(1, BakedItemList.getListCount());
   }
   /**
    *
    * @throws Exception throws exception because it might
    */
   @Test
   public void resetListCount() throws Exception {
      BakedItemList b = new BakedItemList();
      BakedItemList.resetListCount();
      Assert.assertEquals(0, BakedItemList.getListCount());
   }

   /**
    *
    * @throws Exception throws exception because it might
    */
   @Test
   public void readItemFile() throws Exception {
      BakedItemList b = new BakedItemList();
      b.readItemFile("baked_item_data2.csv");
      Assert.assertEquals("Auburn's Best Bakery", b.getListName());
      Assert.assertEquals(6, b.getItemCount());
      Assert.assertEquals(5, b.getExcludedCount());
   }

   /**
    *
    * @throws Exception throws exception because it might
    */
   @Test
   public void generateReport() throws Exception {
      BakedItemList b = new BakedItemList();
      b.readItemFile("baked_item_data2.csv");
      String result = "---------------------------------------\n"
            + "Report for Auburn's Best Bakery\n"
            + "---------------------------------------\n"
            + "\n"
            + "Cookie: Chips Delight - Chocolate Chip   "
            + "Quantity: 12   Price: $4.20\n"
            + "(Ingredients: flour, sugar, dark chocolate chips, butter, baking"
            + " soda, \n"
            + "salt)\n"
            + "\n"
            + "Pie: Weekly Special - Apple   Quantity: 1   "
            + "Price: $12.00\n"
            + "(Ingredients: flour, sugar, apple, cinnamon, butter, \n"
            + "baking soda, salt)\n"
            + "\n"
            + "Pie: Summer Special - Key Lime   Quantity: 1"
            + "   Price: $14.00\n"
            + "(Ingredients: flour, sugar, lime juice, lemon juice, graham "
            + "crackers, \n"
            + "butter, baking soda, salt)\n"
            + "\n"
            + "Cake: Birthday - Chocolate   Quantity: 1   "
            + "Price: $8.00\n"
            + "(Ingredients: flour, sugar, cocoa powder, vanilla, eggs, \n"
            + "butter, baking soda, baking powder, salt)\n"
            + "\n"
            + "Cake: 2-Layer - Red Velvet   Quantity: 1   "
            + "Price: $16.00\n"
            + "(Ingredients: flour, sugar, cocoa powder, food coloring, eggs, "
            + "\nbutter, baking soda, baking powder, salt)\n"
            + "\n"
            + "WeddingCake: 3-Layer/3-Tier - Vanilla   "
            + "Quantity: 1   Price: $135.00\n"
            + "(Ingredients: flour, sugar, buttermilk, coffee, eggs, \n"
            + "butter, baking soda, baking powder, salt)\n"
            + "\n";
      Assert.assertEquals(result, b.generateReport());
   }

   /**
    *
    * @throws Exception throws exception because it might
    */
   @Test
   public void generateReportByClass() throws Exception {
      BakedItemList b = new BakedItemList();
      b.readItemFile("baked_item_data2.csv");
      String result = "---------------------------------------\n"
            + "Report for Auburn's Best Bakery (by Class)\n"
            + "---------------------------------------\n"
            + "\n"
            + "Cake: 2-Layer - Red Velvet   Quantity: 1   "
            + "Price: $16.00\n"
            + "(Ingredients: flour, sugar, cocoa powder, food coloring, eggs, "
            + "\nbutter, baking soda, baking powder, salt)\n"
            + "\n"
            + "Cake: Birthday - Chocolate   Quantity: 1   "
            + "Price: $8.00\n"
            + "(Ingredients: flour, sugar, cocoa powder, vanilla, eggs, \n"
            + "butter, baking soda, baking powder, salt)\n"
            + "\n"
            + "Cookie: Chips Delight - Chocolate Chip   "
            + "Quantity: 12   Price: $4.20\n"
            + "(Ingredients: flour, sugar, dark chocolate chips, butter, baking"
            + " soda, \n"
            + "salt)\n"
            + "\n"
            + "Pie: Summer Special - Key Lime   Quantity: 1"
            + "   Price: $14.00\n"
            + "(Ingredients: flour, sugar, lime juice, lemon juice, graham "
            + "crackers, \n"
            + "butter, baking soda, salt)\n"
            + "\n"
            + "Pie: Weekly Special - Apple   Quantity: 1   "
            + "Price: $12.00\n"
            + "(Ingredients: flour, sugar, apple, cinnamon, butter, \n"
            + "baking soda, salt)\n"
            + "\n"
            + "WeddingCake: 3-Layer/3-Tier - Vanilla   "
            + "Quantity: 1   Price: $135.00\n"
            + "(Ingredients: flour, sugar, buttermilk, coffee, eggs, \n"
            + "butter, baking soda, baking powder, salt)\n\n";
      Assert.assertEquals(result, b.generateReportByClass());
   }

   /**
    *
    * @throws Exception throws exception because it might
    */
   @Test
   public void generateReportByPrice() throws Exception {
      BakedItemList b = new BakedItemList();
      b.readItemFile("baked_item_data2.csv");
      String result = "---------------------------------------\n"
            + "Report for Auburn's Best Bakery (by Price)\n"
            + "---------------------------------------\n"
            + "\n"
            + "Cookie: Chips Delight - Chocolate Chip   "
            + "Quantity: 12   Price: $4.20\n"
            + "(Ingredients: flour, sugar, dark chocolate chips, butter, baking"
            + " soda, \n"
            + "salt)\n"
            + "\n"
            + "Cake: Birthday - Chocolate   Quantity: 1   "
            + "Price: $8.00\n"
            + "(Ingredients: flour, sugar, cocoa powder, vanilla, eggs, \n"
            + "butter, baking soda, baking powder, salt)\n"
            + "\n"
            + "Pie: Weekly Special - Apple   Quantity: 1   "
            + "Price: $12.00\n"
            + "(Ingredients: flour, sugar, apple, cinnamon, butter, \n"
            + "baking soda, salt)\n"
            + "\n"
            + "Pie: Summer Special - Key Lime   "
            + "Quantity: 1   Price: $14.00\n"
            + "(Ingredients: flour, sugar, lime juice, lemon juice, graham "
            + "crackers, \n"
            + "butter, baking soda, salt)\n"
            + "\n"
            + "Cake: 2-Layer - Red Velvet   Quantity: 1   "
            + "Price: $16.00\n"
            + "(Ingredients: flour, sugar, cocoa powder, food coloring, eggs, "
            + "\nbutter, baking soda, baking powder, salt)\n"
            + "\n"
            + "WeddingCake: 3-Layer/3-Tier - Vanilla   "
            + "Quantity: 1   Price: $135.00\n"
            + "(Ingredients: flour, sugar, buttermilk, coffee, eggs, \n"
            + "butter, baking soda, baking powder, salt)\n"
            + "\n";
      Assert.assertEquals(result, b.generateReportByPrice());
   }

   /**
    *
    * @throws Exception throws exception because it might
    */
   @Test
   public void generateReportByFlavor() throws Exception {
      BakedItemList b = new BakedItemList();
      b.readItemFile("baked_item_data2.csv");
      String result = "---------------------------------------\n"
            + "Report for Auburn's Best Bakery (by Flavor)\n"
            + "---------------------------------------\n"
            + "\n"
            + "Cookie: Chips Delight - Chocolate Chip   "
            + "Quantity: 12   Price: $4.20\n"
            + "(Ingredients: flour, sugar, dark chocolate chips, butter, "
            + "baking soda, \n"
            + "salt)\n"
            + "\n"
            + "Pie: Weekly Special - Apple   Quantity: 1   "
            + "Price: $12.00\n"
            + "(Ingredients: flour, sugar, apple, cinnamon, butter, \n"
            + "baking soda, salt)\n"
            + "\n"
            + "Pie: Summer Special - Key Lime   Quantity: 1"
            + "   Price: $14.00\n"
            + "(Ingredients: flour, sugar, lime juice, lemon juice, graham "
            + "crackers, \n"
            + "butter, baking soda, salt)\n"
            + "\n"
            + "Cake: Birthday - Chocolate   "
            + "Quantity: 1   Price: $8.00\n"
            + "(Ingredients: flour, sugar, cocoa powder, vanilla, eggs, \n"
            + "butter, baking soda, baking powder, salt)\n"
            + "\n"
            + "Cake: 2-Layer - Red Velvet   Quantity: 1   "
            + "Price: $16.00\n"
            + "(Ingredients: flour, sugar, cocoa powder, food coloring, eggs, "
            + "\nbutter, baking soda, baking powder, salt)\n"
            + "\n"
            + "WeddingCake: 3-Layer/3-Tier - Vanilla   "
            + "Quantity: 1   Price: $135.00\n"
            + "(Ingredients: flour, sugar, buttermilk, coffee, eggs, \n"
            + "butter, baking soda, baking powder, salt)\n"
            + "\n";
      Assert.assertEquals(result, b.generateReportByFlavor());
   }

   /**
    *
    * @throws Exception throws exception because it might
    */
   @Test
   public void generateExcludedRecordsReport() throws Exception {
      BakedItemList b = new BakedItemList();
      b.readItemFile("baked_item_data2.csv");
      String result = "---------------------------------------\n"
            + "Excluded Records Report\n"
            + "---------------------------------------\n"
            + "\n"
            + "*** InvalidCategoryException: InvalidCategoryException: For "
            + "category: \"D\"in:\n"
            + "D,Chips Delight,Chocolate Chip,12,flour,sugar,dark chocolate "
            + "chips,butter,baking soda,salt\n"
            + "*** java.lang.NumberFormatException: For input string: \"1.0\" "
            + "in:\n"
            + "P,Daily Special,Pecan,1.0,0,flour,sugar,pecans,dark corn syrup,"
            + "butter,baking soda,salt\n"
            + "*** InvalidCategoryException: InvalidCategoryException: For "
            + "category: \"R\"in:\n"
            + "R,Weekly Special,Apple,1,0,flour,sugar,apple,cinnamon,butter,"
            + "baking soda,salt\n"
            + "*** java.lang.NumberFormatException: For input string: \"two\" "
            + "in:\n"
            + "K,2-Layer,Chocolate,1,two,flour,sugar,cocoa powder,eggs,butter,"
            + "baking soda,baking powder,salt\n"
            + "*** java.util.NoSuchElementException in:\n"
            + "W,3-Layer/3-Tier,Buttermilk,1,3\n";
      Assert.assertEquals(result, b.generateExcludedRecordsReport());
   }
}