/**
 *
 */
public class WeddingCake extends Cake {

   private int tiers;
   /**
    * 
    */
   public static final double BASE_RATE = 15.0;
   /**
    * @param nameIn creates the name of the object
    * @param flavorIn creates the flavor of the object
    * @param quantityIn creates the qunatity of the object
    * @param ingredientsIn creates the ingredients of the object
    * @param layersIn creates the layers for the object
    * @param tiersIn creates the tiers for the obect
    */
   public WeddingCake(String nameIn, String flavorIn, int quantityIn,
                   int layersIn, int tiersIn, String ... ingredientsIn) {
      super(nameIn, flavorIn, quantityIn, layersIn, ingredientsIn);
      tiers = tiersIn;
   }
   /**
    * @return returns the number of tiers
    */
   public int getTiers() {
      return tiers;
   }
   /**
    * @param tiersIn sets the tiers for the object
    */
   public void setTiers(int tiersIn) {
      this.tiers = tiersIn;
   }
   /**
    * @return returns the price of the object
    */
   public double price() {
      return (BASE_RATE * layers * tiers) * quantity;
   }
}