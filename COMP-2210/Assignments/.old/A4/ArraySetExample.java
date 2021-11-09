import java.util.Iterator;

/**
 * ArraySetExample.java
 * Illustrates the effect of the ArraySet methods.
 *
 * @author    Dean Hendrix (dh@auburn.edu)
 * @version   2017-10-02
 *
 */
public class ArraySetExample {

   /** Drives execution. */
   public static void main(String[] args) {

      //////////////////////////////////////
      // Create example sets using add(). //
      //////////////////////////////////////

      // create the set s1 = {0,1,2,3,4}
      ArraySet<Integer> s1 = new ArraySet<Integer>();
      for (int i = 0; i < 5; i++) {
         s1.add(i);
      }
      System.out.println("s1 = " + s1);

      // create the set s2 = {4,3,2,1,0}
      ArraySet<Integer> s2 = new ArraySet<Integer>();
      for (int i = 4; i >= 0; i--) {
         s2.add(i);
      }
      System.out.println("s2 = " + s2);

      // create the set s3 = {-5, 1, 0, -1}
      ArraySet<Integer> s3 = new ArraySet<Integer>();
      s3.add(-5);
      s3.add(1);
      s3.add(0);
      s3.add(-1);
      System.out.println("s3 = " + s3);


      //////////////////////////////////////////
      // Duplicates are not allowed in a set. //
      //////////////////////////////////////////

      for (int i = 0; i < 5; i++) {
         s1.add(i);
      }
      System.out.println("s1 = " + s1);


      /////////////////////////////
      // Call the size() method. //
      /////////////////////////////

      System.out.println("s1.size() = " + s1.size());
      System.out.println("s2.size() = " + s2.size());
      System.out.println("s3.size() = " + s3.size());


      ///////////////////////////////
      // Call the equals() method. //
      ///////////////////////////////

      System.out.println("s1.equals(s1) = " + s1.equals(s1));
      System.out.println("s1.equals(s2) = " + s1.equals(s2));
      System.out.println("s1.equals(s3) = " + s1.equals(s3));


      //////////////////////////////
      // Call the union() method. //
      //////////////////////////////

      System.out.println("s1.union(s1) = " + s1.union(s1));
      System.out.println("s1.union(s2) = " + s1.union(s2));
      System.out.println("s1.union(s3) = " + s1.union(s3));


      /////////////////////////////////////
      // Call the intersection() method. //
      /////////////////////////////////////

      System.out.println("s1.intersection(s1) = " + s1.intersection(s1));
      System.out.println("s1.intersection(s2) = " + s1.intersection(s2));
      System.out.println("s1.intersection(s3) = " + s1.intersection(s3));


      ///////////////////////////////////
      // Call the complement() method. //
      ///////////////////////////////////

      System.out.println("s1.complement(s1) = " + s1.complement(s1));
      System.out.println("s1.complement(s2) = " + s1.complement(s2));
      System.out.println("s1.complement(s3) = " + s1.complement(s3));


      /////////////////////////////////////////////////////////////////
      // None of these methods above have changed the original sets. //
      /////////////////////////////////////////////////////////////////

      System.out.println("s1 = " + s1);
      System.out.println("s2 = " + s2);
      System.out.println("s3 = " + s3);


      ///////////////////////////////////
      // Call the contains() method(). //
      ///////////////////////////////////

      Integer target = 3;

      System.out.println("s1.contains(" + target + ") = " + s1.contains(target));
      System.out.println("s2.contains(" + target + ") = " + s2.contains(target));
      System.out.println("s3.contains(" + target + ") = " + s3.contains(target));


      ///////////////////////////////
      // Call the remove() method. //
      ///////////////////////////////

      System.out.println("s1.remove(" + target + ") = " + s1.remove(target));
      System.out.println("s2.remove(" + target + ") = " + s2.remove(target));
      System.out.println("s3.remove(" + target + ") = " + s3.remove(target));

      System.out.println("s1.contains(" + target + ") = " + s1.contains(target));
      System.out.println("s2.contains(" + target + ") = " + s2.contains(target));
      System.out.println("s3.contains(" + target + ") = " + s3.contains(target));

      System.out.println("s1.size() = " + s1.size());
      System.out.println("s2.size() = " + s2.size());
      System.out.println("s3.size() = " + s3.size());

   }
}

/*

      R U N T I M E   O U T P U T

s1 = [0, 1, 2, 3, 4]
s2 = [0, 1, 2, 3, 4]
s3 = [-5, -1, 0, 1]
s1 = [0, 1, 2, 3, 4]
s1.size() = 5
s2.size() = 5
s3.size() = 4
s1.equals(s1) = true
s1.equals(s2) = true
s1.equals(s3) = false
s1.union(s1) = [0, 1, 2, 3, 4]
s1.union(s2) = [0, 1, 2, 3, 4]
s1.union(s3) = [-5, -1, 0, 1, 2, 3, 4]
s1.intersection(s1) = [0, 1, 2, 3, 4]
s1.intersection(s2) = [0, 1, 2, 3, 4]
s1.intersection(s3) = [0, 1]
s1.complement(s1) = []
s1.complement(s2) = []
s1.complement(s3) = [2, 3, 4]
s1 = [0, 1, 2, 3, 4]
s2 = [0, 1, 2, 3, 4]
s3 = [-5, -1, 0, 1]
s1.contains(3) = true
s2.contains(3) = true
s3.contains(3) = false
s1.remove(3) = true
s2.remove(3) = true
s3.remove(3) = false
s1.contains(3) = false
s2.contains(3) = false
s3.contains(3) = false
s1.size() = 4
s2.size() = 4
s3.size() = 4



 */
