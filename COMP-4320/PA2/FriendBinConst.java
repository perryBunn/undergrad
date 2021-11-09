public interface FriendBinConst {
    public static final String DEFAULT_ENCODING = "ISO-8859-1";
    public static final int SINGLE_FLAG = 1 << 0; // Least significant bit
    public static final int RICH_FLAG   = 1 << 1; // weight 2^1 
    public static final int FEMALE_FLAG = 1 << 2; // weight 2^2
    public static final int MAX_LASTNAME_LEN = 255; // Max length lastname
    public static final int MAX_WIRE_LENGTH  = 1024; // Max length on the" wire"
}
