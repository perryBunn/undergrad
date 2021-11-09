/**
 * A client for ProvidedClass.
 *
 * @author Dean Hendrix (dh@auburn.edu)
 * @version 2017-09-17
 */
public class ProvidedClient {

    // to convert from nanoseconds to seconds
    private static final double SECONDS = 1_000_000_000d;

    /** Drives execution. */
    public static void main(String[] args) {
        int numRuns = 20;
        int n = 2;
        ProvidedClass providedClass = new ProvidedClass(903656028);
        for (int i = 0; i < numRuns; i++) {
            long startTime = System.nanoTime();
            providedClass.methodToTime(n);
            long endTime = System.nanoTime();
            double elapsedTime = (endTime - startTime) / SECONDS;
            System.out.println("Problem size = " + n + " "
                + "Elapsed time = " + elapsedTime);
            n = n * 2;
        }
    }

}
