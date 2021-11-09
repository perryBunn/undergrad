import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * ClassRoll.java.
 * A class to illustrate storing and sorting
 * a list of Students.
 *
 * @author   Dean Hendrix (dh@auburn.edu)
 * @version  2016-08-25
 *
 */
public class ClassRoll {

   /** Drives execution. */
   public static void main(String[] args) {

      List<Student> roll = Arrays.asList(
               new Student("Don", "Knuth", 2),
               new Student("Alan", "Turing", 2),
               new Student("Tony", "Hoare", 2),
               new Student("John", "von Neumann", 1),
               new Student("Jimmy", "Dijkstra", 1),
               new Student("Alonzo", "Church", 1),
               new Student("John", "McCarthy", 2),
               new Student("Alan", "Turing", 1),
               new Student("Edsger", "Dijkstra", 2));

      System.out.println("Original Roll: ");
      roll.forEach(System.out::println);
      System.out.println();

      // Sort the roll in natural order.
      Collections.sort(roll);
      System.out.println("Natural Order: ");
      roll.forEach(System.out::println);
      System.out.println();

      // Shuffle the roll into a random order.
      // Use the Collections.shuffle() method.
      // *** Replace this line with your solution.
      System.out.println("Random Order: ");
      roll.forEach(System.out::println);
      System.out.println();

      // Sort the roll in ascending order of section
      Comparator<Student> orderBySection = new CompareStudentsBySection();
      Collections.sort(roll, orderBySection);
      System.out.println("Ascending Order of Section: ");
      roll.forEach(System.out::println);
      System.out.println();

      // Sort the roll in descending order of section.
      // Use either Collections.reverseOrder() or
      // Comparator.reversed() in conjunction with
      // Collections.sort().
      // *** Replace this line with your solution.
      System.out.println("Descending Order of Section: ");
      roll.forEach(System.out::println);
      System.out.println();
   }


   /**
    * Implement this Comparator so that Student objects are compared
    * in ascending order of section. That is, compare(s1, s2) must
    * return a negative integer if s1's section is less than s2's section,
    * zero if s1 and s2 have the same section, and a postive integer
    * if s1's section is greater than s2's section.
    */
   private static class CompareStudentsBySection implements Comparator<Student> {
      /** Compares s1 to s2 in with respect to the defined total order. */
      public int compare(Student s1, Student s2) {
         return -99;
      }
   }

}