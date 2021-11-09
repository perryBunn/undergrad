import java.util.Scanner;
import java.io.PrintWriter;
import java.io.FileNotFoundException;

public class WriteLines {

   public static void main(String[] args) {
   
      String fileName = "output.txt";
      String output;
      Scanner keyboardInput = new Scanner(System.in);  
      PrintWriter fileOutput;
   
      try {
      
         fileOutput = new PrintWriter(fileName);
      } 
      catch(FileNotFoundException excObj) {
         System.out.println("Error: could not write "
               + "to file output.txt.");
         return;
      }
      
      System.out.println("Enter what you want to write "
         + "to the file. The last line should be END.");
   
      do {
         output = keyboardInput.nextLine();
         fileOutput.println(output);
      
      } while (!(output.trim()).equals("END"));
    
   // this line is very important
      fileOutput.close();
   }
}