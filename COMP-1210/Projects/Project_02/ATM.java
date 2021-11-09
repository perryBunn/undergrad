import java.util.Scanner;
/**
* takes the user input and then prints the 
* input with respects to whole bill amounts.
*
* @author Perry Bunn
* @version 1/23/17
*/
public class ATM {
   /**
   *
   *
   * @param args not used.
   */
   public static void main(String[] args) {
      Scanner userInput = new Scanner(System.in);
      int withDraw;
      int twenties = 0;
      int tens = 0;
      int fives = 0;
      int ones = 0;
   
      System.out.print("Enter the amount: ");
      withDraw = userInput.nextInt();
      if (withDraw > 500) {
         System.out.println("Limit of $500 exceeded!");
      } 
      else {
         // find the denominations of the money from the input
         twenties = withDraw / 20;
         withDraw = withDraw % 20;
         tens = withDraw / 10;
         withDraw = withDraw % 10;
         fives = withDraw / 5;
         withDraw = withDraw % 5;
         ones = withDraw;
         
         //prints it in respect to the bills
         System.out.println("Bills by demonination:");
         System.out.println("\t$20: " + twenties);
         System.out.println("\t$10: " + tens);
         System.out.println("\t$5: " + fives);
         System.out.println("\t$1: " + ones);
         
         //add it all back together
         withDraw = (twenties * 20 + tens * 10 + fives * 5 + ones);
         System.out.println("$" + withDraw + " = (" + twenties + " * $20) + (" 
            + tens + " * $10) + (" + fives + " * $5) + (" + ones + " * $1)");
      }
   }
}