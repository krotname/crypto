package name.krot.crypto.hashing;

import com.rfksystems.blake2b.security.Blake2bProvider;
import lombok.extern.slf4j.Slf4j;
import name.krot.crypto.exception.CryptException;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Security;

@Slf4j
public class BLAKE2b implements Hash<String,String>{

    @Override
    public String hash(String string) {
        Security.addProvider(new Blake2bProvider());
        try {
            final MessageDigest digest = MessageDigest.getInstance("BLAKE2B-256");

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
