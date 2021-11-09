/**
 *  Zero1.java        
 *  Demonstrates an uncaught exception.
 */
public class Zero1withTryCatch 
{
   /**
    *   Divides by zero to produce an ArithmeticException.
    */
   public static void main(String[] args)
   {
      int numerator = 10;
      int denominator = 0;
      try {
         System.out.println(numerator / denominator); // divide by zero
      }
      catch (ArithmeticException ae) {
         System.out.println("Exception occurred and caught: " + ae);
      }
      
      System.out.println("Program completing normally."); // won't get to here
   }
}
