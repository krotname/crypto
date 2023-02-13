package name.krot.crypto.hashing;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;

@Slf4j
@Component
public class MD5 implements Hash<String,String> { // https://stackoverflow.com/questions/415953/how-can-i-generate-an-md5-hash-in-java
    @Override
    public String hash(String string) {
        return DigestUtils.md5DigestAsHex(string.getBytes(StandardCharsets.UTF_8));
    }
}
