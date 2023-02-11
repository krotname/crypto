package name.krot.crypto.hashing;

import lombok.extern.slf4j.Slf4j;
import name.krot.crypto.common.BenchmarkTest;
import name.krot.crypto.util.Fish;
import org.junit.jupiter.api.Test;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.infra.Blackhole;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
public class MD5Test extends BenchmarkTest {

    private static final Hash md5 = new MD5();

    @Test
    void hash() {
        log.info(md5.hash(Fish.cryptographyRU()));
    }

    @Test
    void uniquenessTest() {
        String hash1 = md5.hash(Fish.cryptographyRU());
        String hash2 = md5.hash(Fish.cryptographyRU());
        assertEquals(hash1, hash2);
    }

    @Benchmark
    public void benchmarkMD5(Blackhole bh) {
        bh.consume(md5.hash(Fish.cryptographyRU()));
    }
}