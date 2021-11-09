import java.util.Iterator;
import java.util.Random;
import java.util.NoSuchElementException;

public class RandomList<T> implements RandomizedList<T>{

   private T[] elements;
   private int size = 0;

   public RandomList() {
      this(5);
   }

   public RandomList(int max) {
      elements = (T[]) new Object[max];
      size = 0;
   }

   @Override
   public void add(Object element) {
      if (element == null) {
         throw new IllegalArgumentException();
      }
      if (size == elements.length) {
         resize(elements.length*2);
      }
      elements[size] = (T) element;
      size++;
   }

   @Override
   public T remove() {
      if (this.isEmpty()) {
         return null;
      }
      Random rand = new Random();
      int randPos = rand.nextInt(size);
      T removed = elements[randPos];
      elements[randPos] = null;
      if (randPos != size - 1) {
         elements[randPos] = elements[size - 1];
         elements[size - 1]= null;
      }
      size--;
      return removed;
   }

   @Override
   public T sample() {
      if (!this.isEmpty()) {
         Random rand = new Random();
         int randPos = rand.nextInt(size);
         return elements[randPos];
      }
      return null;
   }

   @Override
   public int size() {
      return size;
   }

   @Override
   public boolean isEmpty() {
      return size == 0;
   }

   private void resize(int capacity) {
      T[] a = (T[]) new Object[capacity];
      System.arraycopy(elements, 0, a, 0, size());
      elements = a;
   }

   @Override
   public Iterator iterator() {
      return new RandIterator(elements, size);
   }

   private class RandIterator<T> implements Iterator<T> {
      private int length;
      private T[] copy;

      public RandIterator(T[] elements, int sizeIn) {
         length = sizeIn;
         copy = elements;
      }

      @Override
      public boolean hasNext() {
         return (length > 0);
      }

      @Override
      public T next() {
         if (!hasNext()) {
            throw new NoSuchElementException();
         }
         Random rand = new Random();
         int value = rand.nextInt(length);
         T next = copy[value];
         if (value != (length-1)) {
            copy[value] = copy[length-1];
            copy[length-1] = next;
            }
         length--;
         return next;
      }

      @Override
      public void remove() {
         throw new UnsupportedOperationException();
      }
   }
}
