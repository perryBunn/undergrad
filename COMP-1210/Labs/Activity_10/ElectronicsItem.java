/**
 *
 */
public class ElectronicsItem extends InventoryItem {
   
   protected double weight = 0;
   /**
    *
    */
   public static final double SHIPPING_COST = 1.5;

   /**
    *
    * @param nameIn takes in the name
    * @param priceIn takes in the price
    * @param weightIn takes in the weight
    */
   public ElectronicsItem(String nameIn, double priceIn, double weightIn) {
      super(nameIn, priceIn);
      weight = weightIn;
   }

   /**
    *
    * @return returns the total cost
    */
   public double calculateCost() {
      return super.calculateCost() + (SHIPPING_COST * weight);
   }
}