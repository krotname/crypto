package name.krot.crypto.coding;

import lombok.extern.slf4j.Slf4j;
import name.krot.crypto.util.Fish;
import org.junit.jupiter.api.Test;
import org.openjdk.jmh.annotations.Benchmark;

@Slf4j
public class BASE58Test extends BaseCoderTest{

    private static final String CODE_EXAMPLE_BASE_58 =
            "PnLoVJGrkwjLdzQLVewvVt219CRSHomnt43RHDksnSLbLRZCaiywQp82xx9jiAx";
    private final static Coder BASE_58 = new BASE58();

    @Test
    public void testEncodeAndDecode() {
        super.testEncodeAndDecode(BASE_58);
    }

    @Test
    public void testEncode() {
        super.testEncode(BASE_58);
    }

    @Test
    public void testDecode() {
        super.testDecode(BASE_58, CODE_EXAMPLE_BASE_58);
    }

    @Benchmark
    public String benchmarkDecode() {
        return BASE_58.decode(CODE_EXAMPLE_BASE_58);
    }

    @Benchmark
    public String benchmarkEncode() {
        return BASE_58.encode(Fish.cryptographyRU());
    }
}