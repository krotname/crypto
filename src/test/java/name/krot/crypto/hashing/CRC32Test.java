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
public class CRC32Test extends BenchmarkTest {

    private final static Hash<String,String> CRC_32 = new CRC32();

    @Test
    void hash() {
        String hash = CRC_32.hash(Fish.cryptographyRU());
        log.info(hash);
    }

    @Test
    void uniquenessTest() {
        String hash1 = CRC_32.hash(Fish.cryptographyRU());
        String hash2 = CRC_32.hash(Fish.cryptographyRU());
        assertEquals(hash1, hash2);
    }

    @Test
    void hashFunction() {
        Stream.of(Fish.cryptographyRU(), Fish.cryptographyRU())
                .map(CRC_32::hash)
                .forEach(log::info);
    }

    @Benchmark
    public void benchmarkCRC32(Blackhole bh) {
        bh.consume(CRC_32.hash(Fish.cryptographyRU()));
    }
}