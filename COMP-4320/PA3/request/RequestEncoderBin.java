package request;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class RequestEncoderBin implements RequestEncoder, RequestBinConst {

  private String encoding;  // Character encoding

  public RequestEncoderBin() {
    encoding = DEFAULT_ENCODING;
  }

  public RequestEncoderBin(String encoding) {
    this.encoding = encoding;
  }

  public byte[] encode(Request request) throws Exception {
    ByteArrayOutputStream buf = new ByteArrayOutputStream();
    DataOutputStream out = new DataOutputStream(buf);

    out.writeByte(request.len);
    out.writeShort(request.ID);
    out.writeByte(request.X);
    out.writeByte(request.A3);
    out.writeByte(request.A2);
    out.writeByte(request.A1);
    out.writeByte(request.A0);
    out.writeByte(request.checksum);

    out.flush();
    return buf.toByteArray();
  }
}
