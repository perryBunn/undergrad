/**
 *  Zero1.java        
 *  Demonstrates an uncaught exception.
 */
public class Zero7
{
   /**
    *   Divides by zero to produce an ArithmeticException.
    */
   public static void main (String[] args)
   {
      int numerator = 10;
      int denominator = 0;
      try
      {
         System.out.println (numerator / denominator);
      }
      catch (java.lang.ArithmeticException myProblem)
      {
         System.out.println ("However, this text will be printed.");
      }
      try
      {
         System.out.println (numerator);
      }
      catch (java.lang.ArithmeticException myProblem)
      {
         System.out.println ("However, this text will [not] be printed.");
      }
   
      System.out.println ("This text will [not] be printed.");
   }
}
