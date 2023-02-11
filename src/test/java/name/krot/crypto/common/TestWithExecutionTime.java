package name.krot.crypto.common;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;

@Slf4j
@State(Scope.Thread)
public class TestWithExecutionTime {

    private long startExecTime;

    @BeforeEach
    void start() {
        startExecTime = System.currentTimeMillis();
    }

    @AfterEach
    void end(TestInfo testInfo) {
        log.info("{} execution Time = {} ms", testInfo.getDisplayName(), System.currentTimeMillis() - startExecTime);
    }
}
