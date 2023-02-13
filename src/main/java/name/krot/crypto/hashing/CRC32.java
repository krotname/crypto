package name.krot.crypto.hashing;

public class CRC32 implements Hash<String,String> {
    @Override
    public String hash(String string) {
        final java.util.zip.CRC32 crc32 = new java.util.zip.CRC32();
        crc32.update(string.getBytes());
        return Long.toHexString(crc32.getValue()); // Hexadecimal
    }
}
