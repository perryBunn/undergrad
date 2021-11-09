package request;

import java.nio.ByteBuffer;

public class Response {
    public short ID;
    public byte err;
    public final byte len = 9;
    public int result;
    public byte checksum;

    public Response(short id, byte err, int res) {
        this.ID = id;
        this.err = err;
        this.result = res;
        genSum();
    }

    public String toString() {
        final String EOLN = System.getProperty("line.separator");
        String value = "P(x) = " + this.result;
        return value;
    }

    private void genSum() {
        byte sum = 0;
        sum += this.len;
        byte[] ret = new byte[2];
        ret[0] = (byte)(this.ID & 0xff);
        ret[1] = (byte)((this.ID >> 8) & 0xff);
        sum += ret[0];
        sum += ret[1];
        sum += this.err;
        byte[] res = new byte[4];
        res = ByteBuffer.allocate(4).putInt(this.result).array();
        sum += res[0];
        sum += res[1];
        sum += res[2];
        sum += res[3];
        this.checksum = sum;
    }
}
