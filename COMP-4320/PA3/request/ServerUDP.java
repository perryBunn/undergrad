package request;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;


public class ServerUDP {
    private static int polynomial(int x, int a3, int a2, int a1, int a0) {
        int result = 0;
        result += a3 * (int) Math.pow(x, 3);
        result += a2 * (int) Math.pow(x, 2);
        result += a1 * (int) Math.pow(x, 1);
        result += a0;
        return result;
    }

    public static byte[] encodeAnswer(Response ans) throws IOException {
        ByteArrayOutputStream buf = new ByteArrayOutputStream();
        DataOutputStream out = new DataOutputStream(buf);
        out.writeByte(ans.len);
        out.writeShort(ans.ID);
        out.writeByte(ans.err);
        out.writeInt(ans.result);
        out.writeByte(ans.checksum);

        out.flush();
        return buf.toByteArray();
    }

    private static boolean sendPacket(DatagramSocket sock, DatagramPacket p,  byte[] header) {
        try {
            DatagramPacket outPacket = new DatagramPacket(header, header.length, p.getAddress(), p.getPort());
            sock.send(outPacket);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) throws Exception {

      if (args.length != 1 && args.length != 2)  // Test for correct # of args        
	  throw new IllegalArgumentException("Parameter(s): <Port> [<encoding>]");
      
      int port = Integer.parseInt(args[0]);   // Receiving Port
      while (true) {
          byte err = 0;
          DatagramSocket sock = new DatagramSocket(port);  // UDP socket for receiving
          DatagramPacket packet = new DatagramPacket(new byte[1024], 1024);
          sock.receive(packet);

          System.out.println("Received Binary-Encoded Request");

          // Receive binary-encoded friend
          // FriendDecoder decoder = new FriendDecoderBin();
          Request receivedRequest = null;
          try {
              RequestDecoder decoder = (args.length == 2 ?   // Which encoding
                      new RequestDecoderBin(args[1]) :
                      new RequestDecoderBin());
              receivedRequest = decoder.decode(packet);
          } catch (IOException e) {
              err = 63;
          }
          int res = polynomial(receivedRequest.X, receivedRequest.A3, receivedRequest.A2,
                               receivedRequest.A1, receivedRequest.A0);
          System.out.println("Result: " + res);

          if (receivedRequest.len != 9) {
              err = 127;
          }

          Response response = new Response((short) (Math.random()*100), err, res);
          byte[] resultHeader = encodeAnswer(response);
          boolean stat = sendPacket(sock, packet, resultHeader);
          if (stat) {
              System.out.println("Sending Success.");
          } else {
              System.out.println("Sending failed.");
          }
          sock.close();
      }
  }

}
