import java.io.File;
import java.io.IOException;
import java.util.Scanner;

   /**
 *  Zero1.java        
 *  Demonstrates an uncaught exception.
 */

public class Zero3RA 
{
   /**
    *   Divides by zero to produce an ArithmeticException.
    */
   public static void main (String[] args) throws IOException
   {
      int numerator = 10;
      int denominator = 0;
      try (Scanner input = new Scanner(new File("output")))
      {
         System.out.println (numerator / denominator);
      }
      catch (Exception myProblem)
      {
         System.out.println (myProblem.getMessage());
         myProblem.printStackTrace();
         System.out.println ("However, this text will be printed.");
      }
      finally
      {
         System.out.println ("Since in 'finally', this is always printed!");
      }
      System.out.println ("This text will [not] be printed.");
   }
}
