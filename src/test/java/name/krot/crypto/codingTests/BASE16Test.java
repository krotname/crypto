package name.krot.crypto.codingTests;

import name.krot.crypto.coding.BASE16;
import name.krot.crypto.coding.Coder;
import name.krot.crypto.util.Fish;
import org.junit.jupiter.api.Test;
import org.openjdk.jmh.annotations.Benchmark;

public class BASE16Test extends BaseCoderTest {

    private static final String CODE_EXAMPLE_BASE16 =
            "D09AD180D0B8D0BFD182D0BED0B3D180D0B0D184D0B8D18F20D0BDD0B020D0BFD180D0B0D0BAD182D0B8D0BAD0B5";
    private final static Coder base16 = new BASE16();

    @Test
    public void testEncodeAndDecode() {
        super.testEncodeAndDecode(base16);
    }

    @Test
    public void testEncode() {
        super.testEncode(base16);
    }

    @Test
    public void testDecode() {
        super.testDecode(base16, CODE_EXAMPLE_BASE16);
    }

    @Benchmark
    public String benchmarkDecode() {
        return base16.decode(CODE_EXAMPLE_BASE16);
    }

    @Benchmark
    public String benchmarkEncode() {
        return base16.encode(Fish.cryptographyRU());
    }
}