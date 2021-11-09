import java.util.Scanner;
/**
* @author Perry Bunn
* @version 2/9/17
*/
public class DodecahedronApp {
   /**
   * @param args not used.
   */
   public static void main(String[] args) {
      Scanner scan = new Scanner(System.in);
      System.out.println("Enter label, color, and edge length for a "
         + "dodecahedron.");
      System.out.print("\tlabel: ");
      String label = scan.nextLine();
      
      System.out.print("\tcolor: ");
      String color = scan.nextLine();
      
      System.out.print("\tedge: ");
      double edge = scan.nextDouble();
      
      if (edge > 0) {
         Dodecahedron d;
         d = new Dodecahedron(label, color, edge);
         System.out.println("\n" + d.toString());
      } else {
         System.out.println("Error: edge must be greater than 0.");
      }
   }
}