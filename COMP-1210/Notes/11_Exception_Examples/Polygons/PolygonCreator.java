import java.util.Scanner;

public class PolygonCreator {

   public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
      double[] sides;
   
      try {
         System.out.print("Enter the sides of a polygon "
            + "separated by spaces: \n\tSides: ");
         String[] sideInputs = input.nextLine().trim().split(" ");
         double[] lengths = new double[sideInputs.length];
      
         for (int i = 0; i < sideInputs.length; i++) {
            lengths[i] = Double.parseDouble(sideInputs[i]);
         }
      
         Polygon p = new Polygon(lengths);
         System.out.println("The polygon is a " + p + "."); 
      }
      catch (NumberFormatException error) {
         System.out.println("One of the values "
               + "that you entered was not a number.");
      }
      catch (InvalidLengthException error) {
         System.out.println(error);   
      }
   }
}