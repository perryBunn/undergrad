import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Defines a library of selection methods on Collections.
 *
 * @author  Perry Bunn (ptb0010@auburn.edu)
 * @author  Dean Hendrix (dh@auburn.edu)
 * @version 2017-09-05
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
    * Returns the minimum value in the Collection coll as defined by the
    * Comparator comp. If either coll or comp is null, this method throws an
    * IllegalArgumentException. If coll is empty, this method throws a
    * NoSuchElementException. This method will not change coll in any way.
    *
    * @param coll    the Collection from which the minimum is selected
    * @param comp    the Comparator that defines the total order on T
    * @return        the minimum value in coll
    * @throws        IllegalArgumentException as per above
    * @throws        NoSuchElementException as per above
    */
   public static <T> T min(Collection<T> coll, Comparator<T> comp) {
      if (coll == null || comp == null) {
         throw new IllegalArgumentException();
      }
      if (coll.isEmpty()) {
         throw new NoSuchElementException();
      }
      T minItem = coll.iterator().next();
      for (T i : coll) {
         if (comp.compare(minItem, i) > 0) {
            minItem = i;
         }
      }
      return minItem;
   }


   /**
    * Selects the maximum value in the Collection coll as defined by the
    * Comparator comp. If either coll or comp is null, this method throws an
    * IllegalArgumentException. If coll is empty, this method throws a
    * NoSuchElementException. This method will not change coll in any way.
    *
    * @param coll    the Collection from which the maximum is selected
    * @param comp    the Comparator that defines the total order on T
    * @return        the maximum value in coll
    * @throws        IllegalArgumentException as per above
    * @throws        NoSuchElementException as per above
    */
   public static <T> T max(Collection<T> coll, Comparator<T> comp) {
      if (coll == null || comp == null) {
         throw new IllegalArgumentException();
      }
      if (coll.isEmpty()) {
         throw new NoSuchElementException();
      }
      T maxItem = coll.iterator().next();
      for (T i : coll) {
         if (comp.compare(maxItem, i) < 0) {
            maxItem = i;
         }
      }
      return maxItem;
   }


   /**
    * Selects the kth minimum value from the Collection coll as defined by the
    * Comparator comp. If either coll or comp is null, this method throws an
    * IllegalArgumentException. If coll is empty or if there is no kth minimum
    * value, this method throws a NoSuchElementException. This method will not
    * change coll in any way.
    *
    * @param coll    the Collection from which the kth minimum is selected
    * @param k       the k-selection value
    * @param comp    the Comparator that defines the total order on T
    * @return        the kth minimum value in coll
    * @throws        IllegalArgumentException as per above
    * @throws        NoSuchElementException as per above
    */
   public static <T> T kmin(Collection<T> coll, int k, Comparator<T> comp) {
      if (coll == null || comp == null) {
         throw new IllegalArgumentException();
      }
      if (coll.isEmpty() || k == 0 || k > coll.size()) {
         throw new NoSuchElementException();
      }
      List<T> items = new ArrayList<>(coll);
      java.util.Collections.<T>sort(items, comp);
      int increment = 1;
      T kMin = items.get(0);
      for (T i : items) {
         if (comp.compare(kMin, i) != 0) {
            increment++;
            kMin = i;
         }
      }
      if (increment < k) {
         throw new NoSuchElementException();
      }
      increment = 1;
      kMin = items.get(0);
      if (items.size() != 1 && comp.compare(items.get(0), items.get(items.size() - 1))
               < 0) {
         for (T i : items) {
            if (increment == k) {
               return kMin;
            }
            if (comp.compare(kMin, i) != 0) {
               increment++;
               kMin = i;
            }
         }
      }
      if (items.size() != 1) {
         for (int i = items.size() - 1; i > -1; i--) {
            if (increment == k) {
               return kMin;
            }

            if (comp.compare(kMin, items.get(i)) != 0) {
               increment++;
               kMin = items.get(i);
            }
         }
      }
      return kMin;
   }


   /**
    * Selects the kth maximum value from the Collection coll as defined by the
    * Comparator comp. If either coll or comp is null, this method throws an
    * IllegalArgumentException. If coll is empty or if there is no kth maximum
    * value, this method throws a NoSuchElementException. This method will not
    * change coll in any way.
    *
    * @param coll    the Collection from which the kth maximum is selected
    * @param k       the k-selection value
    * @param comp    the Comparator that defines the total order on T
    * @return        the kth maximum value in coll
    * @throws        IllegalArgumentException as per above
    * @throws        NoSuchElementException as per above
    */
   public static <T> T kmax(Collection<T> coll, int k, Comparator<T> comp) {
      if (coll == null || comp == null) {
         throw new IllegalArgumentException();
      }
      if (coll.isEmpty() || k == 0 || k > coll.size()) {
         throw new NoSuchElementException();
      }
      List<T> items = new ArrayList<>(coll);
      java.util.Collections.<T>sort(items, comp);
      int increment = 1;
      T kMax = items.get(0);
      for (T i : items) {
         if (comp.compare(kMax, i) != 0) {
            increment++;
            kMax = i;
         }
      }
      if (increment < k) {
         throw new NoSuchElementException();
      }
      increment = 1;
      kMax = items.get(items.size() - 1);
      if (items.size() != 1 && comp.compare(items.get(0), items.get(items.size() - 1))
               < 0) {
         for (int i = items.size() - 1; i > -1; i--) {
            if (increment == k) {
               return kMax;
            }

            if (comp.compare(kMax, items.get(i)) != 0) {
               increment++;
               kMax = items.get(i);
            }
         }
      }
      if (items.size() != 1) {
         for (T i : items) {
            if (increment == k) {
               return kMax;
            }
            if (comp.compare(kMax, i) != 0) {
               increment++;
               kMax = i;
            }
         }
      }
      return kMax;
   }


   /**
    * Returns a new Collection containing all the values in the Collection coll
    * that are greater than or equal to low and less than or equal to high, as
    * defined by the Comparator comp. The returned collection must contain only
    * these values and no others. The values low and high themselves do not have
    * to be in coll. Any duplicate values that are in coll must also be in the
    * returned Collection. If no values in coll fall into the specified range or
    * if coll is empty, this method throws a NoSuchElementException. If either
    * coll or comp is null, this method throws an IllegalArgumentException. This
    * method will not change coll in any way.
    *
    * @param coll    the Collection from which the range values are selected
    * @param low     the lower bound of the range
    * @param high    the upper bound of the range
    * @param comp    the Comparator that defines the total order on T
    * @return        a Collection of values between low and high
    * @throws        IllegalArgumentException as per above
    * @throws        NoSuchElementException as per above
    */
   public static <T> Collection<T> range(Collection<T> coll, T low, T high,
                                         Comparator<T> comp) {
      if (coll == null || comp == null) {
         throw new IllegalArgumentException();
      }
      if (coll.isEmpty()) {
         throw new NoSuchElementException();
      }
      List<T> inRange = new ArrayList<>();
      List<T> items = new ArrayList<>(coll);
      for (T i : items) {
         if (comp.compare(i, low) >= 0 && comp.compare(i, high) <= 0) {
            inRange.add(i);
         }
      }
      if (!inRange.isEmpty()) {
         return inRange;
      }
      throw new NoSuchElementException();
   }


   /**
    * Returns the smallest value in the Collection coll that is greater than
    * or equal to key, as defined by the Comparator comp. The value of key
    * does not have to be in coll. If coll or comp is null, this method throws
    * an IllegalArgumentException. If coll is empty or if there is no
    * qualifying value, this method throws a NoSuchElementException. This
    * method will not change coll in any way.
    *
    * @param coll    the Collection from which the ceiling value is selected
    * @param key     the reference value
    * @param comp    the Comparator that defines the total order on T
    * @return        the ceiling value of key in coll
    * @throws        IllegalArgumentException as per above
    * @throws        NoSuchElementException as per above
    */
   public static <T> T ceiling(Collection<T> coll, T key, Comparator<T> comp) {
      if (coll == null || comp == null) {
         throw new IllegalArgumentException();
      }
      if (coll.isEmpty()) {
         throw new NoSuchElementException();
      }
      T ceiling = max(coll, comp);
      boolean set = false;
      for (T i : coll) {
         if (comp.compare(i, key) >= 0 && comp.compare(i, ceiling) <= 0) {
            ceiling = i;
            set = true;
         }
      }
      if (set) {
         return ceiling;
      }
      throw new NoSuchElementException();
   }


   /**
    * Returns the largest value in the Collection coll that is less than
    * or equal to key, as defined by the Comparator comp. The value of key
    * does not have to be in coll. If coll or comp is null, this method throws
    * an IllegalArgumentException. If coll is empty or if there is no
    * qualifying value, this method throws a NoSuchElementException. This
    * method will not change coll in any way.
    *
    * @param coll    the Collection from which the floor value is selected
    * @param key     the reference value
    * @param comp    the Comparator that defines the total order on T
    * @return        the floor value of key in coll
    * @throws        IllegalArgumentException as per above
    * @throws        NoSuchElementException as per above
    */
   public static <T> T floor(Collection<T> coll, T key, Comparator<T> comp) {
      if (coll == null || comp == null) {
         throw new IllegalArgumentException();
      }
      if (coll.isEmpty()) {
         throw new NoSuchElementException();
      }
      T floor = min(coll, comp);
      boolean set = false;
      for (T i : coll) {
         if (comp.compare(i, key) <= 0 && comp.compare(i, floor) >= 0) {
            floor = i;
            set = true;
         }
      }
      if (set) {
         return floor;
      }
      throw new NoSuchElementException();
   }

}
