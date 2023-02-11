package name.krot.crypto.coding;

import lombok.extern.slf4j.Slf4j;
import name.krot.crypto.util.Fish;
import org.junit.jupiter.api.Test;
import org.openjdk.jmh.annotations.Benchmark;

@Slf4j
public class BASE58Test extends BaseCoderTest{

    private static final String CODE_EXAMPLE_BASE_58 =
            "PnLoVJGrkwjLdzQLVewvVt219CRSHomnt43RHDksnSLbLRZCaiywQp82xx9jiAx";
    private final static Coder CODER = new BASE58();

    @Test
    public void testEncodeAndDecode() {
        super.testEncodeAndDecode(CODER);
    }

    @Test
    public void testEncode() {
        super.testEncode(CODER);
    }

    @Test
    public void testDecode() {
        super.testDecode(CODER, CODE_EXAMPLE_BASE_58);
    }

    @Benchmark
    public String benchmarkDecode() {
        return CODER.decode(CODE_EXAMPLE_BASE_58);
    }

    @Benchmark
    public String benchmarkEncode() {
        return CODER.encode(Fish.cryptographyRU());
    }
}