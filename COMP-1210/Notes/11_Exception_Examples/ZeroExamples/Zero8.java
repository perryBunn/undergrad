/**
 *  Zero1.java        
 *  Demonstrates an uncaught exception.
 */
public class Zero8   {
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
         System.exit(0); // User aborting program
      }
      catch(ArithmeticException problem)
      {
         System.out.println ("This text will be printed.");
      }
      finally
      {
         System.out.println ("This text will be printed from finally.");
      }
      
      System.out.println ("This text will be printed too.");
   }
}
