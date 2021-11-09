/**
 * @author Perry Bunn
 * @version 4/19/2017
 */

public class Division {
   /**
    *
    * @param numerator number to be divided
    * @param denominator number to be divided
    * @return returns the int value of the divide numbers
    */
   public static int intDivide(int numerator, int denominator) {
      try {
         return numerator / denominator;
      } catch (ArithmeticException e) {
         return 0;
      }
   }

   /**
    *
    * @param numerator number to be divided
    * @param denominator number to be divided
    * @return returns teh float value of the divided numbers
    */
   public static float decimalDivide(int numerator, int denominator) {
      if (denominator == 0) {
         throw new IllegalArgumentException("The demoninator "
         + "cannot be zero");
      }
      return (float) numerator / denominator;
   }
}
