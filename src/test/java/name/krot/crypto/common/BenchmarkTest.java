package name.krot.crypto.common;

import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;

import static name.krot.crypto.common.BenchmarkTest.*;

@Threads(THREADS)
@Fork(value = FORK, jvmArgs = {XMS, XMX})
@Warmup(iterations = ITERATIONS, time = WARMUP_MILLISECONDS, timeUnit = TimeUnit.MILLISECONDS)
@Measurement(iterations = ITERATIONS, time = MEASUREMENT_MILLISECONDS, timeUnit = TimeUnit.MILLISECONDS)
@OutputTimeUnit(TimeUnit.SECONDS)
public class BenchmarkTest extends TestWithExecutionTime {

    static final String XMS = "-Xms2G";
    static final String XMX = "-Xmx2G";
    static final int THREADS = 1;
    static final int WARMUP_MILLISECONDS = 10;
    static final int ITERATIONS = 1;
    static final int MEASUREMENT_MILLISECONDS = 1000;
    static final int FORK = 0;
}
