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
public class SHA256_GuavaTest extends BenchmarkTest {

    private final static Hash<String, String> SHA256 = new SHA256_Guava();

    @Test
    void hash() {
        String hash = SHA256.hash(Fish.cryptographyRU());
        log.info(hash);
    }

    @Test
    void uniquenessTest() {
        String hash1 = SHA256.hash(Fish.cryptographyRU());
        String hash2 = SHA256.hash(Fish.cryptographyRU());
        assertEquals(hash1, hash2);
    }

    @Test
    void hashFunction() {
        Stream.of(Fish.cryptographyRU(), Fish.cryptographyRU())
                .map(SHA256::hash)
                .forEach(log::info);
    }

    @Benchmark
    public void benchmark(Blackhole bh) {
        bh.consume(SHA256.hash(Fish.cryptographyRU()));
    }
}