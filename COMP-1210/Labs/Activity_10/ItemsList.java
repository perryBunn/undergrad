/**
 *
 */
public class ItemsList {
   private InventoryItem[] inventory;
   private int count;
   /**
    *
    */
   public ItemsList() {
      inventory = new InventoryItem[20];
      count = 0;
   }
   /**
    * @param itemIn takes in an object to add to the list
    */
   public void addItem(InventoryItem itemIn) {
      inventory[count] = itemIn;
      count++;
   }
   /**
    * @return returns the cost after it has been calculated
    * @param electronicsSurcharge takes ina double to multiple
    */
   public double calculateTotal(double electronicsSurcharge) {
      double total = 0;
      
      for (int i = 0; i < count; i++) {
         if (inventory[i] instanceof ElectronicsItem) {
            total += inventory[i].calculateCost() + electronicsSurcharge;
         } else {
            total += inventory[i].calculateCost();
         }
      }
      
      return total;
   }
   /**
    * @return returns the toString of the inventory
    */
   public String toString() {
      String result = "All inventory:\n\n";
      
      for (int i = 0; i < count; i++) {
         result += inventory[i] + "\n";
      }
      
      return result;
   }
}