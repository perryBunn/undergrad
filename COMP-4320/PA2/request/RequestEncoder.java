package request;

public interface RequestEncoder {
  byte[] encode(Request request) throws Exception;
}
