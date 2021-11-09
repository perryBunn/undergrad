/**
 * @author Perry Bunn
 * @version 4/24/17
 */
public class InvalidCategoryException extends Exception {
   /**
    *
    * @param category takes in the invalid category
    */
   public InvalidCategoryException(String category) {
      super("For category: " + "\"" + category + "\"");
   }
}