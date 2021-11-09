import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

   
public class NumberBinarySearchArrayList {
   
   public static void main(String[] args) {
      ArrayList<Integer> nums = new ArrayList<Integer>();
      nums.add(2);
      nums.add(4);
      nums.add(9);
      nums.add(23);
      nums.add(27);
      nums.add(29);
      nums.add(30);
      nums.add(34);
      nums.add(45);
      nums.add(59);
      nums.add(67);
      nums.add(76);
      nums.add(89);
      nums.add(92);
      nums.add(97);
   
      Scanner scan = new Scanner(System.in);
      int target;
      
      System.out.print("Integer to find: ");
      target = Integer.parseInt(scan.nextLine()); 
   
      
      Collections.sort(nums);
      //Arrays.sort(nums);
       
      int min = 0, max = nums.size() - 1, mid = 0;
      int foundAt = -1;
      	
      while (foundAt == -1 && min <= max) {
         mid = min + (max - min) / 2; // find center
         if (nums.get(mid) == target) {
            foundAt = mid;
         }
         else {
            if (nums.get(mid) > target) {
               max = mid - 1;
            }
            else {
               min = mid + 1;
            }
         }
      }
         
   //       if (foundBin == -1) {
   //          System.out.println("Number not found.");
   //       }
   //       else {
   //          System.out.println(foundBin);
   //       }
   
      if (foundAt == -1) {
         System.out.println(target + " not found.");
      }
      else {
         System.out.println(nums.get(foundAt) 
                       + " found at index " + foundAt + ".");
      }
   
   }
   
}