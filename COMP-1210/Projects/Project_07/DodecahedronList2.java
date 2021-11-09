import java.text.DecimalFormat;
import java.util.Scanner;
import java.io.IOException;
import java.io.File;
/**
@author perry bunn
@version 2/27/17
*/
public class DodecahedronList2 {
   private String listName;
   private Dodecahedron[] dodObjList;
   private int arrSize = 0;
   /**
    * @param listNameIn input for the listName
    * @param dodObjListIn input for the dodObjList
    * @param arrSizeIn input that 'resets' the arrSize variable
    */
   public DodecahedronList2(String listNameIn, Dodecahedron[] dodObjListIn,
                                                             int arrSizeIn) {
      listName = listNameIn;
      dodObjList = dodObjListIn;
      arrSize = arrSizeIn;
   }
   /**
   @return returns the name of the list
   */
   public String getName() {
      return listName;
   }
   /**
   @return retuns the total number of objs in the array
   */
   public int numberOfDodecahedrons() {
      for (int i = 0; i < arrSize; i++) {
         if (dodObjList[i] == null) {
            arrSize--;
         }
      }
      return arrSize;
   }
   /**
   @return returns the total surface area
   */
   public double totalSurfaceArea() {
      double total = 0;
      for (int i = 0; i < arrSize; i++) {
         total += dodObjList[i].surfaceArea();
      }
      return total;
   }
   /**
   @return returns the total volume
   */
   public double totalVolume() {
      double total = 0;
      for (int i = 0; i < arrSize; i++) {
         total += dodObjList[i].volume();
      }
      return total;
   }
   /**
   @return returns the average surface area
   */
   public double averageSurfaceArea() {
      double total = 0;
      for (int i = 0; i < arrSize; i++) {
         total += (dodObjList[i].surfaceArea()) / arrSize;
      }
      return total;
   }
   /**
   @return returns the average volume
   */
   public double averageVolume() {
      double total = 0;
      for (int i = 0; i < arrSize; i++) {
         total += (dodObjList[i].volume()) / arrSize;
      }
      return total;
   }
   /**
   @return return the average surface to volume ratio
   */
   public double averageSurfaceToVolumeRatio() {
      double total = 0;
      for (int i = 0; i < arrSize; i++) {
         total += dodObjList[i].surfaceToVolumeRatio() 
                                          / arrSize;
      }
      return total;
   }
   /**
   @return returns the obj attributes
   */
   public String toString() {
      String result = listName + "\n";
      for (int i = 0; i < arrSize; i++) {
         result += "\n" + dodObjList[i].toString() + "\n";
      }
      return result;
   }
   /**
   @return returns the summary of the array
   */
   public String summaryInfo() {
      DecimalFormat fmt = new DecimalFormat("#,##0.0##");
      return "----- Summary for " + listName + " -----\n"
            + "Number of Dodecahedrons: " + arrSize + "\n"
            + "Total Surface Area: " + fmt.format(totalSurfaceArea()) + "\n"
            + "Total Volume: " + fmt.format(totalVolume()) + "\n"
            + "Average Surface Area: " + fmt.format(averageSurfaceArea()) + "\n"
            + "Average Volume: " + fmt.format(averageVolume()) + "\n" 
            + "Average Surface/Volume Ratio: "
            + fmt.format(averageSurfaceToVolumeRatio());
   }

   //-------------------------------------------------------------------------//
   // Project 6 below
   //-------------------------------------------------------------------------//

   /**
    *
    * @return returns the Dodecahedron list
    */
   public Dodecahedron[] getList() {
      return dodObjList;
   }

   /**
    *
    * @param fileNameIn takes a file name in to look for
    * @return returns the list generated from the file
    * @throws IOException in case the file is not found
    */
   public DodecahedronList2 readFile(String fileNameIn) throws IOException {
      Scanner scanFile = new Scanner(new File(fileNameIn));
      String dodObjListName = "";
      String label = "";
      String color = "";
      double edge = 0;
      
      dodObjListName = scanFile.nextLine();
      while (scanFile.hasNext()) {
         label = scanFile.nextLine();
         color = scanFile.nextLine();
         edge = Double.parseDouble(scanFile.nextLine());
         
         Dodecahedron dodObj = new Dodecahedron(label, color, edge);
         dodObjList[arrSize] = dodObj;
         arrSize++;
      }

      DodecahedronList2 dodList = new DodecahedronList2(dodObjListName, dodObjList, arrSize);
      return dodList;
   }

