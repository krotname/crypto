package name.krot.crypto.coding;

public class BASE32 implements Coder {
    private final org.apache.commons.codec.binary.Base32 base32 = new org.apache.commons.codec.binary.Base32();

    @Override
    public String encode(String string) {
            return base32.encodeToString(string.getBytes());
    }

    @Override
    public String decode(String string) {
        return new String(base32.decode(string.getBytes()));
    }
}
