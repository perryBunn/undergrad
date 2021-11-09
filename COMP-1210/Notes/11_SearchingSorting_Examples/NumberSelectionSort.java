public class NumberSelectionSort
{
   public static void main(String[] args)
   {
      Integer[] ia = {3, 9, 6, 1, 2};
      Sorting.selectionSort(ia);
      for (Integer i : ia) {
         System.out.println(i);
      }
   }
}