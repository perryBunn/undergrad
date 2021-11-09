import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * ArraySet.java.
 *
 * Provides an implementation of the Set interface using an
 * array as the underlying data structure. Values in the array
 * are kept in ascending natural order and, where possible,
 * methods take advantage of this. Many of the methods with parameters
 * of type ArraySet are specifically designed to take advantage
 * of the ordered array implementation.
 *
 * @author Perry Bunn (ptb0010@auburn.edu)
 * @author	Dean Hendrix (dh@auburn.edu)
 * @version 2017-10-02
 *
 */
public class ArraySet<T extends Comparable<? super T>> implements Set<T> {

   ////////////////////////////////////////////
   // DO NOT CHANGE THE FOLLOWING TWO FIELDS //
   ////////////////////////////////////////////
   T[] elements;
   int size;

   ////////////////////////////////////
   // DO NOT CHANGE THIS CONSTRUCTOR //
   ////////////////////////////////////
   /**
    * Instantiates an empty set.
    */
   @SuppressWarnings("unchecked")
   public ArraySet() {
      elements = (T[]) new Comparable[1];
      size = 0;
   }

   ///////////////////////////////////
   // DO NOT CHANGE THE SIZE METHOD //
   ///////////////////////////////////
   /**
    * Returns the current size of this collection.
    *
    * @return  the number of elements in this collection.
    */
   @Override
   public int size() {
      return size;
   }

   //////////////////////////////////////
   // DO NOT CHANGE THE ISEMPTY METHOD //
   //////////////////////////////////////
   /**
    * Tests to see if this collection is empty.
    *
    * @return  true if this collection contains no elements,
    *               false otherwise.
    */
   @Override
   public boolean isEmpty() {
      return size == 0;
   }

   ///////////////////////////////////////
   // DO NOT CHANGE THE TOSTRING METHOD //
   ///////////////////////////////////////
   /**
    * Return a string representation of this ArraySet.
    *
    * @return a string representation of this ArraySet
    */
   @Override
   public String toString() {
      if (isEmpty()) {
         return "[]";
      }
      StringBuilder result = new StringBuilder();
      result.append("[");
      for (T element : this) {
         result.append(element + ", ");
      }
      result.delete(result.length() - 2, result.length());
      result.append("]");
      return result.toString();
   }

   private boolean isFull() {
      return size == elements.length;
   }
   /**
    * Ensures the collection contains the specified element. Elements are
    * maintained in ascending natural order at all times. Neither duplicate nor
    * null values are allowed.
    *
    * @param  element  The element whose presence is to be ensured.
    * @return true if collection is changed, false otherwise.
    */

   @Override
   public boolean add(T element) {
      if (element == null) {
         return false;
      }
      if (locate(element) < 0) {
         if (isFull()) {
            resize(elements.length * 2);
         }
         if (isEmpty()) {
            elements[size] = element;
            size++;
            return true;
         }
         int elementLocation = size;
         for (int i = 0; i < size; i++) {
            if (elements[i].compareTo(element) > 0) {
               elementLocation = i;
               break;
            }
         }
         if (elementLocation == size) {
            elements[elementLocation] = element;
            size++;
            return true;
         }
         for (int i = size - 1; i >= elementLocation; i--) {
            elements[i + 1] = elements[i];
         }
         elements[elementLocation] = element;
         size++;
         return true;
      }
      return false;
   }

   private void resize(int capacity) {
      elements = Arrays.<T>copyOf(elements, capacity);
   }

   /**
    * Ensures the collection does not contain the specified element.
    * If the specified element is present, this method removes it
    * from the collection. Elements are maintained in ascending natural
    * order at all times.
    *
    * @param   element  The element to be removed.
    * @return  true if collection is changed, false otherwise.
    */
   @Override
   public boolean remove(T element) {
      if (isEmpty()) {
         return false;
      }
      int i = locate(element);
      if (i < 0) {
         return false;
      }
      for (; i < size; i++) {
         elements[i] = elements[i + 1];
      }
      elements[size - 1] = null;
      size--;
      if ((size > 0) && (size < elements.length / 4)) {
         resize(elements.length / 2);
      }
      return true;
   }
   
