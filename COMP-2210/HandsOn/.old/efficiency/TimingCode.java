/**
 * TimingCode.java
 * Illustrates basic approach to measuring a method's
 * running time.
 *
 * @author   Dean Hendrix (dh@auburn.edu)
 * @version  2016-08-31
 *
 */
public class TimingCode {

   // number of timing runs to make
   private static final int NUM_RUNS = 10;

   // 1.0E9 ns per second
   private static final double SECONDS = 1_000_000_000d;

   /** Drives execution. */
   public static void main(String[] args) {
      long start;
      long elapsedTime;
      double avgTime = 0d;
      for (int i = 0; i < NUM_RUNS; i++) {
         start = System.nanoTime();
         foo();
         elapsedTime = System.nanoTime() - start;
         avgTime += elapsedTime;
      }
      avgTime = avgTime / NUM_RUNS;
      // convert to seconds
      avgTime = avgTime / SECONDS;
      System.out.printf("%s%4.3f%s\n", "Method foo's running time: ", avgTime, " seconds");
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