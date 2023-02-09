package name.krot.crypto;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;

@Slf4j
public abstract class ShowExecutionTime {
    private long startExecTime;

    @BeforeEach
    public void start() {
        startExecTime = System.currentTimeMillis();
    }

    @AfterEach
    public void end(TestInfo testInfo) {
        log.info("{} execution Time = {} ms", testInfo.getDisplayName(), System.currentTimeMillis() - startExecTime);
    }
}
