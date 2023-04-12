package name.krot.crypto.hashing;

import name.krot.crypto.exception.HashException;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import static name.krot.crypto.util.CryptoUtils.getHexString;

public class SHA256 implements Hash<String, String> {
    @Override
    public String hash(String string) {
        try {
            final MessageDigest digest = MessageDigest.getInstance("SHA-256"); // todo parametr SHA3-384 and other

            final byte[] hash = digest.digest(string.getBytes(StandardCharsets.UTF_8)); // todo выверить кодировку с онлайн детектором

            return getHexString(hash);
        } catch (NoSuchAlgorithmException e) {
            throw new HashException(e);
        }
    }
}
