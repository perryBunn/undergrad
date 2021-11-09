package request;

public class Request {

    public byte len = 9;        // TML
    public short ID;            // Item identification number
    public int X;               // X
    public int A0;              // A_0
    public int A1;              // A_1
    public int A2;              // A_2
    public int A3;              // A_3
    public byte checksum;       // Checksum

  public Request(short ID, int X, int A3, int A2, int A1, int A0)  {
      this.ID = ID;
      this.X = X;
      this.A0 = A0;
      this.A1 = A1;
      this.A2 = A2;
      this.A3 = A3;
      genSum();
  }

  private void genSum() {
      byte sum = 0;
      sum += this.len;
      byte[] ret = new byte[2];
      ret[0] = (byte)(this.ID & 0xff);
      ret[1] = (byte)((this.ID >> 8) & 0xff);
      sum += ret[0];
      sum += ret[1];
      sum += (byte) this.X;
      sum += (byte) this.A3;
      sum += (byte) this.A2;
      sum += (byte) this.A1;
      sum += (byte) this.A0;
      this.checksum = sum;
  }

  public String toString() {
    final String EOLN = System.getProperty("line.separator");
    String value = "";
    if (this.X > 0 && this.A3 > 0) {
        value += this.A3 + "(" + this.X + ")^3 ";
    }
    if (this.X > 0 && this.A2 > 0) {
        if (!value.equals("")) {
            value += "+ ";
        }
        value += this.A2 + "(" + this.X + ")^2 ";
    }
    if (this.X > 0 && this.A1 > 0) {
        if (!value.equals("")) {
            value += "+ ";
        }
        value += this.A1 + "(" + this.X + ") ";
    }
    if (this.A0 > 0) {
        if (!value.equals("")) {
            value += "+ ";
        }
        value += this.A0;
    }
    return value;
  }
}
