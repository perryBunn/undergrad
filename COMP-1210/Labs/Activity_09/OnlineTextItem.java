/**
 *
 */
public abstract class OnlineTextItem extends InventoryItem {
   /**
    *
    * @param nameIn takes in the name
    * @param priceIn takes in the price
    */
   public OnlineTextItem(String nameIn, double priceIn) {
      super(nameIn, priceIn);
   }

   /**
    * 
    * @return returns the total cost
    */
   public double calculateCost() {
      return price;
   }
}