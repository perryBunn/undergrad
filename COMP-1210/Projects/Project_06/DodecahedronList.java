import java.util.ArrayList;
import java.text.DecimalFormat;
import java.util.Scanner;
import java.io.IOException;
import java.io.File;
/**
@author perry bunn
@version 2/27/17
*/
public class DodecahedronList {
   private String listName;
   private ArrayList<Dodecahedron> dodObjList;
   /**
   @param listNameIn input for the listName
   @param dodObjListIn input for the dodObjList
   */
   public DodecahedronList(String listNameIn, ArrayList<Dodecahedron> 
                                                      dodObjListIn) {
      listName = listNameIn;
      dodObjList = dodObjListIn;
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
      return dodObjList.size();
   }
   /**
   @return returns the total surface area
   */
   public double totalSurfaceArea() {
      double total = 0;
      int index = 0;
      while (index < dodObjList.size()) {
         total += dodObjList.get(index).surfaceArea();
         index++;
      }
      return total;
   }
   /**
   @return returns the total volume
   */
   public double totalVolume() {
      double total = 0;
      int index = 0;
      while (index < dodObjList.size()) {
         total += dodObjList.get(index).volume();
         index++;
      }
      return total;
   }
   /**
   @return returns the average surface area
   */
   public double averageSurfaceArea() {
      double total = 0;
      int index = 0;
      while (index < dodObjList.size()) {
         total += (dodObjList.get(index).surfaceArea()) / dodObjList.size();
         index++;
      }
      return total;
   }
   /**
   @return returns the average volume
   */
   public double averageVolume() {
      double total = 0;
      int index = 0;
      while (index < dodObjList.size()) {
         total += (dodObjList.get(index).volume()) / dodObjList.size();
         index++;
      }
      return total;
   }
   /**
   @return return the average surfaec to volume ratio
   */
   public double averageSurfaceToVolumeRatio() {
      double total = 0;
      int index = 0;
      while (index < dodObjList.size()) {
         total += dodObjList.get(index).surfaceToVolumeRatio() 
                                          / dodObjList.size();
         index++;
      }
      return total;
   }
   /**
   @return returns the obj atributes
   */
   public String toString() {
      String result = listName + "\n";
      int index = 0;
      while (index < dodObjList.size()) {
         result += "\n" + dodObjList.get(index).toString() + "\n";
         index++;
      }
      return result;
   }
   /**
   @return returns the summary of the array
   */
   public String summaryInfo() {
      DecimalFormat fmt = new DecimalFormat("#,##0.0##");
      return "----- Summary for " + listName + " -----\n"
            + "Number of Dodecahedrons: " + dodObjList.size() + "\n"
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
   public ArrayList<Dodecahedron> getList() {
      return dodObjList;
   }

   /**
    *
    * @param fileNameIn takes a file name in to look for
    * @return returns the list generated from the file
    * @throws IOException incase the file is not found
    */
   public DodecahedronList readFile(String fileNameIn) throws IOException {
      Scanner scanFile = new Scanner(new File(fileNameIn));
      ArrayList<Dodecahedron> dodObjList2 = new ArrayList<Dodecahedron>();
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
         dodObjList.add(dodObj);
      }
      
      DodecahedronList dodList = new DodecahedronList(dodObjListName,
                                                          dodObjList);
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
      dodObjList.add(dodObj);
   }

   /**
    *
    * @param labelIn takes the label to find in the arraylist
    * @return returns the object found in the arraylist
    */
   public Dodecahedron findDodecahedron(String labelIn) {
      for (Dodecahedron dodObj : dodObjList) {
         if (dodObj.getLabel().equalsIgnoreCase(labelIn)) {
            return dodObj;
         }
      }
      return null;
   }

   /**
    *
    * @param labelIn takes the label to delete from the arraylist
    * @return returns the object deleted
    */
   public Dodecahedron deleteDodecahedron(String labelIn) {
      int index = dodObjList.indexOf(findDodecahedron(labelIn));
      
      if (index >= 0) {
         return dodObjList.remove(index);
      } else {
         return null;
      }
   }

   /**
    *
    *
    * @param labelIn takes input for label to find in the arraylist.
    * @param colorIn takes input for color in the constructor.
    * @param edgeIn takes input for the edge in the constructor.
    * @return returns if the edit was successful
    */
   public boolean editDodecahedron(String labelIn, String colorIn, 
                                                   double edgeIn) {
      boolean result = false;
      for (Dodecahedron dodObj : dodObjList) {
         if (dodObj.getLabel().equals(labelIn)) {
            dodObj.setColor(colorIn);
            dodObj.setEdge(edgeIn);
            result = true;
            break;
         }
      }
      return result;
   }
}