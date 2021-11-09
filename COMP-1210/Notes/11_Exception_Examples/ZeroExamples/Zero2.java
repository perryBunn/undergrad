/**
 *  Zero2.java        
 *  Demonstrates catching an exception in try-catch block.
 */

public class Zero2
{
   /**
    *   Divides by zero to produce an ArithmeticException.
    */
   public static void main(String[] args)
   {
      int numerator = 10;
      int denominator = 0;
      try  {
         System.out.println(numerator / denominator); // divide by zero
      } 
      catch (ArithmeticException myProblem) {
         System.out.println ("An exception occured, " + 
               				"and was handled: " + myProblem);
      }
      
      System.out.println("Program competing normally."); 
   }
}
