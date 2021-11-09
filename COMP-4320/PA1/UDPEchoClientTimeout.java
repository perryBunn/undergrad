import java.net.*;  // for DatagramSocket, DatagramPacket, and InetAddress
import java.io.*;   // for IOException

public class UDPEchoClientTimeout {

    private static final int TIMEOUT = 3000;   // Resend timeout (milliseconds)
    private static final int MAXTRIES = 5;     // Maximum retransmissions
    static int MAX_RUN = 1000;

    public static void main(String[] args) throws IOException {

        if ((args.length < 2) || (args.length > 3))  // Test for correct # of args
            throw new IllegalArgumentException("Parameter(s): <Server> <Word> [<Port>]");

        InetAddress serverAddress = InetAddress.getByName(args[0]);  // Server address
        // Convert input String to bytes using the default character encoding
        byte[] bytesToSend = args[1].getBytes();

        int servPort = (args.length == 3) ? Integer.parseInt(args[2]) : 7;

        double totalTime = 0;
        double tripTime = 0;
        double maxTripTime = 0;
        double minTripTime = 100;
        long totalTimeLong = 0;


        DatagramSocket socket = new DatagramSocket();

        socket.setSoTimeout(TIMEOUT);  // Maximum receive blocking time (milliseconds)

        for (int i = 0; i < MAX_RUN; i++) {
            DatagramPacket sendPacket = new DatagramPacket(bytesToSend,  // Sending packet
                    bytesToSend.length, serverAddress, servPort);
            DatagramPacket receivePacket =                              // Receiving packet
                    new DatagramPacket(new byte[bytesToSend.length], bytesToSend.length);

            int tries = 0;      // Packets may be lost, so we have to keep trying
            boolean receivedResponse = false;
            double endTime = 0;
            double startTime = 0;
            do {
                socket.send(sendPacket);          // Send the echo string
                try {
                    startTime = System.nanoTime();
                    socket.receive(receivePacket);  // Attempt echo reply reception

                    if (!receivePacket.getAddress().equals(serverAddress))  // Check source
                        throw new IOException("Received packet from an unknown source");

                    receivedResponse = true;
                    endTime = System.nanoTime();
                } catch (InterruptedIOException e) {  // We did not get anything
                    tries += 1;
                    System.out.println("Timed out, " + (MAXTRIES - tries) + " more tries...");
                }
                totalTimeLong += endTime - startTime;
                tripTime = ((endTime / 1000000) - (startTime / 1000000));
                if (tripTime > maxTripTime) {
                    maxTripTime = tripTime;
                }
                if ((tripTime < minTripTime) && (minTripTime != 0.0)) {
                    minTripTime = tripTime;
                }
                totalTime += tripTime;
            } while ((!receivedResponse) && (tries < MAXTRIES));

            if (receivedResponse)
                System.out.println("Received: " + new String(receivePacket.getData()) + " " + endTime);
            else
                System.out.println("No response -- giving up.");
        }
        socket.close();
        System.out.println("----------------------------------------");
        System.out.println("# of Runs: " + MAX_RUN);
        System.out.println("Total Time: " + totalTime + "ms | " + totalTimeLong + "ns");
        System.out.println("Max Trip Time: " + maxTripTime + "ms");
        System.out.println("Min Trip Time: " + minTripTime + "ms");
        System.out.println("Avg Time: " + totalTime/MAX_RUN + "ms");
    }
}
