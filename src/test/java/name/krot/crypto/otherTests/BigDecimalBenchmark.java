package name.krot.crypto.otherTests;

import lombok.extern.slf4j.Slf4j;
import name.krot.crypto.common.BenchmarkTest;
import org.junit.jupiter.api.Test;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.infra.Blackhole;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
public class BigDecimalBenchmark extends BenchmarkTest {
    private static final Random RANDOM = new Random();

    @Benchmark
    public void bigDecimalDeserializeConcat(Blackhole bh) {
        bh.consume(new BigDecimal(RANDOM.nextInt(999) + "." + RANDOM.nextInt(999_999)));
    }

    @Benchmark
    public void bigDecimalDeserializeNotConcat(Blackhole bh) {
        bh.consume(new BigDecimal(String.valueOf(RANDOM.nextInt(999_999_999))));
    }

    @Benchmark
    public void bigDecimalDeserializeConstructAndValueOf(Blackhole bh) {
        bh.consume(new BigDecimal(BigInteger.valueOf(RANDOM.nextInt(999_999_999)), 5));
    }

    @Benchmark
    public void bigDecimalDeserializeConstructAndValueOfx2(Blackhole bh) {
        bh.consume(new BigDecimal(BigInteger.valueOf(Long.parseLong(String.valueOf(RANDOM.nextInt(999_999_999)))), 5));
    }

    @Benchmark
    public void bigDecimalDeserializeValueOf(Blackhole bh) {
        bh.consume(BigDecimal.valueOf(RANDOM.nextInt(999_999_999), 5));
    }

    @Benchmark
    public void random(Blackhole bh) {
        bh.consume(RANDOM.nextInt(999_999_999));
    }

    @Test
    public void testBigDecimalCorrect() {
        BigDecimal bd1 = BigDecimal.valueOf(123456000, 6);
        BigDecimal bd2 = new BigDecimal("123.456000");
        assertEquals(0, bd1.compareTo(bd2));
    }
}
