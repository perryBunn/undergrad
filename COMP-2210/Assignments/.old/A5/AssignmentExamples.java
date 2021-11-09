/**
 * Generates the DnaStrand examples in the assignment handout.
 *
 * @author   Dean Hendrix (dh@auburn.edu)
 * @version  2017-10-17
 *
 */
public class AssignmentExamples {

   /** Drives execution. */
   public static void main(String[] args) {

      System.out.println();
      System.out.println("DnaStrand method cutWith()");
      System.out.println("==========================");
      DnaStrand dna = new LinkedStrand("GAATTC");
      String enzyme = "GAATTC";
      System.out.println("Before: " + dna);
      DnaStrand ret = dna.cutWith(enzyme);
      System.out.println("After:  " + dna);
      System.out.println("Return: " + ret);
      dna = new LinkedStrand("AAAAAAGAATTC");
      enzyme = "GAATTC";
      System.out.println("Before: " + dna);
      ret = dna.cutWith(enzyme);
      System.out.println("After:  " + dna);
      System.out.println("Return: " + ret);
      
      System.out.println();   
      System.out.println("DnaStrand method cutAndSplice()");
      System.out.println("===============================");
      dna = new ArrayStrand("AGTCGAATTCAAGTCGAATTCAGTCA");
      enzyme = "GAATTC";
      String splice = "XXYY";
      System.out.println("Before: " + dna);
      ret = dna.cutAndSplice(enzyme, splice);
      System.out.println("After:  " + dna);
      System.out.println("Return: " + ret);

      System.out.println("===============================");
      System.out.println("User Test");
      System.out.println("-------------------------------");
      DnaStrand dnaTwo = new LinkedStrand("");
      System.out.println("Before: " + dnaTwo);
      dnaTwo.initializeFrom("aggtccg");
      System.out.println("After: " + dnaTwo);
      DnaStrand dnaThree = new LinkedStrand("");
      System.out.println("Before: " + dnaThree);
      dnaThree.initializeFrom("");
      System.out.println("After: " + dnaThree);
      System.out.println("===============================");


      System.out.println();
   }
}
