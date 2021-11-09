/**
 * Simple but inefficient implementation of DnaStrand. This implementation uses
 * Strings to represent genomic/DNA data. A StringBuilder is used where
 * appropriate for concatenation efficency.
 *
 * This is based on a class developed by Owen Astrachan.
 *
 * @author    Dean Hendrix (dh@auburn.edu)
 * @version   2017-10-16
 *
 */

public class ArrayStrand implements DnaStrand {

   /** An empty strand. */
   public static final ArrayStrand EMPTY_STRAND = new ArrayStrand();
   
   /** The sequence of protein bases that make up this strand. */
   private String dnaInfo;


   /**
    * Create a strand representing an empty DNA strand, length of zero.
    */
   public ArrayStrand() {
      this("");
   }


   /**
    * Create a strand representing s. No error checking is done to see if s represents
    * valid genomic/DNA data.
    *
    * @param s is the source of cgat data for this strand
    */
   public ArrayStrand(String s) {
      dnaInfo = s;
   }


   /**
    * Append a strand of DNA to this strand. If the strand being appended
    * is represented by a ArrayStrand object then an efficient append is
    * performed, otherwise the append is inefficient (even though it doesn't have to be).
    *
    * @param dna is the strand being appended
    */
   @Override
   public DnaStrand append(DnaStrand dna) {
      if (dna instanceof ArrayStrand) {
         ArrayStrand strand = (ArrayStrand) dna;
         dnaInfo = dnaInfo + strand.dnaInfo;
         return this;
      }  else {
         return append(dna.toString());
      }
   }


   /**
    * Simply append a strand of dna data to this strand. No error checking is done, this
    * method isn't efficient, it doesn't use a StringBuilder or a StringBuffer
    *
    * @param dna is the String appended to this strand
    */
   @Override
   public DnaStrand append(String dna) {
      dnaInfo += dna;
      return this;
   }


   /**
    * Cut this strand at every occurrence of enzyme, replacing
    * every occurrence of enzyme with splice.
    *
    * @param enzyme is the pattern/strand searched for and replaced
    * @param splice is the pattern/strand replacing each occurrence of enzyme
    * @return the new strand leaving the original strand unchanged.
    */
   @Override
   public DnaStrand cutAndSplice(String enzyme, String splice) {
      String toSplit = " " + dnaInfo + " ";
      String[] all = toSplit.split(enzyme);
      if (all[0].trim().equals(dnaInfo)) {
         return EMPTY_STRAND;
      }
      StringBuilder recombined = new StringBuilder(all[0]);
      for (int k = 1; k < all.length; k++) {
         recombined.append(splice);
         recombined.append(all[k]);
      }
      return new ArrayStrand(recombined.toString().trim());
   }


   /**
    * Perform a cut with the enzyme as the source of the location for the cut. The strand
    * before the enzyme-cut becomes this strand (if no enzyme found, no cut is made). The strand
    * after the enzyme-cut is returned as a newly created Strand by this method. The first
    * occurrence of enzyme is the source of the cut being made by this method.
    * 
    * @param enzyme is the enzyme/genome at which a cut is made.
    */
   @Override
   public DnaStrand cutWith(String enzyme) {
      int pos = dnaInfo.indexOf(enzyme);
      if (pos == -1) {
         return EMPTY_STRAND;
      }
   
      // found occurrence of enzyme, cleave, and replace
      DnaStrand ret = new ArrayStrand(dnaInfo.substring(pos + enzyme.length()));
      initializeFrom(dnaInfo.substring(0, pos));
      return ret;
   }
 

   /**
    * Initialize this strand so that it represents source, no error
    * checking is done.
    *
    * @param source is the source of this enzyme
    */
   @Override
   public void initializeFrom(String source) {
      dnaInfo = source;
   }


   /**
    * Returns the number of nucleotides/base-pairs in this strand.
    *
    * @return the number of base-pairs in this DnaStrand
    */
   @Override
   public long size() {
      return dnaInfo.length();
   }


   /**
    * Return the information in this strand as a string.
    *
    * @return a string representation of this strand
    */
   @Override
    public String toString() {
      return dnaInfo;
   }

}
