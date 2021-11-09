import java.util.Objects;

/**
* LinkedStrand.java
* Provides a linked chunk list implementation of the DnaStrand interface.
* 
* @author   Perry Bunn (ptb0010@auburn.edu)
* @author   Dean Hendrix (dh@auburn.edu)
* @version  2017-10-17
* @version  0.1.8
*
*/
public class LinkedStrand implements DnaStrand {

   /**
    * Container for storing DNA information. A given DNA strand is
    * represented by a chain of nodes.
    *
    * D O   N O T   M A K E   A N Y   C H A N G E S   T O
    *
    * T H E   N O D E   C L A S S 
    *
    */
   class Node {
      String dnaInfo;
      Node next;

      public Node() {
         dnaInfo = "";
         next = null;
      }

      public Node(String s, Node n) {
         dnaInfo = s;
         next = n;
      }
   }

   /** An empty strand. */
   public static final LinkedStrand EMPTY_STRAND = new LinkedStrand();

   /** The first and last node in this LinkedStrand. */
   // D O   N O T   C H A N G E   T H E S E   F I E L D S 
   Node front;
   Node rear;


   /** The number of nucleotides in this strand. */
   long size;

   /**
    * Create a strand representing an empty DNA strand, length of zero.
    *
    * D O   N O T   C H A N G E   T H I S   C O N S T R U C T O R
    */
   public LinkedStrand() {
      front = null;
      rear = null;
      size = 0;
   }


   /**
    * Create a strand representing s. No error checking is done to see if s represents
    * valid genomic/DNA data.
    *
    * @param s is the source of cgat data for this strand
    */
   public LinkedStrand(String s) {
      // YOU MUST COMPLETE THIS METHOD
      front = rear = new Node(s, null);
      size = s.length();
   }


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
   @Override
   public DnaStrand append(DnaStrand dna) {
      // YOU MUST COMPLETE THIS METHOD
      if (dna == null || dna.size() == 0) {
         return this;
      }
      if (this.size() == 0) {
         LinkedStrand strand = new LinkedStrand(dna.toString());
         this.front = strand.front;
         this.rear = strand.rear;
         size = strand.size();
         return strand;
      }
      if (dna instanceof LinkedStrand) {
         LinkedStrand strand = (LinkedStrand) dna;
         rear.next = strand.front;
         rear = strand.rear;
         size += strand.size();
         return this;
      } else {
         return append(dna.toString());
      }
   }


   /**
    * Similar to append with a DnaStrand parameter in
    * functionality, but fewer optimizations are possible. Typically this
    * method will be called by the append method with an DNAStrand
    * parameter if the DnaStrand passed to that other append method isn't the same 
    * class as the strand being appended to.
    * 
    * @param dna is the string appended to this strand
    * @return this strand after the data has been added
    */
   @Override
   public DnaStrand append(String dna) {
      // YOU MUST COMPLETE THIS METHOD
      if (dna == null || dna.length() == 0) {
         return this;
      }
      if (this.size() == 0) {
         LinkedStrand strand = new LinkedStrand(dna);
         front = strand.front;
         rear = strand.rear;
         size = strand.size();
         return strand;
      }
      Node n = new Node(dna, null);
      rear.next = n;
      rear = n;
      size += dna.length();
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
      // YOU MUST COMPLETE THIS METHOD
      if (front != rear) {
         throw new IllegalStateException("Multiple nodes in initial DNA strand!");
      }
      LinkedStrand strand = new LinkedStrand(front.dnaInfo);
      int index;
      boolean spliced = false;
      Node node = strand.front;
      while (node.dnaInfo.contains(enzyme)) {
         index = node.dnaInfo.indexOf(enzyme);
         if (index == 0) {
            node.next = new Node(node.dnaInfo.substring(index + enzyme.length()), null);
            node.dnaInfo = splice;
            if (node.next.dnaInfo.length() == 0) {
               node.next = null;
            } else {
               node = node.next;
            }
            strand.size = strand.size - enzyme.length() + splice.length();
         } else {
            node.next = new Node(node.dnaInfo.substring(index), null);
            node.dnaInfo = node.dnaInfo.substring(0, index);
            node = node.next;
         }
         spliced = true;
      }
      strand.rear = node;
      if (!spliced) {
         return EMPTY_STRAND;
      }
      return strand;
   }



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
   @Override
   public DnaStrand cutWith(String enzyme) {
      // YOU MUST COMPLETE THIS METHOD
     if (front != rear) {
        throw new IllegalStateException();
     }
     if (Objects.equals(enzyme, front.dnaInfo)) {
        initializeFrom("");
        return EMPTY_STRAND;
     }
     int index = front.dnaInfo.indexOf(enzyme);
     if (index == -1){
        return EMPTY_STRAND;
     }
     if (index + enzyme.length() == front.dnaInfo.length()) {
        initializeFrom(front.dnaInfo.substring(0,index));
        return EMPTY_STRAND;
     }
     DnaStrand strand = new LinkedStrand(front.dnaInfo.substring(index + enzyme.length()));
     initializeFrom(front.dnaInfo.substring(0, index));
     return strand;
   }


   /**
    * Initialize by copying DNA data from the string into this strand,
    * replacing any data that was stored. The parameter should contain only
    * valid DNA characters, no error checking is done by the this method.
    * 
    * @param source is the string used to initialize this strand
    */
   @Override
   public void initializeFrom(String source) {
      // YOU MUST COMPLETE THIS METHOD
      Node n = new Node(source, null);
      if (source.length() == 0) {
         front = null;
         rear = null;
         size = 0;
      } else {
         front = n;
         rear = n;
         size = source.length();
      }
   }


   /**
    * Returns the number of elements/base-pairs/nucleotides in this strand.
    * @return the number of base-pairs in this strand
    */
   @Override
   public long size() {
      // YOU MUST COMPLETE THIS METHOD
      return size;
   }

   /**
    * Returns a string representation of this LinkedStrand.
    */
   @Override
   public String toString() {
      // YOU MUST COMPLETE THIS METHOD
      Node n = front;
      String string = "";
      if (n == null) {
         return "";
      }
      while (n != null) {
         string += n.dnaInfo;
         n = n.next;
      }
      return string;
   }

}

