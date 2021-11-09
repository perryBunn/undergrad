/**
 * Applies the linear scan strategy to counting the number of negative
 * values in an array.
 *
 * @author Dean Hendrix (dh@auburn.edu)
 * @version 2017-08-22
 *
 * @author Perry Bunn (ptb0010@auburn.edu)
 * @version 2018-5-20
 */
public class CountNegatives {

   /**
    * Returns the number of negative values in the given array.
    */
   public static int countNegatives(int[]a) {
      int j = 0;
      for (int i = 0; i < a.length; i++) {
         if (0 > a[i]) {
            j++;
         }
      }
      return j;
   }
}
