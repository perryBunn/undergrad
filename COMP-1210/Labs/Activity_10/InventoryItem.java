/**
 *
 */
public class InventoryItem {

   protected String name = "";
   protected double price = 0;
   private static double taxRate = 0;

   /**
    *
    * @param nameIn takes in the name
    * @param priceIn takes in the price
    */
   public InventoryItem(String nameIn, double priceIn) {
      name = nameIn;
      price = priceIn;
   }

   /**
    *
    * @return returns the name
    */
   public String getName() {
      return name;
   }

   /**
    *
    * @return returns the total cost
    */
   public double calculateCost() {
      return price * (1 + taxRate);
   }

   /**
    *
    * @param taxRateIn sets the tax rate
    */
   public static void setTaxRate(double taxRateIn) {
      taxRate = taxRateIn;
   }

   /**
    *
    * @return returns the name and the cost
    */
   public String toString() {
      return name + ": $" + calculateCost();
   }
}