import java.util.ArrayList;
/**
@author perry bunn
@version 2/27/17
*/
public class Temperatures {
   private ArrayList<Integer> temperatures;
   /**
   @param temperaturesIn 
   */
   public Temperatures(ArrayList<Integer> temperaturesIn) {
      temperatures = temperaturesIn;
   }
   /**
   @return returns the value of the lowest temp
   */
   public int getLowTemp() {
      if (temperatures.isEmpty()) {
         return 0;
      }
      int low = temperatures.get(0);
      for (int i = 0; i < temperatures.size(); i++) {
         if (temperatures.get(i) < low) {
            low = temperatures.get(i);
         }
      }
      return low;
   }
   /**
   @return returns the highest temp
   */
   public int getHighTemp() {
      if (temperatures.isEmpty()) {
         return 0;
      }
      int high = temperatures.get(0);
      for (Integer temp : temperatures) {
         if (temp > high) {
            high = temp;
         }
      }
      return high;
   }
   /**
   @return returns the lowest temp
   @param lowIn input for a temp
   */
   public int lowerMinimum(int lowIn) {
      return lowIn < getLowTemp() ? lowIn : getLowTemp();
   }
   /**
   @return returns the highest temp
   @param highIn input for a temp
   */
   public int higherMaximum(int highIn) {
      return highIn > getHighTemp() ? highIn : getHighTemp();
   }
   /**
   @return returns the above methods in readable format
   */
   public String toString() {
      return "\tTempaturs: " + temperatures
            + "\n\tLow: " + getLowTemp()
            + "\n\tHigh: " + getHighTemp();
            
            
   }
}