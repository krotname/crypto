package name.krot.crypto.hashing;

import name.krot.crypto.exception.HashException;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;

import static name.krot.crypto.util.CryptoUtils.getHexString;

public class PBKDF2 implements Hash<String, String> {
    @Override
    public String hash(String s) {
        try {
            byte[] salt = new byte[16];
            KeySpec spec = new PBEKeySpec(s.toCharArray(), salt, 65536, 128);
            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            return getHexString(factory.generateSecret(spec).getEncoded());
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            throw new HashException(e);
        }
    }
}
