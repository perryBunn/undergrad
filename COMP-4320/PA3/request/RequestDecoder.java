package request;

import java.io.IOException;
import java.io.InputStream;
import java.net.DatagramPacket;

public interface RequestDecoder {
  Request decode(InputStream source) throws IOException;
  Request decode(DatagramPacket packet) throws IOException;
}
