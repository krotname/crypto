package name.krot.crypto.hashing;

import lombok.extern.slf4j.Slf4j;
import name.krot.crypto.common.BenchmarkTest;
import name.krot.crypto.util.Fish;
import org.junit.jupiter.api.Test;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.infra.Blackhole;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
public class BCryptTest extends BenchmarkTest {

    private final static BCrypt B_CRYPT = new BCrypt();
    @Test
    void hash() {
        String hash = B_CRYPT.hash(Fish.cryptographyRU());
        log.info(hash);
    }

    @Test
    void nonUniquenessTest() {
        String hash1 = B_CRYPT.hash(Fish.cryptographyRU());
        String hash2 = B_CRYPT.hash(Fish.cryptographyRU());
        assertNotEquals(hash1, hash2);
    }

    @Test
    void matchesTest() {
        String hash1 = B_CRYPT.hash(Fish.cryptographyRU());
        assertTrue(B_CRYPT.matches(Fish.cryptographyRU(), hash1));
    }

    @Test
    void hashFunction() {
        Stream.of(Fish.cryptographyRU(), Fish.cryptographyRU())
                .map(B_CRYPT::hash)
                .forEach(log::info);
    }

    @Benchmark
    public void benchmark(Blackhole bh) {
        bh.consume(B_CRYPT.hash(Fish.cryptographyRU()));
    }
}