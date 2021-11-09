public class InvalidLengthException extends Exception 
   //extends RuntimeException 
{
   public InvalidLengthException(double invalidSide) {
      super("Invalid length for side: " + invalidSide + ". "
         + "A valid length must be greater than 0.");
   }

}