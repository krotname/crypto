package name.krot.crypto.hashing;

import com.google.common.hash.Hashing;

import java.nio.charset.StandardCharsets;

public class SHA256_Guava implements Hash<String, String> {
    @Override
    public String hash(String s) {
        return Hashing.sha256()
                .hashString(s, StandardCharsets.UTF_8)
                .toString();
    }
}
