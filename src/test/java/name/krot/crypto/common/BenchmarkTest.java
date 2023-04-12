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

    public static final String XMS = "-Xms2G";
    public static final String XMX = "-Xmx2G";
    public static final int THREADS = 1;
    public static final int WARMUP_MILLISECONDS = 100;
    public static final int ITERATIONS = 1;
    public static final int MEASUREMENT_MILLISECONDS = 1000;
    public static final int FORK = 0;
}
