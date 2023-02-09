package name.krot.crypto;

import lombok.extern.slf4j.Slf4j;
import name.krot.crypto.encryptionSynchronous.AESManual;
import name.krot.crypto.encryptionSynchronous.CryptSync;
import name.krot.crypto.util.Constants;
import name.krot.crypto.util.Fish;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Duration;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
@SpringBootTest(classes = {AESManual.class})
class AESManualTest extends ShowExecutionTime {

    public static final String CRYPT_VALUE = "ПR\u001C\u0019(§¶XђdKпежѕ.ш®Ив#г!Ch\u0005m .9”€";
    @Autowired
    private CryptSync aESManual;

    @Test
    @Disabled
    void decryptAndEncrypt() {
        var fishLW = Fish.cryptographyEN(); // todo на других тестовых данных.
        var encrypt = aESManual.encrypt(fishLW, Constants.PASSWORD, Constants.SALT, Constants.IV);
        var decrypt = aESManual.decrypt(encrypt, Constants.PASSWORD, Constants.SALT, Constants.IV);
        assertEquals(decrypt, fishLW);
    }

    @Test
    @DisplayName("Шифрование")
    void encrypt() {
        var encrypt = aESManual.encrypt(Fish.cryptographyRU(), Constants.PASSWORD, Constants.SALT, Constants.IV);
        log.info(encrypt);
    }

    @Test
    @DisplayName("Расшифровка")
    void decrypt() {
        var decrypt = aESManual.decrypt(CRYPT_VALUE, Constants.PASSWORD, Constants.SALT, Constants.IV);
        log.info(decrypt);
    }

    @Test
    @DisplayName("Скорость дешифрования")
    void loadTestDecode() { // todo оптимизация
        for (int i = 0; i < 10; i++) {
            aESManual.decrypt(CRYPT_VALUE, Constants.PASSWORD, Constants.SALT, Constants.IV);
        }
    }

    @Test
    @DisplayName("Скорость шифрования")
    void loadTestEncode() {
        for (int i = 0; i < 10; i++) {
            aESManual.encrypt(Fish.cryptographyRU(), Constants.PASSWORD, Constants.SALT, Constants.IV);
        }
    }
}