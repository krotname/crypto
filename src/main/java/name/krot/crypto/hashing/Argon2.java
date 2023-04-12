package name.krot.crypto.hashing;

import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;

public class Argon2 implements Hash<String, String> {
    private final Argon2PasswordEncoder encoder = Argon2PasswordEncoder.defaultsForSpringSecurity_v5_8();

    @Override
    public String hash(String s) {
        return encoder.encode(s);
    }

    public boolean matches(String string, String hash) {
        return encoder.matches(string, hash);
    }
}
