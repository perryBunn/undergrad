/**
* 
*/
public class NumberOperations {
   private int number;
   /**
   * @param numberIn the number into the constructor from the driver program
   */
   public NumberOperations(int numberIn) {
      number = numberIn;   
   }
   /**
   * @return returns the number
   */
   public int getValue() {
      return number;
   }
   /**
   * @return returns the output
   */
   public String oddsUnder() {
      String output = "";
      int i = 0;
      while (i < number) {
         if (i % 2 != 0) {
            output += i + "\t";
         }
         i++;
      }
      return output;
   }
   /**
   * @return returns a string of numbers that can be powerd
   */
   public String powersTwoUnder() {
      String output = "";
      int powers = 1;
      while (powers < number) {
         output += powers + "\t";
         powers = powers * 2;
      }
      return output;
   }
   /**
   * @return returns a positive or negative number or 0
   * @param compareNumber input for it to compare
   */
   public int isGreater(int compareNumber) {
      if (number > compareNumber) {
         return 1;
      } else if (number < compareNumber) {
         return -1;
      } else {
         return 0;
      }
   }
   /**
   * @return returns numbers
   */
   public String toString() {
      return number + "";
   }
}