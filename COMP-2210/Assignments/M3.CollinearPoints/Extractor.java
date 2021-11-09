import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Extractor.java. Implements feature extraction for collinear points in
 * two dimensional data.
 *
 * @author Perry Bunn (ptb0010@auburn.edu)
 * @author Dean Hendrix (dh@auburn.edu)
 * @version TODAY
 */
public class Extractor {

   /**
    * raw data: all (x,y) points from source data.
    */
   private Point[] points;

   /**
    * lines identified from raw data.
    */
   private SortedSet<Line> lines;

   /**
    * Builds an extractor based on the points in the file named by filename.
    */
   public Extractor(String filename) {
      try {
         Scanner scan = new Scanner(new File(filename));

         while (scan.hasNext()) {
            int numLines = scan.nextInt();
            for (int i = 0; i < numLines; i++) {
               points[i] = new Point(scan.nextInt(), scan.nextInt());
            }
            if (!scan.hasNext()) {
               break;
            }

         }
      } catch (FileNotFoundException e) {
         e.printStackTrace();
      }
   }

   /**
    * Builds an extractor based on the points in the Collection named by pcoll.
    * <p>
    * THIS METHOD IS PROVIDED FOR YOU AND MUST NOT BE CHANGED.
    */
   public Extractor(Collection<Point> pcoll) {
      points = pcoll.toArray(new Point[]{});
   }

   /**
    * Returns a sorted set of all line segments of exactly four collinear
    * points. Uses a brute-force combinatorial strategy. Returns an empty set
    * if there are no qualifying line segments.
    */
   public SortedSet<Line> getLinesBrute() {
      lines = new TreeSet<Line>();
      if (points.length > 3) {
         for (int i = 3; i < points.length; i++) {
            for (int j = 2; j < i; j++) {
               for (int k = 1; k < j; k++) {
                  for (int l = 0; l < k; l++) {

                     double slo1 = points[i].slopeTo(points[j]);
                     double slo2 = points[i].slopeTo(points[k]);
                     double slo3 = points[i].slopeTo(points[l]);

                     if (slo1 == slo2 && slo1 == slo3) {
                        Line line = new Line();

                        line.add(points[i]);
                        line.add(points[j]);
                        line.add(points[k]);
                        line.add(points[l]);

                        lines.add(line);
                     }
                  }
               }
            }
         }
      }
      return lines;
   }

   /**
    * Returns a sorted set of all line segments of at least four collinear
    * points. The line segments are maximal; that is, no sub-segments are
    * identified separately. A sort-and-scan strategy is used. Returns an empty
    * set if there are no qualifying line segments.
    */
   public SortedSet<Line> getLinesFast() {
      lines = new TreeSet<Line>();
      Point[] copy = Arrays.copyOf(points, points.length);
      for (Point point : points) {
         Arrays.sort(copy, point.slopeOrder);
         int same = 0;
         for (int j = 0; j < copy.length - 1; j = j + same) {
            same = 0;
            int k = 0;
            while (j + k < copy.length && point.slopeOrder.compare(copy[j], copy[j + k]) == 0) {
               k++;
               same++;
            }
            if (same > 2) {
               Line line = new Line();
               line.add(point);
               for (int l = 0; l < same; l++) {
                  line.add(copy[j + l]);
               }
               lines.add(line);
            }
         }
      }
      return lines;
   }

}
