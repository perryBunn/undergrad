import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;

/**
 * Defines objects with a name and a list of Triangle objects.
 */
public class TriangleList {
   private String listName;
   private ArrayList<Triangle> tList;
   
   /**
    * Constuctor.
    * @param listNameIn for listName
    * @param tListIn for listIn
    */
   public TriangleList(String listNameIn, ArrayList<Triangle> tListIn) {
      listName = listNameIn;
      tList = tListIn;
   }
   
   /**
    * Getter for listName.
    * @return listName
    */
   public String getListName() {
      return listName;
   }
   
   /**
    * @return the number of Triangle objects in the tList.
    */
   public int numTriangles() {
      return  tList.size();
   }
   
   /**
    * Finds the total of the perimeters using a while loop.
    *
    * @return the sum of all perimeters in this TriangleList object;
    *         return 0 if list is empty.
    */
   public double totalOfPerimeters() {
      double total = 0;
      
      int index = 0;
      while (index < tList.size()) {
         total += tList.get(index).perimeter();
         index++;  
      }   
      
      return total;
   }

   /**
    * Finds the total of the perimeters using a for loop.
    *
    * @return the sum of all perimeters in this TriangleList object;
    *         return 0 if list is empty.
    */
   public double totalOfPerimeters2() {
      double total = 0;
   
      for (int index = 0; index < tList.size(); index++) {
         total += tList.get(index).perimeter();
      }   
      
      return total;
   }

    /**
    * Finds the total of the perimeters using a for-each loop.
    *
    * @return the sum of all perimeters in this TriangleList object;
    *         return 0 if list is empty.
    */
   public double totalOfPerimeters3() {
      double total = 0;
   
      for (Triangle t : tList) {
         total += t.perimeter();
      }   
      
      return total;
   }

   /**
    * @return the smallest perimeter of Triangle objects in the tList.
    */
   public double smallestPerimeter() {
      double smallest = 0;
   
      if (tList.size() != 0) {
         smallest = tList.get(0).perimeter();
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

   /**
    * @return the largest perimeter of Triangle objects in the tList.
    */
   public double largestPerimeter() {
      double largest = 0;
      int index = 0;
      while (index < tList.size()) {
         if (largest < tList.get(index).perimeter()) {
            largest = tList.get(index).perimeter();
         }
         index++;  
      }   
      
      return largest;
   }
   
   /**
    * @return  the smallest perimeter of Triangle objects in the tList
    *          along with the sides of the triangle.
    */
   public String largestPerimeterWithSides() {
      double largest = 0;
      int indexOfLargest = 0;
      int index = 0;
      while (index < tList.size()) {
         if (tList.get(indexOfLargest).perimeter() 
               < tList.get(index).perimeter()) {
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
   
   /**
    * @return the String representation of the TriangleList.
    */
   public String toString() {
      String result = "\n" + listName + "\n";
      int index = 0;
      while (index < tList.size()) {
         result += "\n" + tList.get(index) + "\n"; 
         index++;  
      }   
      return result;
   }
   
   /**
    * @return the String representation of the TriangleList Summary.
    */
   public String summary() {
      DecimalFormat df = new DecimalFormat("#,##0.##");
      String result = "";
      result += "----- Summary for " + getListName() + " -----"; 
      result += "\nNumber of Triangles: " + numTriangles();
      result += "\nSmallest Perimeter: " + smallestPerimeter(); 
      result += "\nLargest Perimeter: "  + largestPerimeterWithSides();
      result += "\nTotal of Perimeters: "  + totalOfPerimeters();
      
      return result;
   }


   //************************************************************
   //******************** Begin new methods *********************
   //************************************************************
   
  /**  
   * Reads in triangle data from file and creates a 
   * TriangleList object.
   *
   * @param fileNameIn for fileName to read
   * @return TriangleList
   * @throws IOException for file reading
   */   
   public TriangleList readFile(String fileNameIn) throws IOException {
            
      Scanner scanFile = new Scanner(new File(fileNameIn));
      ArrayList<Triangle> myList = new ArrayList<Triangle>();
      String tListName = "";
      int side1 = 0, side2 = 0, side3 = 0;
      
      listName = scanFile.nextLine();      
      while (scanFile.hasNext()) {
         side1 = Integer.parseInt(scanFile.nextLine());
         side2 = Integer.parseInt(scanFile.nextLine());
         side3 = Integer.parseInt(scanFile.nextLine());
         
         Triangle t = new Triangle(side1, side2, side3);
         myList.add(t);           
      }
      
      TriangleList tL = new TriangleList(listName, myList);
      
      return tL;
   }
   
  /**  
   * Add a Triangle object to the list.
   * 
   * @param s1In Length of side 1.
   * @param s2In Length of side 2.
   * @param s3In Length of side 3.
   */   
   public void addTriangle(double s1In, double s2In, double s3In) {
       
      Triangle t = new Triangle(s1In, s2In, s3In);
      
      tList.add(t);
   }
   
   
  /**
   * Deletes a Triangle from the list.
   *   
   * @param s1In for side 1
   * @param s2In for side 2
   * @param s3In for side 3
   * @return true if deleted else return false
   */   
   public boolean deleteTriangle(double s1In, double s2In, double s3In) {
   
      boolean result = false;
      int index = -1;
      for (Triangle t : tList) {
         if (t.getS1() == s1In 
            && t.getS2() == s2In
            && t.getS3() == s3In) {
            index = tList.indexOf(t);
            break;
         }
      }
      
      if (index >= 0) {
         tList.remove(index);
         result = true;
      }
      return result;
   }

}
