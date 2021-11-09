import java.io.IOException;

/**
 * @author Perry Bunn
 * @version 4/24/17
 */
public class BakeryPart3 {
   /**
    * @param args command line arguments
    */
   public  static void main(String[] args) {
      if (args.length == 0 || args[0] == null || args[0].equals("")) {
         System.out.println("File name expected as command line argument.");
         System.out.println("Program ending.");
      } else {
         String fileName = args[0];
         try {
            BakedItemList a = new BakedItemList();
            a.readItemFile(fileName);
            System.out.println(a.generateReport());
            System.out.println(a.generateReportByClass());
            System.out.println(a.generateReportByPrice());
            System.out.println(a.generateReportByFlavor());
            System.out.println(a.generateExcludedRecordsReport());
         } catch (IOException e) {
            System.out.println("Attempted to read file: " + fileName 
               + " (No such file or directory)\n" 
               + "Program ending.");
         }
      }
   }
}