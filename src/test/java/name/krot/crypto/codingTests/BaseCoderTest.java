package name.krot.crypto.codingTests;

import lombok.extern.slf4j.Slf4j;
import name.krot.crypto.common.BenchmarkTest;
import name.krot.crypto.coding.Coder;
import name.krot.crypto.util.Fish;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
public class BaseCoderTest extends BenchmarkTest {
    void testEncodeAndDecode(Coder coder) {
        String fishLW = Fish.fishLW();
        String encrypt = coder.encode(fishLW);
        String decrypt = coder.decode(encrypt);
        assertEquals(decrypt, fishLW);
        log.info("Encrypt and Decrypt success");
    }

    void testEncode(Coder coder) {
        String encrypt = coder.encode(Fish.cryptographyRU());
        log.info("Encrypt value = {}", encrypt);
    }

    void testDecode(Coder coder, String codeExample) {
        String decrypt = coder.decode(codeExample);
        log.info("Decrypt value = {}", decrypt);
    }
}
