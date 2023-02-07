package name.krot.crypto.coding;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Base64;

@Slf4j
@Component
public class BASE64 implements Coder {

    @Override
    public String encode(String string) {
        String encryptedValue = Base64.getEncoder().encodeToString(string.getBytes());

        return encryptedValue;
    }

    @Override
    public String decode(String string) {
        byte[] decode = Base64.getDecoder().decode(string);
        return new String(decode);
    }


}
