import java.util.Scanner;

public class AbsoluteValue1 {

   public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
      double num = 0;
   
      do {
         System.out.print("Enter a number (0 to end): ");
         num = Double.parseDouble(input.nextLine());
         if (num == 0) {
            break;
         }
         System.out.println(num + " has absolute value of: " + Math.abs(num));
      
      } while (true);
   
   }
}