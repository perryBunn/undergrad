import java.io.*;  // for ByteArrayInputStream
import java.net.*; // for DatagramPacket

public class FriendDecoderBin implements FriendDecoder, FriendBinConst {

  private String encoding;  // Character encoding

  public FriendDecoderBin() {
    encoding = DEFAULT_ENCODING;
  }

  public FriendDecoderBin(String encoding) {
    this.encoding = encoding;
  }

  public Friend decode(InputStream wire) throws IOException {
      boolean single, rich, female;
    DataInputStream src = new DataInputStream(wire);
    long  ID            = src.readLong();
    short streetnumber  = src.readShort();
    int   zipcode       = src.readInt();
    byte  flags         = src.readByte();  
    
    //Deal with the lastname
    int stringLength = src.read(); // Returns an unsigned byte as an int
    if (stringLength == -1)
      throw new EOFException();
    byte[] stringBuf = new byte[stringLength];
    src.readFully(stringBuf);
    String lastname = new String(stringBuf, encoding);

    return new Friend(ID,lastname, streetnumber, zipcode,
      ((flags & SINGLE_FLAG) == SINGLE_FLAG),
		      ((flags & RICH_FLAG) == RICH_FLAG),
		      ((flags & FEMALE_FLAG) == FEMALE_FLAG));
  }

  public Friend decode(DatagramPacket p) throws IOException {
    ByteArrayInputStream payload =
      new ByteArrayInputStream(p.getData(), p.getOffset(), p.getLength());
    return decode(payload);
  }
}
