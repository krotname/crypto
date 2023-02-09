package name.krot.crypto.other;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
@BenchmarkMode(Mode.Throughput)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Fork(1)
@Warmup(iterations = 1, time = 100, timeUnit = TimeUnit.MILLISECONDS)
@Measurement(iterations = 10, time = 1, timeUnit = TimeUnit.MINUTES)
public class BigDecimalTest {
    private static final Random RANDOM = new Random();

    @Benchmark
    public void bigDecimalDeserializeConcat(Blackhole blackhole) {
        blackhole.consume(new BigDecimal(String.valueOf(RANDOM.nextInt(999)) + "." + String.valueOf(RANDOM.nextInt(999_999))));
    }

    @Benchmark
    public void bigDecimalDeserializeNotConcat(Blackhole blackhole) {
        blackhole.consume(new BigDecimal(String.valueOf(RANDOM.nextInt(999_999_999))));
    }

    @Benchmark
    public void bigDecimalDeserializeConstructAndValueOf(Blackhole blackhole) {
        blackhole.consume(new BigDecimal(BigInteger.valueOf(RANDOM.nextInt(999_999_999)), 5));
    }

    @Benchmark
    public void bigDecimalDeserializeConstructAndValueOfx2(Blackhole blackhole) {
        blackhole.consume(new BigDecimal(BigInteger.valueOf(Long.parseLong(String.valueOf(RANDOM.nextInt(999_999_999)))), 5));
    }

    @Benchmark
    public void bigDecimalDeserializeValueOf(Blackhole blackhole) {
        blackhole.consume(BigDecimal.valueOf(RANDOM.nextInt(999_999_999), 5));
    }

    @Benchmark
    public void random(Blackhole blackhole) {
        blackhole.consume(RANDOM.nextInt(999_999_999));
        ;
    }

    @Test
    public void testBigDecimalCorrect() {
        BigDecimal bd1 = BigDecimal.valueOf(123456000, 6);
        BigDecimal bd2 = new BigDecimal("123.456000");
        assertEquals(0, bd1.compareTo(bd2));
    }


}
