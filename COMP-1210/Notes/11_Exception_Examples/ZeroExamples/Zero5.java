/**
 *  Zero1.java        
 *  Demonstrates an uncaught exception.
 */
public class Zero5
{
   /**
    *   Divides by zero to produce an ArithmeticException.
    */
   public static void main (String[] args)
   {
      int numerator = 10;
      int denominator = 1;
      try
      {
         System.out.println (numerator / denominator);
         return;
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
