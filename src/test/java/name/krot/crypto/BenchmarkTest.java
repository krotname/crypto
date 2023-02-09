package name.krot.crypto;

import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Threads;
import org.openjdk.jmh.annotations.Warmup;
import org.springframework.boot.test.context.SpringBootTest;

import static name.krot.crypto.BenchmarkTest.*;

@Threads(THREADS)
@Fork(value = FORK, jvmArgs = {XMS, XMX})
@Warmup(iterations = ITERATIONS, time = WARMUP_SECONDS)
@Measurement(iterations = ITERATIONS, time = MEASUREMENT_SECONDS)
public class BenchmarkTest extends TestWithExecutionTime {

    public static final String XMS = "-Xms2G";
    public static final String XMX = "-Xmx2G";
    public static final int THREADS = 1;
    public static final int WARMUP_SECONDS = 1;
    public static final int ITERATIONS = 1;
    public static final int MEASUREMENT_SECONDS = 5;
    public static final int FORK = 0;
}
