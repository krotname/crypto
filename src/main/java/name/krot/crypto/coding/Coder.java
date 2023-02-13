package name.krot.crypto.coding;

import java.util.function.Function;

public interface Coder {
    String encode(String string);

    String decode(String string);
}
