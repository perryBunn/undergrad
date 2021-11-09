import java.net.*;  // for DatagramSocket, DatagramPacket, and InetAddress
import java.io.*;   // for IOException
import java.util.Arrays;

public class UDPEchoServer {

    private static final int ECHOMAX = 255;  // Maximum size of echo datagram

    public static void main(String[] args) throws IOException {

        if (args.length != 1)  // Test for correct argument list
            throw new IllegalArgumentException("Parameter(s): <Port>");

        int servPort = Integer.parseInt(args[0]);

        DatagramSocket socket = new DatagramSocket(servPort);
        DatagramPacket inPacket = new DatagramPacket(new byte[ECHOMAX], ECHOMAX);
        DatagramPacket outPacket = new DatagramPacket(new byte[ECHOMAX], ECHOMAX);
        boolean lowerCond;
        boolean upperCond;
        int i = 0;

        for (;;) {  // Run forever, receiving and echoing datagrams
            socket.receive(inPacket);     // Receive packet from client
            System.out.println("Handling client at " +
                    inPacket.getAddress().getHostAddress() + " on port " + inPacket.getPort());
            byte[] buf = inPacket.getData();
            byte[] devowelized = new byte[ECHOMAX];
            for (byte c : buf) {
                lowerCond = (char) c == 'a' || (char) c == 'e' || (char) c == 'i' || (char) c == 'o' || (char) c == 'u';
                upperCond = (char) c == 'A' || (char) c == 'E' || (char) c == 'I' || (char) c == 'O' || (char) c == 'U';
                if (!lowerCond && !upperCond) {
                    devowelized[i] = c;
                    i++;
                }
            }
            i = 0;
            outPacket.setData(devowelized, 0, ECHOMAX);
            outPacket.setAddress(inPacket.getAddress());
            outPacket.setPort(inPacket.getPort());
            socket.send(outPacket);       // Send the same packet back to client
            inPacket.setLength(ECHOMAX); // Reset length to avoid shrinking buffer
            outPacket.setLength(ECHOMAX);
        }
        /* NOT REACHED */
    }
}
