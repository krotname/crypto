package name.krot.crypto.codingTests;

import lombok.extern.slf4j.Slf4j;
import name.krot.crypto.coding.BASE64;
import name.krot.crypto.coding.Coder;
import name.krot.crypto.util.Fish;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
@SpringBootTest(classes = {BASE64.class})
class BASE64Test extends BaseCoderTest {

    @Autowired
    private Coder base64;

    @Test
    @DisplayName("Корректность декодирования")
    void testEncodeAndDecode() {
        String fishLW = Fish.fishLW();
        String encrypt = base64.encode(fishLW);
        String decrypt = base64.decode(encrypt);
        assertEquals(decrypt, fishLW);
    }

    @Test
    @DisplayName("Кодирование")
    void testEncode() {
        String encrypt = base64.encode(Fish.cryptographyRU());
        log.info(encrypt);
    }

    @Test
    @DisplayName("Декодирование")
    void testDecode() {
        String decrypt = base64.decode("0JrRgNC40L/RgtC+0LPRgNCw0YTQuNGPINC90LAg0L/RgNCw0LrRgtC40LrQtQ==");
        log.debug(decrypt);
    }

    @Test
    @DisplayName("Скорость декодирования")
    void loadTestDecode() {
        for (int i = 0; i < 1_000_000; i++) {
            base64.decode("0JrRgNC40L/RgtC+0LPRgNCw0YTQuNGPINC90LAg0L/RgNCw0LrRgtC40LrQtQ==");
        }
    }

    @Test
    @DisplayName("Скорость кодирования")
    void loadTestEncode() {
        for (int i = 0; i < 1_000; i++) {
            base64.encode(Fish.cryptographyRU());
        }
    }
}