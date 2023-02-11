package name.krot.crypto.crypSync;

import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.security.crypto.encrypt.TextEncryptor;
import org.springframework.stereotype.Component;

@Component
public class AESSpring implements CryptSync {

    @Override
    public String encrypt(String string, String password, String salt, String iv) {
        TextEncryptor cryptographer = Encryptors.text(password, salt);
        return cryptographer.encrypt(string);
    }

    @Override
    public String decrypt(String string, String password, String salt, String iv) {
        TextEncryptor cryptographer = Encryptors.text(password, salt);
        return cryptographer.decrypt(string);
    }
}
