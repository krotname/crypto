package name.krot.crypto.hashing;

import lombok.extern.slf4j.Slf4j;
import name.krot.crypto.common.BenchmarkTest;
import name.krot.crypto.util.Fish;
import org.junit.jupiter.api.Test;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.infra.Blackhole;

import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static name.krot.crypto.common.BenchmarkTest.ITERATIONS;
import static name.krot.crypto.common.BenchmarkTest.MEASUREMENT_MILLISECONDS;
import static org.junit.jupiter.api.Assertions.*;

@Slf4j
public class BCryptTest extends BenchmarkTest {

    private final static BCrypt BCrypt = new BCrypt();
    @Test
    void hash() {
        String hash = BCrypt.hash(Fish.cryptographyRU());
        log.info(hash);
    }

    @Test
    void nonUniquenessTest() {
        String hash1 = BCrypt.hash(Fish.cryptographyRU());
        String hash2 = BCrypt.hash(Fish.cryptographyRU());
        assertNotEquals(hash1, hash2);
    }

    @Test
    void matchesTest() {
        String hash1 = BCrypt.hash(Fish.cryptographyRU());
        assertTrue(BCrypt.matches(Fish.cryptographyRU(), hash1));
    }

    @Test
    void hashFunction() {
        Stream.of(Fish.cryptographyRU(), Fish.cryptographyRU())
                .map(BCrypt::hash)
                .forEach(log::info);
    }

    @Benchmark
    public void benchmark(Blackhole bh) {
        bh.consume(BCrypt.hash(Fish.cryptographyRU()));
    }
}