import java.util.Arrays;

/**
* Defines a library of selection methods
* on arrays of ints.
*
* @author   Perry Bunn (PTB0010@auburn.edu)
* @author   Dean Hendrix (dh@auburn.edu)
* @version  2017-08-22
*
*/
public final class Selector {

   /**
    * Can't instantiate this class.
    *
    * D O   N O T   C H A N G E   T H I S   C O N S T R U C T O R
    *
    */
   private Selector() { }


   /**
    * Selects the minimum value from the array a. This method
    * throws IllegalArgumentException if a is null or has zero
    * length. The array a is not changed by this method.
    */
   public static int min(int[] a) {
      if (a == null || a.length == 0) {
         throw new IllegalArgumentException("Threw an IllegalArgumentException");
      }
      int minValue = a[0];
      for (int value : a) {
         if (value < minValue) {
            minValue = value;
         }
      }
      return minValue;
   }


   /**
    * Selects the maximum value from the array a. This method
    * throws IllegalArgumentException if a is null or has zero
    * length. The array a is not changed by this method.
    */
   public static int max(int[] a) {
      if (a == null || a.length == 0) {
         throw new IllegalArgumentException("Threw an IllegalArgumentException");
      }
      int maxValue = a[0];
      for (int value : a) {
         if (value > maxValue) {
            maxValue = value;
         }
      }
      return maxValue;
   }


   /**
    * Selects the kth minimum value from the array a. This method
    * throws IllegalArgumentException if a is null, has zero length,
    * or if there is no kth minimum value. Note that there is no kth
    * minimum value if k < 1, k > a.length, or if k is larger than
    * the number of distinct values in the array. The array a is not
    * changed by this method.
    */
   public static int kmin(int[] a, int k) {
      if (a == null || a.length == 0) {
         throw new IllegalArgumentException("Threw an IllegalArgumentException");
      }
      if (k < 1 || k > a.length) {
         throw new IllegalArgumentException("There was no nth max value");
      }
      int[] clone = new int[a.length];
      System.arraycopy(a,0, clone,0, a.length);
      Arrays.sort(clone);
      int j = 0;
      int i = 1;
      while (i < a.length) {
         if (clone[i] == clone[j]) {
            i++;
         } else {
            clone[++j] = clone[i++];
         }
      }
      int[] output = new int[j + 1];
      for (int l = 0; l < output.length; l++) {
         output[l] = clone[l];
      }

      return output[k - 1];
   }


   /**
    * Selects the kth maximum value from the array a. This method
    * throws IllegalArgumentException if a is null, has zero length,
    * or if there is no kth maximum value. Note that there is no kth
    * maximum value if k < 1, k > a.length, or if k is larger than
    * the number of distinct values in the array. The array a is not
    * changed by this method.
    */
   public static int kmax(int[] a, int k) {
      if (a == null || a.length == 0) {
         throw new IllegalArgumentException("Threw an IllegalArgumentException");
      }
      if (k < 1 || k > a.length) {
         throw new IllegalArgumentException("There was no nth max value");
      }
      int[] clone = new int[a.length];
      System.arraycopy(a,0, clone,0, a.length);
      Arrays.sort(clone);
      int j = 0;
      int i = 1;
      while (i < a.length) {
         if (clone[i] == clone[j]) {
            i++;
         } else {
            clone[++j] = clone[i++];
         }
      }
      int[] output = new int[j + 1];
      for (int l = 0; l < output.length; l++) {
         output[l] = clone[l];
      }

      return output[output.length - k];
   }


   /**
    * Returns an array containing all the values in a in the
    * range [low..high]; that is, all the values that are greater
    * than or equal to low and less than or equal to high,
    * including duplicate values. The length of the returned array
    * is the same as the number of values in the range [low..high].
    * If there are no qualifying values, this method returns a
    * zero-length array. Note that low and high do not have
    * to be actual values in a. This method throws an
    * IllegalArgumentException if a is null or has zero length.
    * The array a is not changed by this method.
    */
   public static int[] range(int[] a, int low, int high) {
      if (a == null || a.length == 0) {
         throw new IllegalArgumentException("Threw an IllegalArgumentException");
      }
      int[] rangeArr = new int[a.length];
      int i = 0;
      for (int value : a) {
         if (value >= low && value <= high) {
            rangeArr[i] = value;
            i++;
         }
      }
      int[] finalArr = new int[i];
      System.arraycopy(rangeArr, 0, finalArr, 0 , i);
      return finalArr;
   }


   /**
    * Returns the smallest value in a that is greater than or equal to
    * the given key. This method throws an IllegalArgumentException if
    * a is null or has zero length, or if there is no qualifying
    * value. Note that key does not have to be an actual value in a.
    * The array a is not changed by this method.
    */
   public static int ceiling(int[] a, int key) {
      if (a == null || a.length == 0) {
         throw new IllegalArgumentException("Threw an IllegalArgumentException");
      }
      int minValue = 2147483647;
      for (int val:a) {
         if (val >= key) {
            if (val < minValue) {
               minValue = val;
            }
         }
      }
      if (minValue == 0) {
         throw new IllegalArgumentException("Threw an IllegalArgumentException");
      }
      return minValue;
   }


   /**
    * Returns the largest value in a that is less than or equal to
    * the given key. This method throws an IllegalArgumentException if
    * a is null or has zero length, or if there is no qualifying
    * value. Note that key does not have to be an actual value in a.
    * The array a is not changed by this method.
    */
   public static int floor(int[] a, int key) {
      if (a == null || a.length == 0) {
         throw new IllegalArgumentException("Threw an IllegalArgumentException");
      }
      int maxValue = -10;
      for (int value : a) {
         if (value <= key) {
            if (value > maxValue) {
               maxValue = value;
            }
         }
      }
      return maxValue;
   }

}
