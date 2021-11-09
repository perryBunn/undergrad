/**
 *  Zero1.java        
 *  Demonstrates an uncaught exception.
 */
public class Zero1New
{
   /**
    *   Divides by zero to produce an ArithmeticException.
    */
   public static void main(String[] args)
   {
      try {
         int numerator = 10;
         int denominator = 0;
         System.out.println(numerator / denominator); // divide by zero
      }
      catch(ArithmeticException e) {
         System.out.println("Exception caught and handled:\n " + e);
      }
      System.out.println("Program completing normally."); // won't get to here
   }
}
