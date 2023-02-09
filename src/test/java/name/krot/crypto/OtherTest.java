package name.krot.crypto;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.security.SecureRandom;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

@Slf4j
public class OtherTest extends ShowExecutionTime {
    @Test
    public void randomIv() {
        SecureRandom random = new SecureRandom();
        byte[] ivBytes = new byte[16];
        random.nextBytes(ivBytes);
        String iv = new String(ivBytes);
        log.info(Arrays.toString(ivBytes));
        log.info(iv);
    }

    @Test
    public void byteToString() throws UnsupportedEncodingException {
        byte[] bytes = {12, 27, -7, 23, -44, -11, 34, 14, -127, -40, -29, -52, 32, -54, -77, -69};
        String stringFromBytes = new String(bytes);
        log.debug(stringFromBytes);
        byte[] bytesFromString = stringFromBytes.getBytes("cp1251");
        assertArrayEquals(bytes, bytesFromString);
    }

    @Test
    public void defaultCharset() {
        log.info(Charset.defaultCharset().toString()); // windows-1251 [cp5347, ansi-1251, cp1251]
    }

}
