import java.util.Iterator;

/**
 * PowerSetExample.java
 * Illustrates how the ArraySet iterator can be used
 * to generate elements of a set's power set one by
 * one.
 *
 * @author    Dean Hendrix (dh@auburn.edu)
 * @version   2017-10-02
 *
 */
public class PowerSetExample {

   /** Drives execution. */
   public static void main(String[] args) {
      // create the set s = {0,1,2,3,4}
      ArraySet<Integer> s = new ArraySet<Integer>();
      for (int i = 0; i < 5; i++) {
         s.add(i);
      }

      // use the powerSetIterator to print out all
      // 32 subsets of s
      int i = 0;
      Iterator<Set<Integer>> ps = s.powerSetIterator();
      while (ps.hasNext()) {
         System.out.print("Subset " + (i++) + " = ");
         System.out.println(ps.next());
      }
   }
}

/*

      R U N T I M E   O U T P U T

Subset 0 = []
Subset 1 = [0]
Subset 2 = [1]
Subset 3 = [0, 1]
Subset 4 = [2]
Subset 5 = [0, 2]
Subset 6 = [1, 2]
Subset 7 = [0, 1, 2]
Subset 8 = [3]
Subset 9 = [0, 3]
Subset 10 = [1, 3]
Subset 11 = [0, 1, 3]
Subset 12 = [2, 3]
Subset 13 = [0, 2, 3]
Subset 14 = [1, 2, 3]
Subset 15 = [0, 1, 2, 3]
Subset 16 = [4]
Subset 17 = [0, 4]
Subset 18 = [1, 4]
Subset 19 = [0, 1, 4]
Subset 20 = [2, 4]
Subset 21 = [0, 2, 4]
Subset 22 = [1, 2, 4]
Subset 23 = [0, 1, 2, 4]
Subset 24 = [3, 4]
Subset 25 = [0, 3, 4]
Subset 26 = [1, 3, 4]
Subset 27 = [0, 1, 3, 4]
Subset 28 = [2, 3, 4]
Subset 29 = [0, 2, 3, 4]
Subset 30 = [1, 2, 3, 4]
Subset 31 = [0, 1, 2, 3, 4]


 */
