package name.krot.crypto.hashing;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCrypt implements Hash<String, String> {

    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(4);

    @Override
    public String hash(String s) {
        return encoder.encode(s);
    }

    public boolean matches(String string, String hash) {
        return encoder.matches(string, hash);
    }
}
