package request;

import java.io.IOException;
import java.io.InputStream;
import java.net.DatagramPacket;

public interface ResponseDecoder {
  Response decode(InputStream source) throws IOException;
  Response decode(DatagramPacket packet) throws IOException;
}
