import java.net.*;  // for DatagramSocket, DatagramPacket, and InetAddress
import java.io.*;   // for IOException

public class SendUDP {

  public static void main(String args[]) throws Exception {

      if (args.length != 2 && args.length != 3)  // Test for correct # of args        
	  throw new IllegalArgumentException("Parameter(s): <Destination>" +
					     " <Port> [<encoding]");
      
      
      InetAddress destAddr = InetAddress.getByName(args[0]);  // Destination address
      int destPort = Integer.parseInt(args[1]);               // Destination port
      
      Friend friend = new Friend(1234567890987654L, "Alice Adams",
				 (short) 777, 90007, true, true, false);
      
      DatagramSocket sock = new DatagramSocket(); // UDP socket for sending
      
      
      // Use the encoding scheme given on the command line (args[2])
      FriendEncoder encoder = (args.length == 3 ?
				  new FriendEncoderBin(args[2]) :
				  new FriendEncoderBin());
      

      byte[] codedFriend = encoder.encode(friend); // Encode friend
      
      DatagramPacket message = new DatagramPacket(codedFriend, codedFriend.length, 
						  destAddr, destPort);
      sock.send(message);
      
      sock.close();
  }
}
