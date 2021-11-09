/**
 *
 */
public class OnlineBook extends OnlineTextItem {
   
   protected String author;

   /**
    *
    * @param nameIn takes in the name
    * @param priceIn takes in the price
    */
   public OnlineBook(String nameIn, double priceIn) {
      super(nameIn, priceIn);
      author = "Author Not Listed";
   }

   /**
    *
    * @return returns the name author and price
    */
   public String toString() {
      return name + " - " + author + ": $" + price;
   }

   /**
    *
    * @param nameIn sets the authors name
    */
   public void setAuthor(String nameIn) {
      author = nameIn;
   }
}