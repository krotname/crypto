package name.krot.crypto.hashing;

import lombok.extern.slf4j.Slf4j;
import name.krot.crypto.util.Fish;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
@SpringBootTest(classes = {MD5.class})
class MD5Test {

    @Autowired
    private Hash mD5;

    @Test
    void hash() {
        log.info(mD5.hash(Fish.cryptographyRU())); // todo подругому
    }

    @Test
    void uniquenessTest() {
        String hash1 = mD5.hash(Fish.cryptographyRU());
        String hash2 = mD5.hash(Fish.cryptographyRU());
        assertEquals(hash1, hash2);
    }
}