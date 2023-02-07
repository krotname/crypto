package name.krot.crypto.hashing;

import lombok.extern.slf4j.Slf4j;
import name.krot.crypto.encryptionSynchronous.AESManual;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@Slf4j
@SpringBootTest(classes = {MD5.class})
class MD5Test {

    @Autowired
    private Hash mD5;
    @Test
    void hash() {
        log.info(mD5.hash("555555555")); // todo подругому
    }
}