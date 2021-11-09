import java.util.Arrays;
import java.util.Scanner;

public class NumberBinarySearchArray2 {

   public static void main(String[] args) {
   
      Scanner scan = new Scanner(System.in);
      int[] nums = new int[15];
      int target;
      
      for (int i = 0; i < 15; i++) {
         nums[i] = (int) (Math.random() * 25);
      }
   
      System.out.print("Integer to find: ");
      target = Integer.parseInt(scan.nextLine()); 
   
      java.util.Arrays.sort(nums);
      
      int min = 0, max = nums.length - 1, mid = 0;
      int foundAt = -1;
   	
      while (foundAt == -1 && min <= max) {
         mid = min + (max - min) / 2; // find center
         if (nums[mid] == target) {
            foundAt = mid;
         }
         else {
            if (nums[mid] > target) {
               max = mid - 1;
            }
            else {
               min = mid + 1;
            }
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