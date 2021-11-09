import java.text.DecimalFormat;
/**
* @author Perry Bunn
* @version 2/9/17
*/
public class Dodecahedron {

   //fields
   private String label = "";
   private String color = "";
   private double edge = 0;

   // constuctor   
   /**
   * @param labelIn takes input for label in the constructor.
   * @param colorIn takes input for color in the constructor.
   * @param edgeIn takes input for the edge in the constructor.
   */
   public Dodecahedron(String labelIn, String colorIn, double edgeIn) {
      setLabel(labelIn);
      setColor(colorIn);
      setEdge(edgeIn);
   }

   //methods
   /**
   * @return returns the label variable.
   */
   public String getLabel() {
      return label;
   }
   /**
   * @param labelIn takes the labelIn for the method.
   * @return returns the boolean if the variable was set.
   */
   public boolean setLabel(String labelIn) {
      if (labelIn != null) {
         label = labelIn.trim();
         return true;
      } else {
         return false;
      }
   }
   /**
   * @return returns the variable color.
   */
   public String getColor() {
      return color;
   }
   /**
   * @param colorIn takes the colorIn and sets it as the color variable.
   * @return returns the boolean if the variable was set.
   */
   public boolean setColor(String colorIn) {
      if (colorIn != null) {
         color = colorIn.trim();
         return true;
      } else {
         return false;
      }
   }
   /**
   * @return returns the value for the variable edge.
   */
   public double getEdge() {
      return edge;
   }
   /**
   * @param edgeIn takes the edgein and sets it as the edge variable.
   * @return returns the boolean if the variable was set.
   */
   public boolean setEdge(double edgeIn) {
      if (edgeIn > 0) {
         edge = edgeIn;
         return true;
      } else {
         return false;
      }
   }
   /**
   * @return returns the value of the surface area for the dodecahdron.
   */
   public double surfaceArea() {
      return 3 * Math.sqrt(25 + 10 * Math.sqrt(5)) * Math.pow(edge, 2);
   }
   /**
   * @return returns the value of the volume for the dodecahdron.
   */
   public double volume() {
      return ((15 + 7 * Math.sqrt(5)) / (4)) * Math.pow(edge, 3);
   }
   /**
   * @return returns the value of the ratio between the surface ares and volume.
   */
   public double surfaceToVolumeRatio() {
      return surfaceArea() / volume();
   }
   /**
   * @return returns the string to be printed for the main method.
   */
   public String toString() {
      DecimalFormat fmt = new DecimalFormat("#,##0.0##");
      return "Dodecahedron \"" + label + "\" is \"" + color
         + "\" with 30 edges of length " + edge + " units.\n\t"
         + "surface area = " + fmt.format(surfaceArea()) + " square units\n\t"
         + "volume = " + fmt.format(volume()) + " cubic units\n\t"
         + "surface/volume ratio = " + fmt.format(surfaceToVolumeRatio());
   }
}