import java.util.Scanner;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.awt.Desktop;

public class WriteLinesHTML {

   public static void main(String[] args) {
   
      String fileName = "output.html";
      String output = "";
      Scanner keyboardInput = new Scanner(System.in);  
      PrintWriter fileOutput;
   
      try {
         fileOutput = new PrintWriter(fileName);
      } 
      catch (FileNotFoundException excObj) {
         System.out.println("Error: could not create "
               + "file output.html.");
         return;
      }
      
      System.out.println("Enter what you want to write "
         + "to the file. The last line should be END.");
      
      fileOutput.println("<p>");
      do {
         output = keyboardInput.nextLine();
         if ((output.trim()).equals("END")) {
            break;
         }
         fileOutput.println("<b><font color='red'>" + output 
                           + "</font></b>" + "<br>");
      } while (true);
      fileOutput.println("</p>");
    
   // this line is very important
      fileOutput.close();
   
      try  // open HTML output file in desktop browser
      {
         File f = new File("output.html");
         Desktop dt = Desktop.getDesktop();
         dt.open(f);
      }
      catch (Exception exc) { /*handle exception*/
         exc.printStackTrace();    
      }
   // Required to end program since the Desktop object was launched.
      System.exit(0);  
   }
}