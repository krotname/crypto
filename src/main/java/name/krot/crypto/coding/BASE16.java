package name.krot.crypto.coding;

import org.springframework.stereotype.Component;

@Component
public class BASE16 implements Coder {
    private final org.apache.commons.codec.binary.Base16 base16 = new org.apache.commons.codec.binary.Base16();

    @Override
    public String encode(String string) {
        return base16.encodeToString(string.getBytes());
    }

    @Override
    public String decode(String string) {
        return new String(base16.decode(string.getBytes()));
    }
}
