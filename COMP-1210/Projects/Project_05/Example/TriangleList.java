import java.util.ArrayList;
import java.text.DecimalFormat;

public class TriangleList {
   String listName;
   ArrayList<Triangle> tList;
   
   public TriangleList(String listNameIn, ArrayList<Triangle> tListIn) {
      listName = listNameIn;
      tList = tListIn;
   }
   
   public String getListName() {
      return listName;
   }
   
   public int numTriangles() {
      return  tList.size();
   }

   public double totalOfPerimeters() {
      double total = 0;
   
   // What value is returned if there are no Triangles in the list?
   
      int index = 0;
      while (index < tList.size()) {
         total += tList.get(index).perimeter();
         index++;  
      }   
      
      return total;
   }


   public double smallestPerimeter() {
      double smallest = 0;
   
      if (tList.size() != 0) {
         smallest = tList.get(0).perimeter();
      }
      else {
         return 0;
      }
      
      int index = 0;
      while (index < tList.size()) {
         if (!(smallest < tList.get(index).perimeter())) {
            smallest = tList.get(index).perimeter();
         }
         index++;  
      }   
      
      return smallest;
   }

   public String largestPerimeterWithSides() {
      double largest = 0;
      int indexOfLargest = 0;
      int index = 0;
      while (index < tList.size()) {
         if (tList.get(indexOfLargest).perimeter() < tList.get(index).perimeter()) {
            indexOfLargest = index;
         }
         index++;  
      }   
      
      if (tList.size() > 0) {
         return tList.get(indexOfLargest).perimeter()
            + " for sides "
            + tList.get(indexOfLargest).getS1() + ", " 
            + tList.get(indexOfLargest).getS2() + ", " 
            + tList.get(indexOfLargest).getS3();
      }
      else {
         return "No triangles in list";
      }
   }
      
   public String toString() {
      String result = "\n" + listName + "\n";
      int index = 0;
      while (index < tList.size()) {
         result += "\n" + tList.get(index) + "\n"; 
         index++;  
      }   
      return result;
   }
   
   public String summary() {
      DecimalFormat df = new DecimalFormat("#,##0.##");
      String result = "";
      result += "----- Summary for " + getListName()+ " -----"; 
      result += "\nNumber of Triangles: " + numTriangles();
      result += "\nSmallest Perimeter: " + smallestPerimeter(); 
      result += "\nLargest Perimeter: "  + largestPerimeterWithSides();
      result += "\nTotal of Perimeters: "  + totalOfPerimeters();
      
      return result;
   }
}
