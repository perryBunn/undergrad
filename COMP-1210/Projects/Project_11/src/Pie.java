/**
 *
 */
public class Pie extends BakedItem {

   private double crustCost;
   /**
    *
    */
   public static final double BASE_RATE = 12.0;
   /**
    * @param nameIn creates the name of the object
    * @param flavorIn creates the flavor of the object
    * @param quantityIn creates the qunatity of the object
    * @param ingredientsIn creates the ingredients of the object
    * @param crustCostIn creates the crust cost for the object
    */
   public Pie(String nameIn, String flavorIn, int quantityIn, 
               double crustCostIn, String ... ingredientsIn) {
      super(nameIn, flavorIn, quantityIn, ingredientsIn);
      crustCost = crustCostIn;
   }
   /**
    * @return returns the crust cost
    */
   public double getCrustCost() {
      return crustCost;
   }
   /**
    * @param crustCostIn sets the crust cost
    */
   public void setCrustCost(double crustCostIn) {
      this.crustCost = crustCostIn;
   }
   /**
    * @return returns the price of the object
    */
   public double price() {
      return (BASE_RATE + crustCost) * quantity;
   }
}