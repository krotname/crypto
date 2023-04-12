package name.krot.crypto.hashing;

import org.apache.commons.codec.digest.DigestUtils;

public class SHA3_256_Apache implements Hash<String, String>{
    @Override
    public String hash(String s) {
        return new DigestUtils("SHA3-256").digestAsHex(s);
    }
}
