package name.krot.crypto.coding;

import lombok.extern.slf4j.Slf4j;
import name.krot.crypto.util.Fish;
import org.junit.jupiter.api.Test;
import org.openjdk.jmh.annotations.Benchmark;

@Slf4j
public class BASE32Test extends BaseCoderTest {
    private static final String CODE_EXAMPLE_BASE_32 =
            "2CNNDAGQXDIL7UMC2C7NBM6RQDILBUME2C4NDDZA2C65BMBA2C75DAGQWDILVUMC2C4NBOWQWU======";
    private final static Coder base32 = new BASE32();

    @Test
    public void testEncodeAndDecode() {
        super.testEncodeAndDecode(base32);
    }

    @Test
    public void testEncode() {
        super.testEncode(base32);
    }

    @Test
    public void testDecode() {
        super.testDecode(base32, CODE_EXAMPLE_BASE_32);
    }

    @Benchmark
    public String benchmarkDecode() {
        return base32.decode(CODE_EXAMPLE_BASE_32);
    }

    @Benchmark
    public String benchmarkEncode() {
        return base32.encode(Fish.cryptographyRU());
    }
}
