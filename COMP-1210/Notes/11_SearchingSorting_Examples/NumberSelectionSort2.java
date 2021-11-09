public class NumberSelectionSort2
{
   public static void main(String[] args)
   {
      Double[] ia = new Double[20];
      for (int i = 0; i < 20; i++)
      {
         ia[i] = (double) (Math.random() * 20 - 10);
      }
      //Integer[] ia = {3, 9, 6, 1, 2};
      Sorting.selectionSort(ia);
      for (Double i : ia) {
         System.out.println(i);
      }
   }
}