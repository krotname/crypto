package name.krot.crypto.crypSyncTests;

import lombok.extern.slf4j.Slf4j;
import name.krot.crypto.codingTests.BaseCoderTest;
import name.krot.crypto.encryptionSynchronous.AESManual;
import name.krot.crypto.encryptionSynchronous.CryptSync;
import name.krot.crypto.util.Constants;
import name.krot.crypto.util.Fish;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
@SpringBootTest(classes = {AESManual.class})
class AESManualTest extends BaseCoderTest {

    public static final String CRYPT_VALUE = "ПR\u001C\u0019(§¶XђdKпежѕ.ш®Ив#г!Ch\u0005m .9”€";
    @Autowired
    private CryptSync AESManual;

    @Test
    @Disabled
    void decryptAndEncrypt() {
        var fishLW = Fish.cryptographyEN(); // todo на других тестовых данных.
        var encrypt = AESManual.encrypt(fishLW, Constants.PASSWORD, Constants.SALT, Constants.IV);
        var decrypt = AESManual.decrypt(encrypt, Constants.PASSWORD, Constants.SALT, Constants.IV);
        assertEquals(decrypt, fishLW);
    }

    @Test
    void encrypt() {
        var encrypt = AESManual.encrypt(Fish.cryptographyRU(), Constants.PASSWORD, Constants.SALT, Constants.IV);
        log.info(encrypt);
    }

    @Test
    void decrypt() {
        var decrypt = AESManual.decrypt(CRYPT_VALUE, Constants.PASSWORD, Constants.SALT, Constants.IV);
        log.info(decrypt);
    }

    @Test
    void loadTestDecode() { // todo оптимизация
            AESManual.decrypt(CRYPT_VALUE, Constants.PASSWORD, Constants.SALT, Constants.IV);
    }

    @Test
    void loadTestEncode() {
            AESManual.encrypt(Fish.cryptographyRU(), Constants.PASSWORD, Constants.SALT, Constants.IV);
    }
}