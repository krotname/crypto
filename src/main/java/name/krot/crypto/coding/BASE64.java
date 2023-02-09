package name.krot.crypto.coding;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Base64;

@Slf4j
@Component
public class BASE64 implements Coder {
    @Override
    public String encode(String string) {
        return Base64.getEncoder().encodeToString(string.getBytes());
    }

    @Override
    public String decode(String string) {
        return new String(Base64.getDecoder().decode(string));
    }


}
