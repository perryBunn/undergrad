package request;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.DatagramPacket;
import java.nio.ByteBuffer;

public class ResponseDecoderBin implements ResponseDecoder, ResponseBinConst {

  private String encoding;  // Character encoding

  public ResponseDecoderBin() {
    encoding = DEFAULT_ENCODING;
  }

  public ResponseDecoderBin(String encoding) {
    this.encoding = encoding;
  }

  public Response decode(InputStream wire) throws IOException {
    DataInputStream src = new DataInputStream(wire);
    int len             = src.readByte();
    short ID            = src.readShort();
    byte err             = src.readByte();
    int value           = (int) src.readInt();
    byte check          = src.readByte();

    boolean res = checkSum(len, ID, err, value, check);
//    if (res) {
//      throw new IOException();
//    }
    return new Response(ID, err, value);
  }

  private boolean checkSum(int len, short ID, int err, int value, byte check) {
    byte sum = 0;
    sum += len;
    byte[] ret = new byte[2];
    ret[0] = (byte)(ID & 0xff);
    ret[1] = (byte)((ID >> 8) & 0xff);
    sum += ret[0];
    sum += ret[1];
    sum += err;
    byte[] res = new byte[4];
    res = ByteBuffer.allocate(4).putInt(value).array();
    sum += res[0];
    sum += res[1];
    sum += res[2];
    sum += res[3];

    return sum == check;
  }

  public Response decode(DatagramPacket p) throws IOException {
    ByteArrayInputStream payload =
      new ByteArrayInputStream(p.getData(), p.getOffset(), p.getLength());
    return decode(payload);
  }
}
