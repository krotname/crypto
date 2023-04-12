package name.krot.crypto.hashing;

import lombok.extern.slf4j.Slf4j;
import name.krot.crypto.common.BenchmarkTest;
import name.krot.crypto.util.Fish;
import org.junit.jupiter.api.Test;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.infra.Blackhole;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Slf4j
public class Argon2Test extends BenchmarkTest {


    private final static Argon2 ARGON_2 = new Argon2();

    @Test
    void hash() {
        String hash = ARGON_2.hash(Fish.cryptographyRU());
        log.info(hash);
    }

    @Test
    void nonUniquenessTest() {
        String hash1 = ARGON_2.hash(Fish.cryptographyRU());
        String hash2 = ARGON_2.hash(Fish.cryptographyRU());
        assertNotEquals(hash1, hash2);
    }

    @Test
    void matchesTest() {
        String hash1 = ARGON_2.hash(Fish.cryptographyRU());
        assertTrue(ARGON_2.matches(Fish.cryptographyRU(), hash1));
    }

    @Test
    void hashFunction() {
        Stream.of(Fish.cryptographyRU(), Fish.cryptographyRU())
                .map(ARGON_2::hash)
                .forEach(log::info);
    }

    @Benchmark
    public void benchmark(Blackhole bh) {
        bh.consume(ARGON_2.hash(Fish.cryptographyRU()));
    }
}