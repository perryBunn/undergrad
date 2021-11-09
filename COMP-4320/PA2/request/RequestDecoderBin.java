package request;

import java.io.*;
import java.net.DatagramPacket;

public class RequestDecoderBin implements ReqestDecoder, RequestBinConst {

  private String encoding;  // Character encoding

  public RequestDecoderBin() {
    encoding = DEFAULT_ENCODING;
  }

  public RequestDecoderBin(String encoding) {
    this.encoding = encoding;
  }

  public Request decode(InputStream wire) throws IOException {
    DataInputStream src = new DataInputStream(wire);
    int len             = src.readByte();
    short ID            = src.readShort();
    int x               = (int) src.readByte();
    int a3              = (int) src.readByte();
    int a2              = (int) src.readByte();
    int a1              = (int) src.readByte();
    int a0              = (int) src.readByte();
    byte check           = src.readByte();

    boolean res = checkSum(len, ID, x, a3, a2, a1, a0, check);
    if (res) {
      throw new IOException();
    }
    return new Request(ID, x, a3, a2, a1, a0);
  }

  private boolean checkSum(int len, short ID, int X, int a3, int a2, int a1, int a0, byte check) {
    byte sum = 0;
    sum += len;
    byte[] ret = new byte[2];
    ret[0] = (byte)(ID & 0xff);
    ret[1] = (byte)((ID >> 8) & 0xff);
    sum += ret[0];
    sum += ret[1];
    sum += (byte) X;
    sum += (byte) a3;
    sum += (byte) a2;
    sum += (byte) a1;
    sum += (byte) a0;
    System.out.println("checksum: " + (byte) sum);
    if (sum != check) {
      return false;
    }
    return true;
  }

  public Request decode(DatagramPacket p) throws IOException {
    ByteArrayInputStream payload =
      new ByteArrayInputStream(p.getData(), p.getOffset(), p.getLength());
    return decode(payload);
  }
}
