import java.util.Scanner;
import java.util.Random;
import java.text.DecimalFormat;
/**
* 
*
* @author perry bunn
* @version 2/2/17
*/
public class SpaceTicket {
   static final double STUDENT_DISCOUNT = .25;
   static final double CHILD_DISCOUNT = .35;
   /**
   * 
   *
   * @param args not used.
   */
   public static void main(String[] args) {
      Scanner userInput = new Scanner(System.in);
      
      System.out.print("Enter ticket code: ");


      DecimalFormat fmt1 = new DecimalFormat("$###,###.##");
      String x = userInput.nextLine();
      double price;
      char category;
      String hour;
      String minutes;
      String month;
      String day;
      String year;
      String seat;
      String description;
      double cost;
      int prize;

      
      if (x.length() >= 25) {
         x = x.trim();
         price = Double.parseDouble(x.substring(0, 8));
         category = x.charAt(8);
         
         if (category == 'c') {
            cost = price - (price * CHILD_DISCOUNT);
         } else if (category == 's') {
            cost = price - (price * STUDENT_DISCOUNT);
         } else {
            cost = price;
         }
         
         
         hour = x.substring(9, 11);
         minutes = x.substring(11, 13);
         
         month = x.substring(13, 15);
         day = x.substring(15, 17);
         year = x.substring(17, 21);
         
         seat = x.substring(21, 24);
         description = x.substring(24);
         
         Random gen = new Random();
         prize = gen.nextInt(999999) + 1; 
                 
         System.out.println("Space Ticket: " + description);
         System.out.println("Date: " + month + "/" + day + "/" + year 
            + "   Time: " + hour + ":" + minutes + "   Seat: " + seat);
         System.out.println("Price: " + fmt1.format(price) 
            + "   Category: " + category + "   Cost: " + fmt1.format(cost));
         System.out.println("Prize Number: " + prize);
      } else {
         System.out.println("*** Invalid ticket code ***");
         System.out.println("Ticker code must have at least 25 characters.");
      }
   }
}