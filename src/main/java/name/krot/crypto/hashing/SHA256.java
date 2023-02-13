package name.krot.crypto.hashing;

import name.krot.crypto.exception.CryptException;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA256 implements Hash<String,String> {
    @Override
    public String hash(String string) {
        try {
            final MessageDigest digest = MessageDigest.getInstance("SHA-256"); // todo parametr SHA3-384 and other

            final byte[] hash = digest.digest(string.getBytes(StandardCharsets.UTF_8)); // todo выверить кодировку с онлайн детектором

            return getHexString(hash);
        } catch (NoSuchAlgorithmException e) {
            throw new CryptException(e);
        }
    }

    private static String getHexString(byte[] hash) {
        final StringBuilder hexString = new StringBuilder();
        for (byte b : hash) {
            final String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1)
                hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    }
}
