package name.krot.crypto.coding;

import lombok.extern.slf4j.Slf4j;
import name.krot.crypto.util.Fish;
import org.junit.jupiter.api.Test;
import org.openjdk.jmh.annotations.Benchmark;

@Slf4j
public class BASE32Test extends BaseCoderTest {
    private static final String CODE_EXAMPLE_BASE_32 =
            "2CNNDAGQXDIL7UMC2C7NBM6RQDILBUME2C4NDDZA2C65BMBA2C75DAGQWDILVUMC2C4NBOWQWU======";
    private final static Coder BASE_32 = new BASE32();

    @Test
    public void testEncodeAndDecode() {
        super.testEncodeAndDecode(BASE_32);
    }

    @Test
    public void testEncode() {
        super.testEncode(BASE_32);
    }

    @Test
    public void testDecode() {
        super.testDecode(BASE_32, CODE_EXAMPLE_BASE_32);
    }

    @Benchmark
    public String benchmarkDecode() {
        return BASE_32.decode(CODE_EXAMPLE_BASE_32);
    }

    @Benchmark
    public String benchmarkEncode() {
        return BASE_32.encode(Fish.cryptographyRU());
    }
}
