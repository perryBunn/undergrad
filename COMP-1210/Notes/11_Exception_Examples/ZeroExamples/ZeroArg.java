//********************************************************************
//  Zero.java       Author: Lewis and Loftus
//
//  Demonstrates an uncaught exception.
//********************************************************************

public class ZeroArg
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
         System.out.println (args[0]);
         System.out.println ("This text will not be printed.");
      }
      catch (java.lang.ArrayIndexOutOfBoundsException myProblem)
      {
         System.out.println ("However, this text will be printed.");
      }
      System.out.println ("This text will [not] be printed.");
   }
}
