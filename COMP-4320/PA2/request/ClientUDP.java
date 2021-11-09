package request;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Arrays;


public class ClientUDP {

    private static void handleAnswer(DatagramPacket p) throws IOException {
        ByteArrayInputStream payload =
                new ByteArrayInputStream(p.getData(), p.getOffset(), p.getLength());
        DataInputStream src = new DataInputStream(payload);
        byte length = src.readByte();
        short id = src.readShort();
        byte errorCode = src.readByte();
        int answer = src.readInt();
        byte check = src.readByte();
        System.out.println("len: " + length);
        System.out.println("id: " + id);
        System.out.println("err: " + errorCode);
        System.out.println("ans: " + answer);
        System.out.println("sum: " + check);

        System.out.println("Answer for request ID number " + id + ": " + answer);

    }

    public static void main(String[] args) throws Exception {

        if (args.length != 2 && args.length != 3)  // Test for correct # of args
	    throw new IllegalArgumentException("Parameter(s): <Destination> <Port> [<encoding]");

        InetAddress destAddr = InetAddress.getByName(args[0]);  // Destination address
        int destPort = Integer.parseInt(args[1]);               // Destination port


        Request request = new Request((short) (Math.random()*100), 5, 1, 0, 6, 12);
      
        DatagramSocket sock = new DatagramSocket(); // UDP socket for sending

        // Use the encoding scheme given on the command line (args[2])
        RequestEncoder encoder = (args.length == 3 ?
				  new RequestEncoderBin(args[2]) :
				  new RequestEncoderBin());

        byte[] codedFriend = encoder.encode(request); // Encode request
      
        DatagramPacket message = new DatagramPacket(codedFriend, codedFriend.length,
						  destAddr, destPort);
        sock.send(message);

        DatagramPacket packet = new DatagramPacket(new byte[9],9);
        System.out.println("Awaiting operation");
        sock.receive(packet);

        handleAnswer(packet);

        sock.close();
  }
}
