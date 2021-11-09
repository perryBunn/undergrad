import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
   
public class ReadLines2 
{   
   public static void main(String[] args) //throws FileNotFoundException
   {   
      String fileName;
      Scanner fileInput = null; // so that fileInput is intialized
      int lineCount = 0;
      Boolean found = false;
      Scanner keyboardInput = new Scanner(System.in);
      
      do {   
         System.out.print("Enter a file name: ");
         fileName = keyboardInput.nextLine();
         
         try 
         {
            fileInput = new Scanner(new File(fileName));
            found = true;
         }
         catch (FileNotFoundException excepObj) {
            System.out.println("Error: Couldn't find the file.");
            System.out.println(excepObj);
         //return;
         } 
      } while (!found); 
      	
      while (fileInput.hasNextLine()) {
         lineCount++;
         System.out.println("Line " + lineCount + ": " 
               + fileInput.nextLine());
      }
         
      System.out.println("\r\nThere were " + lineCount 
            + " line(s) in the file.");
   }
}