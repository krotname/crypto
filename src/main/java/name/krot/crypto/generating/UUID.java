package name.krot.crypto.generating;

public class UUID implements Generator {
    @Override
    public String generate() {
        return String.valueOf(java.util.UUID.randomUUID());
    }
}
