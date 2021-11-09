/**
 * TimeComplexity.java
 * Illustrates basic approach to characterizing a method's
 * time complexity.
 *
 * @author   Dean Hendrix (dh@auburn.edu)
 * @version  2016-08-31
 *
 */
public class TimeComplexity {

   // number of timing runs to make
   private static final int NUM_RUNS = 10;

   // 1.0E9 ns per second
   private static final double SECONDS = 1_000_000_000d;

   /** Drives execution. */
   public static void main(String[] args) {
      long start;
      long elapsedTime;
      double avgTime = 0d;
      int n = 8;
      System.out.printf("%4s%8s\n", "N", "Time");
      for (int i = 0; i < NUM_RUNS; i++) {
         start = System.nanoTime();
         methodToTime(n);
         elapsedTime = System.nanoTime() - start;
         System.out.printf("%4d %8.3f\n", n, (elapsedTime / SECONDS));
         n *= 2;
      }
   }


   /** Method to be timed. */
   private static void methodToTime(int n) {
      for (int i = 0; i < n; i++) {
         for (int j = 0; j < n; j++) {
            foo();
         }
      }
      for (int i = 0; i < n; i++) {
         for (int j = 0; j < n; j++) {
            foo();
         }
      }
   }


   /**
    * Something that (hopefull) takes time >= 0.001 seconds
    * so that the program output looks better.
    */
   private static void foo() {
      for (int i = 0; i < 100_000; i++) {
         String s1 = "War";
         String s2 = "Eagle";
         String s3 = s1 + s2;
         s1 = null;
         s2 = null;
         s3 = null;
      }
   }

}