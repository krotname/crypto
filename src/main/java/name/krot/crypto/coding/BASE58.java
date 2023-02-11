package name.krot.crypto.coding;

import lombok.extern.slf4j.Slf4j;
import org.bitcoinj.core.Base58;

@Slf4j
public class BASE58 implements Coder {
    @Override

    public String encode(String string) {
        return Base58.encode(string.getBytes());
    }

    @Override
    public String decode(String string) {
        return new String(Base58.decode(string));
    }


}

