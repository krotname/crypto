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
public class BLAKE2bTest extends BenchmarkTest {

    private final static Hash<String,String> BLAKE2b = new BLAKE2b();
    @Test
    void hash() {
        String hash = BLAKE2b.hash(Fish.cryptographyRU());
        log.info(hash);
    }

    @Test
    void uniquenessTest() {
        String hash1 = BLAKE2b.hash(Fish.cryptographyRU());
        String hash2 = BLAKE2b.hash(Fish.cryptographyRU());
        assertEquals(hash1, hash2);
    }

    @Test
    void hashFunction() {
        Stream.of(Fish.cryptographyRU(), Fish.cryptographyRU())
                .map(BLAKE2b::hash)
                .forEach(log::info);
    }

    @Benchmark
    public void benchmark(Blackhole bh) {
        bh.consume(BLAKE2b.hash(Fish.cryptographyRU()));
    }
}