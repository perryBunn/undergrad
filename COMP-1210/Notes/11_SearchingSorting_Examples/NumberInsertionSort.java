public class NumberInsertionSort
{
   public static void main(String[] args)
   {
      Integer[] ia = {3, 9, 6, 1, 2};
      Sorting.insertionSort(ia);
      for (Integer i : ia) {
         System.out.println(i);
      }
   }
}