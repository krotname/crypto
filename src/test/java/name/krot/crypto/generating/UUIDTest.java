package name.krot.crypto.generating;

import lombok.extern.slf4j.Slf4j;
import name.krot.crypto.common.BenchmarkTest;
import org.junit.jupiter.api.Test;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.infra.Blackhole;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

@Slf4j
public class UUIDTest extends BenchmarkTest {

    private static final UUID uuid = new UUID();

    @Test
    void generateTest() {
        String generate = uuid.generate();
        log.info(generate);
    }

    @Test
    void nonUniquenessTest() {
        String generate1 = uuid.generate();
        String generate2 = uuid.generate();
        assertNotEquals(generate1, generate2);
    }

    @Benchmark
    public void benchmarkUuid(Blackhole bh) {
        bh.consume(uuid.generate());
    }
}