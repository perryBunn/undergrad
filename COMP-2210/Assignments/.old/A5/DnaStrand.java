/**
 * Models the behavior of a (single) strand of DNA for the 
 * purposes of simulating the use of restriction enzymes in
 * forming recombinant DNA.
 *
 * This is adapted from an interface developed by Owen Astrachan.
 * 
 * @author   Dean Hendrix (dh@auburn.edu)
 * @version  2017-10-16
 *
 */
public interface DnaStrand {
   
   /**
    * Appends the parameter to this strand changing this strand to represent
    * the addition of new characters/base-pairs, e.g., changing this strand's
    * size.
    * 
    * If possible implementations should take advantage of optimizations
    * possible if the parameter is of the same type as the strand to which data
    * is appended.
    * 
    * @param dna is the strand being appended
    * @return this strand after the data has been added
    */
   DnaStrand append(DnaStrand dna);
   

   /**
    * Equivalent to append with a DnaStrand parameter in
    * functionality, but fewer optimizations are possible. Typically this
    * method will be called by the append method with an DNAStrand
    * parameter if the DnaStrand passed to that other append method isn't the same 
    * class as the strand being appended to.
    * 
    * @param dna is the string appended to this strand
    * @return this strand after the data has been added
    */
   DnaStrand append(String dna);


   /**
    * Cut this strand at every occurrence of enzyme, replacing
    * every occurrence of enzyme with splice.
    *
    * @param enzyme is the pattern/strand searched for and replaced
    * @param splice is the pattern/strand replacing each occurrence of enzyme
    * @return the new strand leaving the original strand unchanged.
    */
   DnaStrand cutAndSplice(String enzyme, String splice);


   /**
    * Simulate a restriction enzyme cut by finding the first occurrence of
    * enzyme in this strand and replacing this strand with what comes before
    * the enzyme while returning a new strand representing what comes after the
    * enzyme. If the enzyme isn't found, this strand is unaffected and an empty
    * strand with size equal to zero is returned.
    * 
    * @param enzyme is the string being searched for
    * @return the part of the strand that comes after the enzyme
    */
   DnaStrand cutWith(String enzyme);
   

   /**
    * Initialize by copying DNA data from the string into this strand,
    * replacing any data that was stored. The parameter should contain only
    * valid DNA characters, no error checking is done by the this method.
    * 
    * @param source is the string used to initialize this strand
    */
   void initializeFrom(String source);
   
   
   /**
    * Returns the number of elements/base-pairs/nucleotides in this strand.
    * @return the number of base-pairs in this strand
    */
   long size();

}
