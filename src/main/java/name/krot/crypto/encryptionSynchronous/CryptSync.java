package name.krot.crypto.encryptionSynchronous;

public interface CryptSync {
    String encrypt(String string, String password, String salt, String iv);

    String decrypt(String string, String password, String salt, String iv);
}
