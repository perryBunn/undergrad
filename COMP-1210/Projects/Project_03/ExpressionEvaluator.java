import java.util.Scanner;
import java.text.DecimalFormat;
/**
* 
*
* @author perry bunn
* @version 1/31/17
*/
public class ExpressionEvaluator {
   /**
   *
   *
   * @param args not used.
   */
   public static void main(String[] args) {
      double x;
      double result;
      String numbers;
      int numbersLeft;
      int numbersRight;
      Scanner userInput = new Scanner(System.in);
      
      System.out.print("Enter a value for x: ");
      x = userInput.nextDouble();
      
      result = (Math.pow(((3 * Math.pow(x, 5)) - (2 * Math.pow(x, 3))), 2)) 
         / (Math.sqrt(Math.abs(16 * Math.pow(x, 7))) + 1);
      System.out.println("Result: " + result);
      
      numbers = Double.toString(result);
      int index = numbers.indexOf('.');
      String numberL = numbers.substring(0, index);
      String numberR = numbers.substring(index + 1, numbers.length());
      numbersLeft = numberL.length();
      numbersRight = numberR.length();
      
      DecimalFormat fmt1 = new DecimalFormat("##,##0.0####");
      
      System.out.println("# digits to the left of the decimal point: " 
         + numbersLeft);
      System.out.println("# digits to the right of the decimal point: " 
         + numbersRight);
      System.out.println("Formatted Result: " + fmt1.format(result));
   }
}