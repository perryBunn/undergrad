/**
 *
 */
public class Cake extends BakedItem {

   protected int layers;
   /**
    *
    */
   public static final double BASE_RATE = 8.0;
   /**
    * @param nameIn creates the name of the object
    * @param flavorIn creates the flavor of the object
    * @param quantityIn creates the qunatity of the object
    * @param ingredientsIn creates the ingredients of the object
    * @param layersIn creates the layers for the object
    */
   public Cake(String nameIn, String flavorIn, int quantityIn, 
                        int layersIn, String ... ingredientsIn) {
      super(nameIn, flavorIn, quantityIn, ingredientsIn);
      layers = layersIn;
   }
   /**
    * @return returns the number of layers
    */
   public int getLayers() {
      return layers;
   }
   /**
    * @param layersIn sets the number of layers for the object
    */
   public void setLayers(int layersIn) {
      this.layers = layersIn;
   }
   /**
    * @return returns the price of the object
    */
   public double price() {
      return (BASE_RATE * layers) * quantity;
   }
}