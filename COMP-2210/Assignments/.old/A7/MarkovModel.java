import java.io.File;
import java.util.HashMap;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

/**
 * MarkovModel.java Creates an order K Markov model of the supplied source
 * text. The value of K determines the size of the "kgrams" used to generate
 * the model. A kgram is a sequence of k consecutive characters in the source
 * text.
 *
 * @author     Perry Bunn (ptb0010@auburn.edu)
 * @author     Dean Hendrix (dh@auburn.edu)
 * @version    2017-11-28
 *
 */
public class MarkovModel {

   // Map of <kgram, chars following> pairs that stores the Markov model.
   private HashMap<String, String> model;

   // add other fields as you need them ...
   private String kGram;

   /**
    * Reads the contents of the file sourceText into a string, then calls
    * buildModel to construct the order K model.
    *
    * DO NOT CHANGE THIS CONSTRUCTOR.
    *
    */
   public MarkovModel(int K, File sourceText) {
      model = new HashMap<>();
      try {
         String text = new Scanner(sourceText).useDelimiter("\\Z").next();
         buildModel(K, text);
      }
      catch (IOException e) {
         System.out.println("Error loading source text: " + e);
      }
   }


   /**
    * Calls buildModel to construct the order K model of the string sourceText.
    *
    * DO NOT CHANGE THIS CONSTRUCTOR.
    *
    */
   public MarkovModel(int K, String sourceText) {
      model = new HashMap<>();
      buildModel(K, sourceText);
   }


   /**
    * Builds an order K Markov model of the string sourceText.
    */
   private void buildModel(int K, String sourceText) {
      int i = 0;
      int j = 0;
      kGram = sourceText.substring(0 , K);
      while (i + K <= sourceText.length()) {
         String empt = "";
         String kg = sourceText.substring (i, i + K);
         if (!model.containsKey(kg)) {
            while (j + K < sourceText.length()) {
               String g = sourceText.substring (j, j + K);
               if (j + K >= sourceText.length()) {
                  empt += '\u0000';
               }
               if (kg.equals(g)) {
                  empt += sourceText.substring(j + K, j + K + 1);
               }
               j++;
            }
            model.put(kg, empt);
         }
         j = 0;
         i++;
      }
   }


   /** Returns the first kgram found in the source text. */
   public String getFirstKgram() {
      return kGram;
   }


   /** Returns a kgram chosen at random from the source text. */
   public String getRandomKgram() {
      int i = model.size();
      int j = 0;
      Random random = new Random();
      int index = random.nextInt(i);
      for (String s : model.keySet()) {
         if (index == j) {
            return s;
         }
         j++;
      }
      return null;
   }


   /**
    * Returns the set of kgrams in the source text.
    *
    * DO NOT CHANGE THIS METHOD.
    *
    */
    public Set<String> getAllKgrams() {
      return model.keySet();
   }


   /**
    * Returns a single character that follows the given kgram in the source
    * text. This method selects the character according to the probability
    * distribution of all characters that follow the given kgram in the source
    * text.
    */
   public char getNextChar(String kgram) {
      Random random = new Random();
      String empty = "";
      int i = 0;
      for(String s: model.keySet()) {
         if (s.equals(kgram)) {
            empty = model.get(kgram);
            int j = empty.length();
            if (j > 0) {
               i = random.nextInt(j) + 1;
            }
         }
      }
      int k = i - 1;
      if (!empty.equals("")) {
         return empty.charAt(k);
      }
      return '\u0000';
   }


   /**
    * Returns a string representation of the model.
    * This is not part of the provided shell for the assignment.
    *
    * DO NOT CHANGE THIS METHOD.
    *
    */
    @Override
    public String toString() {
      return model.toString();
   }

}
