import java.io.*;   // for Input/OutputStream
import java.net.*;  // for Socket and ServerSocket

public class RecvTCP {

  public static void main(String args[]) throws Exception {

    if (args.length != 1)  // Test for correct # of args
      throw new IllegalArgumentException("Parameter(s): <Port>");

    int port = Integer.parseInt(args[0]);   // Receiving Port
    while (true) {
      ServerSocket servSock = new ServerSocket(port);
      Socket clntSock = servSock.accept();

      // Receive binary-encoded friend
      FriendDecoder decoder = new FriendDecoderBin();
      Friend receivedFriend = decoder.decode(clntSock.getInputStream());

      System.out.println("Received Binary-Encoded Friend");
      System.out.println(receivedFriend);

      clntSock.close();
      servSock.close();
    }
  }
}
