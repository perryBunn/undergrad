package request;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerTCP {
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

  private static boolean sendPacket(DatagramSocket sock, DatagramPacket p, byte[] header) {
    try {
      DatagramPacket outPacket = new DatagramPacket(header, header.length, p.getAddress(), p.getPort());
      sock.send(outPacket);
    } catch (Exception e) {
      return false;
    }
    return true;
  }

  public static void main(String args[]) throws Exception {

    if (args.length != 1)  // Test for correct # of args
      throw new IllegalArgumentException("Parameter(s): <Port>");

    int port = Integer.parseInt(args[0]);   // Receiving Port

    while (true) {
      byte err = 0;
      ServerSocket servSock = new ServerSocket(port);
      Socket clntSock = servSock.accept();

      // Receive binary-encoded friend
      RequestDecoderBin decoder = new RequestDecoderBin();
      Request receivedRequest = decoder.decode(clntSock.getInputStream());

      System.out.println("Received Binary-Encoded Request");
      System.out.println(receivedRequest + " ID:" + receivedRequest.ID);

      int res = polynomial(receivedRequest.X, receivedRequest.A3, receivedRequest.A2,
              receivedRequest.A1, receivedRequest.A0);
      System.out.println("Result: " + res);

      OutputStream out = clntSock.getOutputStream(); // Get a handle onto Output Stream
      Response response = new Response((short) (Math.random()*100), err, res);
      byte[] resultHeader = encodeAnswer(response);
      out.write(resultHeader);

      clntSock.close();
      servSock.close();
    }
  }
}
