public class PrintShapes {

   public static void main(String[] args) {
      TwoDShape shape1, shape2;
      shape1 = new Triangle(12, 24, 35);
      System.out.println(shape1);
      System.out.println("\nPerimeter: " 
         + shape1.getPerimeter() + "\n\n");
         
      shape2 = new Rectangle(12, 24);
      System.out.println(shape2);
      System.out.println("Perimeter: " 
         + shape2.getPerimeter());
   }
}
