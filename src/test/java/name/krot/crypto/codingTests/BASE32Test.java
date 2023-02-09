package name.krot.crypto.codingTests;

import lombok.extern.slf4j.Slf4j;
import name.krot.crypto.coding.BASE32;
import name.krot.crypto.coding.Coder;
import name.krot.crypto.util.Fish;
import org.junit.jupiter.api.Test;
import org.openjdk.jmh.annotations.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
@Threads(1)
@Fork(value = 0, jvmArgs = {"-Xms2G", "-Xmx2G"})
@Warmup(iterations = 1, time = 1)
@Measurement(iterations = 1, time = 5)
public class BASE32Test {
    private static final String CODE_EXAMPLE =
            "2CNNDAGQXDIL7UMC2C7NBM6RQDILBUME2C4NDDZA2C65BMBA2C75DAGQWDILVUMC2C4NBOWQWU======";
    private final static Coder base32 = new BASE32();

    @Test
    public void testEncodeAndDecode() {
        String fishLW = Fish.fishLW();
        String encrypt = base32.encode(fishLW);
        String decrypt = base32.decode(encrypt);
        assertEquals(decrypt, fishLW);
    }

    @Test
    public void testEncode() {
        String encrypt = base32.encode(Fish.cryptographyRU());
        log.info(encrypt);
    }

    @Test
    public void testDecode() {
        String decrypt = base32.decode(CODE_EXAMPLE);
        log.info(decrypt);
    }

    @Benchmark
    public String benchmarkDecode() {
        return base32.decode(CODE_EXAMPLE);
    }

    @Benchmark
    public String benchmarkEncode() {
        return base32.encode(Fish.cryptographyRU());
    }
}