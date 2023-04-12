package name.krot.crypto.hashing;

import lombok.extern.slf4j.Slf4j;
import name.krot.crypto.common.BenchmarkTest;
import name.krot.crypto.util.Fish;
import org.junit.jupiter.api.Test;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.infra.Blackhole;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
public class MD5Test extends BenchmarkTest {

    private static final Hash<String,String> MD_5 = new MD5();

    @Test
    void hash() {
        log.info(MD_5.hash(Fish.cryptographyRU()));
    }

    @Test
    void uniquenessTest() {
        String hash1 = MD_5.hash(Fish.cryptographyRU());
        String hash2 = MD_5.hash(Fish.cryptographyRU());
        assertEquals(hash1, hash2);
    }

    @Test
    void hashFunction() {
        Stream.of(Fish.cryptographyRU(), Fish.cryptographyRU())
                .map(MD_5::hash)
                .forEach(log::info);
    }

    @Benchmark
    public void benchmark(Blackhole bh) {
        bh.consume(MD_5.hash(Fish.cryptographyRU()));
    }
}