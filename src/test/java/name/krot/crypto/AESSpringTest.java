package name.krot.crypto;

import lombok.extern.slf4j.Slf4j;
import name.krot.crypto.encryptionSynchronous.AESSpring;
import name.krot.crypto.encryptionSynchronous.CryptSync;
import name.krot.crypto.util.Constants;
import name.krot.crypto.util.Fish;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
@SpringBootTest(classes = {AESSpring.class})
class AESSpringTest extends ShowExecutionTime {

    public static final String CRYPT_VALUE = "d1430d276a3823d608b152a850d1c160e009bdf66a17808321f46702256f085e361266" +
            "51a17d966b2ecf260833e5ffc1b2374e3777c7f1bb3946a86079c16b3b";
    @Autowired
    private CryptSync aESSpring;

    @Test
    @DisplayName("Шифрование")
    void encrypt() {
        var encrypt = aESSpring.encrypt(Fish.cryptographyRU(), Constants.PASSWORD, Constants.SALT, Constants.IV);
        log.debug(encrypt);
    }

    @Test
    @DisplayName("Расшифровка")
    void decrypt() {
        var decrypt = aESSpring.decrypt(CRYPT_VALUE, Constants.PASSWORD, Constants.SALT, Constants.IV);
        log.debug(decrypt);
    }

    @Test
    @DisplayName("Корректность дешифрования")
    void decryptAndEncrypt() {
        var fishLW = Fish.fishLW();
        var encrypt = aESSpring.encrypt(fishLW, Constants.PASSWORD, Constants.SALT, Constants.IV);
        var decrypt = aESSpring.decrypt(encrypt, Constants.PASSWORD, Constants.SALT, Constants.IV);
        assertEquals(decrypt, fishLW);
    }

    @Test
    @DisplayName("Скорость дешифрования")
        // i7-9850H: 1_000 = 1984 ms
    void loadTestDecode() {
        for (int i = 0; i < 1_000; i++) {
            aESSpring.decrypt(CRYPT_VALUE, Constants.PASSWORD, Constants.SALT, Constants.IV);
        }
    }

    @Test
    @DisplayName("Скорость шифрования")
    void loadTestEncode() { // i7-9850H: 1_000 = 2774 ms
        for (int i = 0; i < 1_000; i++) {
            aESSpring.encrypt(Fish.cryptographyRU(), Constants.PASSWORD, Constants.SALT, Constants.IV);
        }
    }
}