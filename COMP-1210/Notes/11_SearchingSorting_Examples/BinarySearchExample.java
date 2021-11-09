/** BinarySearchExample with static binarySearch method.
 *  This example is intended to illustrate the viewer canvas
 *  with the Presentation Structure Identifier rendering of 
 *  an array which has been "configured" with indexes.  
 *  
 *  Click the "Run in Canvas" button on the toolbar. Then on 
 *  the canvas window, click the "Play" button. Regulate the 
 *  speed with the "Delay" slider.
 *  
 *  To create your own canvas, click the "Pause" button on the
 *  canvas.  Then on the Debug tab click the "Open Canvas" button.
 *  Click the "Step" and Step-in" buttons as needed until you 
 *  see objects and primitives of interest in the Variables tab 
 *  and then drag them onto the canvas. Arrange the viewers and 
 *  click the "Play" button. **/
public class BinarySearchExample {  

   public static void main(String[] args) {
   
      int[] ia = {12, 34, 56, 65, 73, 81, 97};
   
      System.out.println("Index of 12 is: " + binarySearch(12, ia));
      System.out.println("Index of 65 is: " + binarySearch(65, ia));
      System.out.println("Index of 97 is: " + binarySearch(97, ia));
      System.out.println("Index of 100 is: " + binarySearch(100, ia));
   }

   /** Executes a binary search.
    *
    * @param key the binary search target.
    *
    * @param intArray the sorted array to be searched.
    *
    * @return the index of <code>key</code> or -1 if it was not found. **/
   public static int binarySearch(int key, int[] intArray) {
      int low = 0;
      int high = intArray.length - 1;
      while (low <= high) {
         int mid = low + (high - low) / 2; // find center
         if (key < intArray[mid]) {
            high = mid - 1;
         }
         else if (key > intArray[mid]) {
            low = mid + 1;
         }
         else {
            return mid;
         }
      }
      return -1;
   }
}