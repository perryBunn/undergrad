/**
 *  TestDataSimple.java
 *
 *  Demonstrates the use (writing and reading) of a text file.
 */
import java.util.Random;
import java.util.Scanner;
import java.io.*;

public class WriteReadRandom
{
   //-----------------------------------------------------------------
   //  Creates a file of test data that consists of ten lines each
   //  containing ten integer values in the range 1 to 100.
   //-----------------------------------------------------------------
   public static void main (String[] args) throws IOException
   {
      final int MAX = 10;
   
      int value;
      String file = "test.dat";
      new File("test.dat").setWritable(true);  // This is another option.
   
      Random rand = new Random();
   
      // PrintWriter outFile = new PrintWriter("test.dat");
      PrintWriter outFile = new PrintWriter(new File("test.dat"));
   
   
      for (int line=1; line <= MAX; line++)
      {
         for (int num=1; num <= MAX; num++)
         {
            value = (int)(Math.random() * 100) + 1;
            outFile.print (value + "\t");
         }
         outFile.println ();
      }
      new File("test.dat").setWritable(false);  // This is another option.
      outFile.close();
      System.out.println ("Output file has been created: " + file);
      
      Scanner inFile = new Scanner(new File("test.dat"));
      String line;
      while(inFile.hasNext())
      {   
         line = inFile.nextLine();
         System.out.println(line);
      }
         
      inFile.close();
      System.out.println ("Input file \"test.dat\" has been read!");
   
   }
}
