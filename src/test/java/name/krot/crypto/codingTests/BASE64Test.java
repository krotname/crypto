package name.krot.crypto.codingTests;

import lombok.extern.slf4j.Slf4j;
import name.krot.crypto.coding.BASE32;
import name.krot.crypto.coding.BASE64;
import name.krot.crypto.coding.Coder;
import name.krot.crypto.util.Fish;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openjdk.jmh.annotations.Benchmark;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
public class BASE64Test extends BaseCoderTest {

    private static final String CODE_EXAMPLE_BASE64 =
            "0JrRgNC40L/RgtC+0LPRgNCw0YTQuNGPINC90LAg0L/RgNCw0LrRgtC40LrQtQ==";
    private final static Coder base64 = new BASE64();

    @Test
    public void testEncodeAndDecode() {
        super.testEncodeAndDecode(base64);
    }

    @Test
    public void testEncode() {
        super.testEncode(base64);
    }

    @Test
    public void testDecode() {
        super.testDecode(base64, CODE_EXAMPLE_BASE64);
    }

    @Benchmark
    public String benchmarkDecode() {
        return base64.decode(CODE_EXAMPLE_BASE64);
    }

    @Benchmark
    public String benchmarkEncode() {
        return base64.encode(Fish.cryptographyRU());
    }
}