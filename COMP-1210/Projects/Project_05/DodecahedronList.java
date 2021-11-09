import java.util.ArrayList;
import java.text.DecimalFormat;
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
      String finalString = "";
      int index = 0;
      while (index < dodObjList.size()) {
         finalString = "\n" + dodObjList.toString() + "\n";
         index++;
      }
      return "\n" + listName + "\n" + finalString;
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
}