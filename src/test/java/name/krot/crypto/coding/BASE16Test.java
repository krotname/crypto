package name.krot.crypto.coding;

import name.krot.crypto.util.Fish;
import org.junit.jupiter.api.Test;
import org.openjdk.jmh.annotations.Benchmark;

public class BASE16Test extends BaseCoderTest {

    private static final String CODE_EXAMPLE_BASE16 =
            "D09AD180D0B8D0BFD182D0BED0B3D180D0B0D184D0B8D18F20D0BDD0B020D0BFD180D0B0D0BAD182D0B8D0BAD0B5";
    private final static Coder BASE_16 = new BASE16();

    @Test
    public void testEncodeAndDecode() {
        super.testEncodeAndDecode(BASE_16);
    }

    @Test
    public void testEncode() {
        super.testEncode(BASE_16);
    }

    @Test
    public void testDecode() {
        super.testDecode(BASE_16, CODE_EXAMPLE_BASE16);
    }

    @Benchmark
    public String benchmarkDecode() {
        return BASE_16.decode(CODE_EXAMPLE_BASE16);
    }

    @Benchmark
    public String benchmarkEncode() {
        return BASE_16.encode(Fish.cryptographyRU());
    }
}