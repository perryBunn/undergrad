import java.util.Scanner;
/**
*
*
* @author Perry Bunn
* @version 1/23/17
*/
public class FormulaCalculator {
   /**
   *
   *
   *@param args not used.
   *
   */
   public static void main(String[] args) {
   
      Scanner userInput = new Scanner(System.in);
      double x;
      double y;
      double z;
      double result;
      
      System.out.println("result = (2x - 7.4) (4y + 9.3) (6z -11.2) / xyz");
      System.out.print("\tEnter x: ");
      x = userInput.nextDouble();
      System.out.print("\tEnter y: ");
      y = userInput.nextDouble();
      System.out.print("\tEnter z: ");
      z = userInput.nextDouble();
      if (x == 0 || y == 0 || z == 0) {
         result = 0.0;
      } 
      else {
         result = (((2 * x - 7.4) * (4 * y + 9.3) * (6 * z - 11.2)) 
            / (x * y * z));
      }
      System.out.println(result);
   }
}