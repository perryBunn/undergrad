import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Code for benchmarking the time taken to simulate cutting
 * and splicing strands of DNA. These benchmark methods are
 * intended to be used in reasoning about tradeoffs in using 
 * a linked list to represent a strand of DNA and to compare
 * this representation with a simple array/String representation.
 *
 * @author   Dean Hendrix (dh@auburn.edu)
 * @author   Owen Astrachan
 * @version  2017-10-16
 *
 */
public class DnaSimulation {

   // the string that represents the DNA sequence used in the simulation
   private static String source;

   // the string that represents the restriction enzyme used in the simulation
   private static final String enzyme = "gaattc";

   /** 
    * Run the simulation using args[0] as the input file and
    * args[1] as the DnaStrand implementation.
    */
   public static void main(String[] args) throws FileNotFoundException {
      if (args.length < 2) {
         System.out.println("Usage: java DNASimulation inputfile implementation");
         System.exit(1);
      }
      String inputFile = args[0];
      String className = args[1];

      source = getDnaFromFile(new Scanner(new File(inputFile)));
      System.out.println("\nDNA length = " + source.length());
      System.out.println("Restiction enzyme = " + enzyme + "\n");

      // simulate a series of cut-and-splice operations on a dna strand
      // i is the power of two that sets the size of the splice
      for (int i = 8; i <= 32; i++) {
         // size = 2^i
         int size = (1 << i);
         // create a splice of length size that contains only c's
         StringBuilder splice = new StringBuilder();
         for (int j = 0; j < size; j++) {
            splice.append("c");
         }
         // time the specified implementation on cut-and-splice
         String results = getCutAndSpliceTime(enzyme, splice.toString(), className);
         System.out.println(results);
      }  
   }

   /**
    * Return a string representing the DNA read from the scanner, ignoring
    * any characters can't be part of DNA and converting all characters to
    * lower case.
    * @param input is the Scanner read from
    * @return a string representing the DNA read, characters in the returned
    *           string are restricted to 'c', 'g', 't', 'a'    
    */
   private static String getDnaFromFile(Scanner input) {
      StringBuilder sb = new StringBuilder();
      while (input.hasNextLine()) {
         String line = input.nextLine().toLowerCase();
         for (int i = 0; i < line.length(); i++) {
            char ch = line.charAt(i);
            if ("gatc".indexOf(ch) != -1) {
               sb.append(ch);
            }
         }
      }
      return sb.toString();
   }

   /**
    * Produces timing data for the cutAndSplice method.
    */
   private static String getCutAndSpliceTime(String enzyme, String splice, String className) {
      DnaStrand strand;
      try {
         strand = (DnaStrand) Class.forName(className).newInstance();
         strand.initializeFrom(source);
         double start = System.currentTimeMillis();
         DnaStrand recombDna = strand.cutAndSplice(enzyme, splice);
         double end = System.currentTimeMillis();
         double time = (end - start) / 1000d;
         long recombLength = recombDna.size();
         return String.format("%s:\t splice length\t %,20d \t time \t %1.3f recombinant length %,20d",
                        className,   splice.length(),           time,         recombLength);
      }
      catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
         return "Could not instantiate " + className;
      }
   }
}
