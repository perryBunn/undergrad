import java.net.*;  // for Socket, ServerSocket, and InetAddress
import java.io.*;   // for IOException and Input/OutputStream

public class TCPEchoServer {

    private static final int BUFSIZE = 32;   // Size of receive buffer

    public static void main(String[] args) throws IOException {

        if (args.length != 1)  // Test for correct # of args
            throw new IllegalArgumentException("Parameter(s): <Port>");

        int servPort = Integer.parseInt(args[0]);

        // Create a server socket to accept client connection requests
        ServerSocket servSock = new ServerSocket(servPort);

        int recvMsgSize;   // Size of received message
        byte[] byteBuffer = new byte[BUFSIZE];  // Receive buffer
        byte[] devowelized = new byte[BUFSIZE];
        int i = 0;
        for (;;) { // Run forever, accepting and servicing connections
            Socket clntSock = servSock.accept();     // Get client connection

            System.out.println("Handling client at " +
                    clntSock.getInetAddress().getHostAddress() + " on port " +
                    clntSock.getPort());

            InputStream in = clntSock.getInputStream();
            OutputStream out = clntSock.getOutputStream();
            boolean lowerCond;
            boolean upperCond;
            // Receive until client closes connection, indicated by -1 return
            while ((recvMsgSize = in.read(byteBuffer)) != -1) {
                for (byte l : byteBuffer) {
                    lowerCond = (char) l == 'a' || (char) l == 'e' || (char) l == 'i' || (char) l == 'o' || (char) l == 'u';
                    upperCond = (char) l == 'A' || (char) l == 'E' || (char) l == 'I' || (char) l == 'O' || (char) l == 'U';
                    if (!lowerCond && !upperCond) {
                        devowelized[i] = l;
                        i++;
                    }
                }
                out.write(devowelized, 0, recvMsgSize);
                i = 0;
            }

            clntSock.close();  // Close the socket.  We are done with this client!
        }
        /* NOT REACHED */
    }
}
