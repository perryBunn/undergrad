/**
 *  WriteRandomHTML.java      
 *
 *  Demonstrates writing random numbers to an HTML file with 
 *  odd numbers in red and even numbers in blue and then opening 
 *  the file in the default web browser.
 */

import java.util.Random;
import java.util.Scanner;
import java.io.*;
import java.awt.Desktop;

public class WriteRandomHTML
{
   /** 
    *  Creates a file of random numbers that consists of ten lines each
    *  containing ten integer values in the range 1 to 100.
    */ 
   public static void main (String[] args) // throws IOException
   {
      final int MAX = 10;
      
      int value;
      String fileName = "output.html";
      Random rand = new Random();
      PrintWriter outFile;
      File theFile = new File(fileName); 
         // theFile.setWritable(true);  // This is another option.
      
      try {
         outFile = new PrintWriter(theFile);
      } 
      catch(FileNotFoundException excObj) {
         System.out.println("Error: could not create "
                  + "file output.html.");
         return;
      }
         
      outFile.println("<h1>Table of 100 Random Numbers</h1>");
      outFile.println("<pre>");
      for (int line=1; line <= MAX; line++)
      {
         for (int num=1; num <= MAX; num++)
         {
            value = (int)( Math.random() * 100) + 1;
            if (value % 2 ==1) {
               outFile.print("<b><font color='blue'>" + value + "</font></b>"+ "\t");
            }
            else {
               outFile.print("<b><font color='red'>" + value + "</font></b>"+ "\t");
            }
         }
            
         outFile.println("<br>");
      }
      outFile.println("</pre>");
      outFile.close(); 
      System.out.println ("Output file has been created: " + theFile);
         
      try  // open HTML output file in desktop browser
      {
         File f = new File(fileName);
         Desktop dt = Desktop.getDesktop();
         dt.open(f);
      }
      catch (Exception exc) { /*handle exception*/
         exc.printStackTrace();    
      }
         
      System.exit(0);
   }
}
