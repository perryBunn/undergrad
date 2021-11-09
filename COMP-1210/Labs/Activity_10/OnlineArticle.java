/**
 *
 */
public class OnlineArticle extends OnlineTextItem {
   
   private int wordCount;

   /**
    *
    * @param nameIn takes in the name
    * @param priceIn takes in the price
    */
   public OnlineArticle(String nameIn, double priceIn) {
      super(nameIn, priceIn);
      wordCount = 0;
   }

   /**
    *
    * @param wordsIn sets teh amount of words
    */
   public void setWordCount(int wordsIn) {
      wordCount = wordsIn;
   }
}