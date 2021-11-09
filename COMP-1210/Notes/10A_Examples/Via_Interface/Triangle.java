public class Triangle implements TwoDShape
{
   private double s1; 
   private double s2; 
   private double s3;  
   
   private static final int NUM_SIDES = 3;

   public Triangle(double side1, double side2, double side3) 
   {
      s1 = side1;
      s2 = side2;    
      s3 = side3;  
   }

   public String getClassification() {  
      String result = "isosceles";  
      
      if (s1 <= 0 || s2 <= 0 ||  s3 <= 0) {
         result = "not a triangle";
      }
      else if ((s1 >= s2 + s3) || (s2 >= s1 + s3) || (s3 >= s1 + s2)) {
         result = "not a triangle";
      }
      else if ((s1 == s2) && (s2 == s3)) {  
         result = "equilateral";   
      } 
      else if ((s1 != s2) && (s1 != s3) && (s2 != s3)) { 
         result = "scalene";
      } 
       
      return result; 
   } 
   
   public int getNumberSides() {
      return NUM_SIDES;
   }
   
   public double getPerimeter() {
      return s1 + s2 + s3;
   }

   public String toString() {  
      String output = "Triangle Information:\n"
         + "Side 1 = " + s1 + " units.\n"
         + "Side 2 = " + s2 + " units.\n"
         + "Side 3 = " + s3 + " units.\n"
         + "The triangle is " + getClassification() + ".";
       
      return output; 
   } 
}
