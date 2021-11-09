import java.io.*;   // for InputStream and IOException
import java.net.*;  // for DatagramPacket

public interface FriendDecoder {
  Friend decode(InputStream source) throws IOException;
  Friend decode(DatagramPacket packet) throws IOException;
}
