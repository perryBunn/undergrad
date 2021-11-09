package request;

import java.io.*;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.util.Scanner;

public class ClientTCP {

  private static void printHexResponse(Response res) throws IOException {
    byte[] bytes = new byte[9];
    bytes[0] = res.len;
    bytes[1] = (byte)(res.ID & 0xff);
    bytes[2] = (byte)((res.ID >> 8) & 0xff);
    bytes[3] = res.err;
    byte[] ret1 = new byte[4];
    ret1 = ByteBuffer.allocate(4).putInt(res.result).array();
    bytes[4] = ret1[0];
    bytes[5] = ret1[1];
    bytes[6] = ret1[2];
    bytes[7] = ret1[3];
    bytes[8] = res.checksum;
    StringBuilder sb = new StringBuilder();
    for (byte b : bytes) {
      sb.append(String.format("%02X ", b));
    }
    System.out.println("Response Hex: " + sb.toString());
  }
  private static void printHexRequest(Request req) throws IOException {
    byte[] bytes = new byte[9];
    bytes[0] = req.len;
    bytes[1] = (byte)(req.ID & 0xff);
    bytes[2] = (byte)((req.ID >> 8) & 0xff);
    bytes[3] = (byte)req.X;
    bytes[4] = (byte)req.A3;
    bytes[5] = (byte)req.A2;
    bytes[6] = (byte)req.A1;
    bytes[7] = (byte)req.A0;
    bytes[8] = req.checksum;
    StringBuilder sb = new StringBuilder();
    for (byte b : bytes) {
      sb.append(String.format("%02X ", b));
    }
    System.out.println("Request Hex: " + sb.toString());
  }

  public static void main(String args[]) throws Exception {

    if (args.length != 2)  // Test for correct # of args
      throw new IllegalArgumentException("Parameter(s): <Destination> <Port>");

    InetAddress destAddr = InetAddress.getByName(args[0]);  // Destination address
    int destPort = Integer.parseInt(args[1]);               // Destination port

    boolean userCon = true;
    while (userCon) {


      Scanner scanner = new Scanner(System.in);  // Create a Scanner object
      System.out.print("Enter the X value: ");
      int x = scanner.nextInt();
      System.out.print("Enter the a3 value: ");
      int a3 = scanner.nextInt();
      if (a3 > 64 || a3 < 0) {
        throw new IllegalArgumentException("A3 must be, 0 <= A3 <= 64");
      }
      System.out.print("Enter the a2 value: ");
      int a2 = scanner.nextInt();
      if (a2 > 64 || a2 < 0) {
        throw new IllegalArgumentException("A2 must be, 0 <= A2 <= 64");
      }
      System.out.print("Enter the a1 value: ");
      int a1 = scanner.nextInt();
      if (a1 > 64 || a1 < 0) {
        throw new IllegalArgumentException("A1 must be, 0 <= A1 <= 64");
      }
      System.out.print("Enter the a0 value: ");
      int a0 = scanner.nextInt();
      if (a0 > 64 || a0 < 0) {
        throw new IllegalArgumentException("A0 must be, 0 <= A0 <= 64");
      }

      Socket sock = new Socket(destAddr, destPort);

      // Request request = new Request((short) (Math.random() * 100), 5, 1, 0, 6, 12);
      Request request = new Request((short) (Math.random() * 100), x, a3, a2, a1, a0);

      System.out.println(request); // Display friend just to check what we send
      printHexRequest(request);
      RequestEncoder encoder = new RequestEncoderBin();

      OutputStream out = sock.getOutputStream(); // Get a handle onto Output Stream
      long sendTime = System.nanoTime();
      out.write(encoder.encode(request)); // Encode and send

      System.out.println("Awaiting answer");
      ResponseDecoderBin decoder = new ResponseDecoderBin();
      Response res = decoder.decode(sock.getInputStream());
      long receiveTime = System.nanoTime();

      System.out.println(res);
      System.out.printf("Round trip time: %.2fms\n",  ((float)(receiveTime - sendTime)/1000000));
      printHexResponse(res);

      sock.close();

      Scanner scan = new Scanner(System.in);
      System.out.print("Would you like to continue?(y/n): ");
      char userInput = scan.nextLine().charAt(0);  // Read user input
      if (userInput != 'y' && userInput != 'n') {
        System.out.println("Incorrect response. Exiting program.");
        userCon = false;
      } else if (userInput == 'n') {
        System.out.println("Bye.");
        userCon = false;
      }
    }
  }
}
