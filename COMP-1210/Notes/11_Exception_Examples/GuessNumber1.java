import java.util.Scanner;

public class GuessNumber1 {

   public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
      int num = (int) (Math.random() * 7 + 1);
      int guess = 0;
      int turnsRemaining = 3;
   
      while (guess != num && turnsRemaining > 0) {
      
         try {
            System.out.print(turnsRemaining 
               + (turnsRemaining == 1 ? " turn " : " turns ")
               + "remaining. Guess an integer from 1 to 7: ");
            guess =  Integer.parseInt(input.nextLine());
            //System.out.print("Good guess. "); 
            System.out.print((guess < 1 || guess > 7) 
                              ? "Really? " : "Good guess. ");
         }
         
         catch (NumberFormatException issue) { // non-int inputs
            System.out.print("That wasn't even an integer ... ");
         }
               
         finally {
            turnsRemaining--;
         }
         
         if (guess == num) {
            System.out.println("You are right! Amazing!");
         }
         else {
            System.out.println("Sorry, it was wrong.");
         }   
      }
   }
}