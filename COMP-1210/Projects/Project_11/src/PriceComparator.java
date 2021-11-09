import java.util.Comparator;

/**
 * @author Perry Bunn
 * @version 4/12/2017
 */

public class PriceComparator implements Comparator<BakedItem> {

   @Override
   public int compare(BakedItem b1, BakedItem b2) {
      if (b1.price() == b2.price()) {
         return 0;
      } else if (b1.price() > b2.price()) {
         return 1;
      } else {
         return -1;
      }
   }
}
