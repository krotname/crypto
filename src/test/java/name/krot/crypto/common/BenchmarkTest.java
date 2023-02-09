package name.krot.crypto.common;

import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Threads;
import org.openjdk.jmh.annotations.Warmup;

import static name.krot.crypto.common.BenchmarkTest.*;

@Threads(THREADS)
@Fork(value = FORK, jvmArgs = {XMS, XMX})
@Warmup(iterations = ITERATIONS, time = WARMUP_SECONDS)
@Measurement(iterations = ITERATIONS, time = MEASUREMENT_SECONDS)
public class BenchmarkTest extends TestWithExecutionTime {

    static final String XMS = "-Xms2G";
    static final String XMX = "-Xmx2G";
    static final int THREADS = 1;
    static final int WARMUP_SECONDS = 1;
    static final int ITERATIONS = 1;
    static final int MEASUREMENT_SECONDS = 5;
    static final int FORK = 0;
}
