/**
 *  Zero1.java        
 *  Demonstrates an uncaught exception.
 */
public class Zero1 
{
   /**
    *   Divides by zero to produce an ArithmeticException.
    */
   public static void main(String[] args)
   {
      int numerator = 10;
      int denominator = 1;
      System.out.println(numerator / denominator); // divide by zero
      System.out.println("Program completing normally."); // won't get to here
   }
}