   /**
    * Searches for specified element in this collection.
    *
    * @param   element  The element whose presence in this collection
    *                   is to be tested.
    * @return  true if this collection contains the specified element,
    *               false otherwise.
    */
   @Override
   public boolean contains(T element) {
      return locate(element, 0, size - 1) >= 0;
   }

   private int locate(T target) {
      for (int i = 0; i < size; i++) {
         if (elements[i].equals(target)) {
            return i;
         }
      }
      return -1;
   }

   private int locate(T target, int left, int right) {
      // int left = 0;
      // int right = length - 1;
      if (left <= right) {
         int middle = (left + right) / 2;
         if (target.compareTo(elements[middle]) < 0) {
            return locate(target, left, middle - 1);
         }
         if (target.compareTo(elements[middle]) > 0) {
            return locate(target, middle + 1, right);
         }
         return middle;
      }
      return -1;
   }

   /**
    * Tests for equality between this set and the parameter set.
    * Returns true if this set contains exactly the same elements
    * as the parameter set, regardless of order.
    *
    * @return  true if this set contains exactly the same elements
    *               as the parameter set, false otherwise
    */
   @Override
   public boolean equals(Set<T> s) {
      if (size == s.size()) {
         Iterator<T> itr = s.iterator();
         while (itr.hasNext()) {
            if (!contains(itr.next())) {
               return false;
            }
         }
         return true;
      }
      return false;
   }

   /**
    * Tests for equality between this set and the parameter set.
    * Returns true if this set contains exactly the same elements
    * as the parameter set, regardless of order.
    *
    * @return  true if this set contains exactly the same elements
    *               as the parameter set, false otherwise
    */
   public boolean equals(ArraySet<T> s) {
      if (size == s.size()) {
         for (T i : s) {
            if (!contains(i)) {
               return false;
            }
         }
         return true;
      }
      return false;
   }

   /**
    * Returns a set that is the union of this set and the parameter set.
    *
    * @return  a set that contains all the elements of this set and
    *            the parameter set
    */
   @Override
   public Set<T> union(Set<T> s) {
      ArraySet temp = new ArraySet();
      Iterator<T> itr = s.iterator();
      for (int i = 0; i < size; i++) {
         temp.add(elements[i]);
      }
      while (itr.hasNext()) {
         T j = itr.next();
         temp.add(j);
      }
      return temp;
   }

   /**
    * Returns a set that is the union of this set and the parameter set.
    *
    * @return  a set that contains all the elements of this set and
    *            the parameter set
    */
   public Set<T> union(ArraySet<T> s) {
      ArraySet temp = new ArraySet();
      for (int i = 0; i < size; i++) {
         temp.add(elements[i]);
      }
      for (T j : s) {
         temp.add(j);
      }
      return temp;
   }

   /**
    * Returns a set that is the intersection of this set
    * and the parameter set.
    *
    * @return  a set that contains elements that are in both
    *            this set and the parameter set
    */
   @Override
   public Set<T> intersection(Set<T> s) {
      ArraySet temp = new ArraySet();
      for (T i : elements) {
         for (T j : s) {
            if (j == i) {
               temp.add(i);
            }
         }
      }
      return temp;
   }

   /**
    * Returns a set that is the intersection of this set and
    * the parameter set.
    *
    * @return  a set that contains elements that are in both
    *            this set and the parameter set
    */
   public Set<T> intersection(ArraySet<T> s) {
      ArraySet temp = new ArraySet();
      for (T i : elements) {
         for (T j : s) {
            if (j == i) {
               temp.add(i);
            }
         }
      }
      return temp;
   }


