import java.net.*;  // for Socket
import java.io.*;   // for IOException and Input/OutputStream

public class TCPEchoClient {

    static int MAX_RUN = 1000;

    public static void main(String[] args) throws IOException {

        if ((args.length < 2) || (args.length > 3))  // Test for correct # of args
            throw new IllegalArgumentException("Parameter(s): <Server> <Word> [<Port>]");

        String ip = args[0];       // Server name or IP address
        InetAddress server = InetAddress.getByName(ip);

        // Convert input String to bytes using the default character encoding
        byte[] byteBuffer = args[1].getBytes();

        int servPort = (args.length == 3) ? Integer.parseInt(args[2]) : 7;
        double totalTime = 0;
        double tripTime = 0;
        double maxTripTime = 0;
        double minTripTime = 100;
        long totalTimeLong = 0;
        // Create socket that is connected to server on specified port
        Socket socket = new Socket(server, servPort);
        System.out.println("Connected to server...sending echo string");
        for (int i = 0; i < MAX_RUN; i++) {
            InputStream in = socket.getInputStream();
            OutputStream out = socket.getOutputStream();

            double startTime = System.nanoTime();
            out.write(byteBuffer);  // Send the encoded string to the server

            // Receive the same string back from the server
            int totalBytesRcvd = 0;  // Total bytes received so far
            int bytesRcvd;           // Bytes received in last read
            while (totalBytesRcvd < byteBuffer.length) {
                if ((bytesRcvd = in.read(byteBuffer, totalBytesRcvd,
                        byteBuffer.length - totalBytesRcvd)) == -1)
                    throw new SocketException("Connection close prematurely");
                totalBytesRcvd += bytesRcvd;
            }

            double endTime = System.nanoTime();
            System.out.println("Received: " + new String(byteBuffer) + " " + endTime);
            totalTimeLong += endTime-startTime;
            tripTime = ((endTime/1000000) - (startTime/1000000));
            if (tripTime > maxTripTime) {
                maxTripTime = tripTime;
            }
            if ((tripTime < minTripTime) && (minTripTime != 0.0)) {
                minTripTime = tripTime;
            }
            totalTime += tripTime;
        }
        socket.close();  // Close the socket and its streams
        System.out.println("----------------------------------------");
        System.out.println("# of Runs: " + MAX_RUN);
        System.out.println("Total Time: " + totalTime + "ms | " + totalTimeLong + "ns");
        System.out.println("Max Trip Time: " + maxTripTime + "ms");
        System.out.println("Min Trip Time: " + minTripTime + "ms");
        System.out.println("Avg Time: " + totalTime/MAX_RUN + "ms");
    }
}
