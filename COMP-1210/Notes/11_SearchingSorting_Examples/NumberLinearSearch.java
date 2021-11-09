import java.util.Scanner;

public class NumberLinearSearch {

   public static void main(String[] args) {
   
      Scanner scan = new Scanner(System.in);
      int[] nums = 
         {2, 4, 9, 23, 27, 29, 30, 34, 45, 59, 67, 76, 89, 92, 97};
      int target;
      
      System.out.print("Enter integer to find: ");
      target = Integer.parseInt(scan.nextLine()); 
   	
      int foundAt = -1;
      for (int i = 0; i < nums.length; i++) {
         if (nums[i] == target) {
            foundAt = i;
            break;
         }
      }
      
      if (foundAt == -1) {
         System.out.println(target + " not found.");
      }
      else {
         System.out.println(nums[foundAt] 
                       + " found at index " + foundAt + ".");
      }
   }
}