   /**
    * Returns a set that is the complement of this set and
    * the parameter set.
    *
    * @return  a set that contains elements that are in this
    *            set but not the parameter set
    */
   @Override
   public Set<T> complement(Set<T> s) {
      ArraySet temp = new ArraySet();
      Iterator<T> itr = iterator();
      Iterator<T> sItr = s.iterator();
      int k = 0;
      while (itr.hasNext() && k < s.size()) {
         T i = itr.next();
         T j = sItr.next();
         if (!s.contains(i)) {
            temp.add(i);
         }
         k++;
      }
      for (; k < size; k++) {
         temp.add(elements[k]);
      }
      return temp;
   }

   /**
    * Returns a set that is the complement of this set and
    * the parameter set.
    *
    * @return  a set that contains elements that are in this
    *            set but not the parameter set
    */
   public Set<T> complement(ArraySet<T> s) {
      ArraySet temp = new ArraySet();
      Iterator<T> itr = iterator();
      Iterator<T> sItr = s.iterator();
      int k = 0;
      while (itr.hasNext() && k < s.size()) {
         T i = itr.next();
         T j = sItr.next();
         if (!s.contains(i)) {
            temp.add(i);
         }
         k++;
      }
      for (; k < size; k++) {
         temp.add(elements[k]);
      }
      return temp;
   }


   /**
    * Returns an iterator over the elements in this ArraySet.
    * No specific order can be assumed.
    *
    * @return  an iterator over the elements in this ArraySet
    */
   @Override
   public Iterator<T> iterator() {

      // ALMOST ALL THE TESTS DEPEND ON THIS METHOD WORKING CORRECTLY.
      // MAKE SURE YOU GET THIS ONE WORKING FIRST.
      // HINT: JUST USE THE SAME CODE/STRATEGY AS THE ARRAYBAG CLASS
      // FROM LECTURE. THE ONLY DIFFERENCE IS THAT YOU'LL NEED THE
      // ARRAYITERATOR CLASS TO BE NESTED, NOT TOP-LEVEL.

      return new newIterator(elements, size);
   }

   private class newIterator implements Iterator<T> {

      private T[] items;
      private int count;
      private int current;

      public newIterator(T[] elements, int size) {
         items = elements;
         count = size;
         current = 0;
      }

      @Override
      public boolean hasNext() {
         return !isEmpty() && (current < count);
      }

      @Override
      public T next() {
         if (!hasNext()) {
            throw new NoSuchElementException();
         }
         return items[current++];
      }
   }

   private class descendingIterator implements Iterator<T> {

      private T[] items;
      private int current;

      public descendingIterator(T[] elements, int size) {
         items = elements;
         current = size - 1;
      }

      @Override
      public boolean hasNext() {
         return (current >= 0);
      }

      @Override
      public T next() {
         if (!hasNext()) {
            throw new NoSuchElementException();
         }
         return items[current--];
      }
   }

   /**
    * Returns an iterator over the elements in this ArraySet.
    * The elements are returned in descending order.
    *
    * @return  an iterator over the elements in this ArraySet
    */
   public Iterator<T> descendingIterator() {
      return new descendingIterator(elements, size);
   }

   /**
    * Returns an iterator over the members of the power set
    * of this ArraySet. No specific order can be assumed.
    *
    * @return  an iterator over members of the power set
    */
   public Iterator<Set<T>> powerSetIterator() {
      return new powerIterator(elements, size);
   }

   private class powerIterator implements Iterator<Set<T>> {

      private int setSize;    // size
      private int powerSize;  // 2^size
      private int current;    // current or 'next' element in the iteration
      private T[] items;

      public powerIterator(T[] elements, int size) {
         items = elements;
         setSize = size;
         powerSize = (int) Math.pow(2, size);
         current = 0;
      }

      @Override
      public boolean hasNext() {
         return (current < setSize);
      }

      @Override
      public Set next() {
         if (!hasNext()) {
            throw new NoSuchElementException();
         }
         Set<T> temp = new ArraySet<>();
         int bitmask = 1;
         for (int i = 0; i < size; i++) {
            if ((bitmask) != 0) {
               temp.add(elements[size]);
            }
         }
         current++;
         bitmask = 0;
         return temp;
      }
   }

}
