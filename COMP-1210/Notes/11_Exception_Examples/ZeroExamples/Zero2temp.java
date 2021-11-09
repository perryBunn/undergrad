/**
 *  Zero1.java        
 *  Demonstrates an uncaught exception.
 */
public class Zero2temp 
{
   /**
    *   Divides by zero to produce an ArithmeticException.
    */
   public static void main(String[] args)
   {
      int numerator = 10;
      int denominator = 1;
      try {
         System.out.println(numerator / denominator); // divide by zero
      }
      catch (ArithmeticException e) {
         System.out.println("exception caught and handled: "
                           + e);
      }
      System.out.println("Program completing normally."); // won't get to here
   }
}
