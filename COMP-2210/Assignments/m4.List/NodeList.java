import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author FrankenPC
 * @version 6/30/2018
 */

public class NodeList<T> implements DoubleEndedList<T> {
   private Node first;
   private Node last;
   private int size;

   public NodeList() {
      first = null;
      last = null;
      size = 0;
   }

   @Override
   public void addFirst(T element) {
      if (element == null) {
         throw new IllegalArgumentException();
      }
      Node node = new Node(element);
      if (first == null) {
         first = node;
         last = node;
      } else {
         first.prev = node;
         node.next = first;
         first = node;
      }
      size++;
   }

   @Override
   public void addLast(T element) {
      if (element == null) {
         throw new IllegalArgumentException();
      }
      Node node = new Node(element);
      if (first == null) {
         first = node;
         last = node;
      } else {
         node.prev = last;
         last.prev = node;
         last = node;
      }
      size++;
   }

   @Override
   public T removeFirst() {
      if (isEmpty()) {
         return null;
      }
      T remove = first.elem;
      if (size == 1) {
         first = null;
         last = null;
      } else {
         first = first.next;
         first.prev = null;
      }
      size--;
      return remove;
   }

   @Override
   public T removeLast() {
      if (isEmpty()) {
         return null;
      }
      T remove = last.elem;
      if (size == 1) {
         first = null;
         last = null;
      } else {
         last = last.prev;
         last.next = null;
      }
      size--;
      return remove;
   }

   @Override
   public int size() {
      return size;
   }

   @Override
   public boolean isEmpty() {
      return size == 0;
   }

   @Override
   public Iterator<T> iterator() {
      return new NodeIterator();
   }

   private class Node {

      private T elem;
      private Node next;
      private Node prev;

      public Node(T elemIn) {
         elem = elemIn;
         next = null;
         prev = null;
      }

      public Node(T elemIn, Node n) {
         elem = elemIn;
         next = n;
      }

      public Node(T elemIn, Node n, Node p) {
         elem = elemIn;
         next = n;
         prev = p;
      }

      private int length(Node node) {
         Node copy = node;
         int len = 0;
         while (copy != null) {
            copy = copy.next;
            len++;
         }
         return len;
      }
   }

   private class NodeIterator<T> implements Iterator {

      private Node pos = first;

      public NodeIterator() {}

      @Override
      public boolean hasNext() {
         return pos != null;
      }

      @Override
      public T next() {
         if (!hasNext()) {
            throw new NoSuchElementException();
         }
         T next = (T) pos.elem;
         pos = pos.next;
         return next;
      }

      @Override
      public void remove() {
         throw new UnsupportedOperationException();
      }
   }
}
