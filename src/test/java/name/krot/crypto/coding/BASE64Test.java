package name.krot.crypto.coding;

import lombok.extern.slf4j.Slf4j;
import name.krot.crypto.util.Fish;
import org.junit.jupiter.api.Test;
import org.openjdk.jmh.annotations.Benchmark;

@Slf4j
public class BASE64Test extends BaseCoderTest {

    private static final String CODE_EXAMPLE_BASE64 =
            "0JrRgNC40L/RgtC+0LPRgNCw0YTQuNGPINC90LAg0L/RgNCw0LrRgtC40LrQtQ==";
    private final static Coder BASE_64 = new BASE64();

    @Test
    public void testEncodeAndDecode() {
        super.testEncodeAndDecode(BASE_64);
    }

    @Test
    public void testEncode() {
        super.testEncode(BASE_64);
    }

    @Test
    public void testDecode() {
        super.testDecode(BASE_64, CODE_EXAMPLE_BASE64);
    }

    @Benchmark
    public String benchmarkDecode() {
        return BASE_64.decode(CODE_EXAMPLE_BASE64);
    }

    @Benchmark
    public String benchmarkEncode() {
        return BASE_64.encode(Fish.cryptographyRU());
    }
}