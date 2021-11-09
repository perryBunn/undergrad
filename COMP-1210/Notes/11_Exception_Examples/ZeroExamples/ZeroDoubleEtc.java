/**
 *  ZeroDouble.java        
 *  Demonstrates double division, BigInteger, and finally block.
 */
import java.math.*;
public class ZeroDoubleEtc
{
   /**
    *   Divides by zero to produce an ArithmeticException.
    */
   public static void main (String[] args)
   {
      double numerator = 10.0;
      double denominator = 0.0;
      try
      {
         double x = numerator / denominator;
         System.out.println (numerator / denominator);
      
         double y1 = x / 10;
         double y2 = x / x;
         double y2b = x * x;
         double y3 = 10.0 / x;
         double y4 = 1000 / x;
         double y5 = 10 * x;
         double y6 = 10 / -0.0;
         
         int i1 = Integer.MAX_VALUE;
         int i2 = (int) x; 
         int i3 = (int) x / (int) x;
         int i4 = (int) x + (int) x;
         int i5 = (int) x * (int) x;
         int i6 = Integer.MAX_VALUE + Integer.MAX_VALUE;
         int i7 = 1 + Integer.MAX_VALUE;
         int i8 = 2147483647 - 10 + 1000;
         
         BigInteger j1 = new BigInteger("2147483647");
         System.out.println(j1);
         BigInteger j2 = j1.multiply(j1);
         System.out.println(j2);
         BigInteger j3 = j2.multiply(j2);
         System.out.println(j3);
         BigInteger j4 = j3.multiply(j3);
         System.out.println(j4);
      }
      
      catch(ArithmeticException problem)
      {
         System.out.println ("This text will be printed "
                              + "if an ArithmeticException occurs.");
         System.out.println (problem.getMessage());
      }
      finally
      {
         System.out.println ("This text will be printed from finally.");
      }
      
      System.out.println ("This text will be printed too.");
   }
}