   /**
    *
    * @param labelIn takes input for label in the constructor.
    * @param colorIn takes input for color in the constructor.
    * @param edgeIn takes input for the edge in the constructor.
    */
   public void addDodecahedron(String labelIn, String colorIn, double edgeIn) {
      Dodecahedron dodObj = new Dodecahedron(labelIn, colorIn, edgeIn);
      dodObjList[arrSize] = dodObj;
      arrSize++;
   }

   /**
    *
    * @param labelIn takes the label to find in the array
    * @return returns the object found in the array
    */
   public Dodecahedron findDodecahedron(String labelIn) {
      numberOfDodecahedrons();
      
      if (arrSize > 0) {
      
         for (int i = 0; i < arrSize; i++) {
            if (dodObjList[i].getLabel().equalsIgnoreCase(labelIn)) {
               return dodObjList[i];
            }
         }
         return null;
         
      } else {
         return null;
      }
   }

   /**
    *
    * @param labelIn takes the label to delete from the array
    * @return returns the object deleted
    */
   public Dodecahedron deleteDodecahedron(String labelIn) {
      Dodecahedron[] dodObjCopy = new Dodecahedron[1];
      for (int i = 0; i < arrSize; i++) {
         if (dodObjList[i].getLabel().equals(labelIn)) {
            dodObjCopy[0] = findDodecahedron(labelIn);
            for (int j = i; j < arrSize - 1; j++) {
               dodObjList[j] = dodObjList[j + 1];
            }
            dodObjList[arrSize - 1] = null;
            arrSize--;
         }
      }
      return dodObjCopy[0];
   }

   /**
    *
    *
    * @param labelIn takes input for label to find in the array.
    * @param colorIn takes input for color in the constructor.
    * @param edgeIn takes input for the edge in the constructor.
    * @return returns if the edit was successful
    */
   public boolean editDodecahedron(String labelIn, String colorIn, 
                                                   double edgeIn) {
      if (arrSize != 0) {
         boolean result = false;
         for (int i = 0; i < arrSize; i++) {
            if (dodObjList[i].getLabel().equals(labelIn)) {
               dodObjList[i].setColor(colorIn);
               dodObjList[i].setEdge(edgeIn);
               result = true;
               break;
            }
         }
         return result;
      } else {
         return false;
      }
   }

   //-------------------------------------------------------------------------//
   // Project 7 below
   //-------------------------------------------------------------------------//

   /**
    *
    * @return returns the object with the shortest edge
    */
   public Dodecahedron findDodecahedronWithShortestEdge() {
      Dodecahedron[] dodTest = new Dodecahedron[1];
      dodTest[0] = dodObjList[0];
      for (int i = 0; i < arrSize; i++) {
         if (dodObjList[i].getEdge() < dodTest[0].getEdge()) {
            dodTest[0] = dodObjList[i];
         }
      }
      return dodTest[0];
   }

   /**
    *
    * @return returns the object with the longest edge
    */
   public Dodecahedron findDodecahedronWithLongestEdge() {
      Dodecahedron[] dodTest = new Dodecahedron[1];
      dodTest[0] = dodObjList[0];
      for (int i = 0; i < arrSize; i++) {
         if (dodObjList[i].getEdge() > dodTest[0].getEdge()) {
            dodTest[0] = dodObjList[i];
         }
      }
      return dodTest[0];
   }

   /**
    *
    * @return returns the object with the smallest volume
    */
   public Dodecahedron findDodecahedronWithSmallestVolume() {
      Dodecahedron[] dodTest = new Dodecahedron[1];
      dodTest[0] = dodObjList[0];
      for (int i = 0; i < arrSize; i++) {
         if (dodObjList[i].volume() < dodTest[0].volume()) {
            dodTest[0] = dodObjList[i];
         }
      }
      return dodTest[0];
   }

   /**
    *
    * @return returns the object with the largest volume
    */
   public Dodecahedron findDodecahedronWithLargestVolume() {
      Dodecahedron[] dodTest = new Dodecahedron[1];
      dodTest[0] = dodObjList[0];
      for (int i = 0; i < arrSize; i++) {
         if (dodObjList[i].volume() > dodTest[0].volume()) {
            dodTest[0] = dodObjList[i];
         }
      }
      return dodTest[0];
   }

}