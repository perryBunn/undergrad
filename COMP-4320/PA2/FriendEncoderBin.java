import java.io.*;  // for ByteArrayOutputStream and DataOutputStream

public class FriendEncoderBin implements FriendEncoder, FriendBinConst {

  private String encoding;  // Character encoding

  public FriendEncoderBin() {
    encoding = DEFAULT_ENCODING;
  }

  public FriendEncoderBin(String encoding) {
    this.encoding = encoding;
  }

  public byte[] encode(Friend friend) throws Exception {

    ByteArrayOutputStream buf = new ByteArrayOutputStream();
    DataOutputStream out = new DataOutputStream(buf);
    out.writeLong(friend.ID);
    // Will deal with the lasname at the end
    out.writeShort(friend.streetNumber);
    out.writeInt(friend.zipCode);
    byte flags = 0;
    if (friend.single)
	flags = SINGLE_FLAG;
    if (friend.rich)
	flags |= RICH_FLAG;
    if (friend.female)
	flags |= FEMALE_FLAG;
    out.writeByte(flags);

    byte[] encodedLastname = friend.lastName.getBytes(encoding);
    if (encodedLastname.length > MAX_LASTNAME_LEN)
      throw new IOException("Friend lastname exceeds encoded length limit");
    out.writeByte(encodedLastname.length); // provides length of lastname
    out.write(encodedLastname);
    out.flush();
    return buf.toByteArray();
  }
}
