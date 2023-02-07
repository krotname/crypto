package name.krot.crypto.encryptionSynchronous;


import name.krot.crypto.util.CryptoUtils;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * AESManual-GCM inputs - 12 bytes IV, need the same IV and secret keys for encryption and decryption.
 * <p>
 * The output consist of iv, encrypted content, and auth tag in the following format:
 * output = byte[] {i i i c c c c c c ...}
 * <p>
 * i = IV bytes
 * c = content bytes (encrypted content, auth tag)
 */
public class EncryptorAesGcm {

    private static final String ENCRYPT_ALGO = "AES/GCM/NoPadding";
    private static final int TAG_LENGTH_BIT = 128;
    private static final int IV_LENGTH_BYTE = 12;
    private static final int AES_KEY_BIT = 256;

    private static final Charset UTF_8 = StandardCharsets.UTF_8;

    // AESManual-GCM needs GCMParameterSpec
    public static byte[] encrypt(byte[] pText, SecretKey secret, byte[] iv) throws Exception {

        Cipher cipher = Cipher.getInstance(ENCRYPT_ALGO);
        cipher.init(Cipher.ENCRYPT_MODE, secret, new GCMParameterSpec(TAG_LENGTH_BIT, iv));
        byte[] encryptedText = cipher.doFinal(pText);
        return encryptedText;

    }

    // prefix IV length + IV bytes to cipher text
    public static byte[] encryptWithPrefixIV(byte[] pText, SecretKey secret, byte[] iv) throws Exception {

        byte[] cipherText = encrypt(pText, secret, iv);

        byte[] cipherTextWithIv = ByteBuffer.allocate(iv.length + cipherText.length)
                .put(iv)
                .put(cipherText)
                .array();
        return cipherTextWithIv;

    }

    public static String decrypt(byte[] cText, SecretKey secret, byte[] iv) throws Exception {

        Cipher cipher = Cipher.getInstance(ENCRYPT_ALGO);
        cipher.init(Cipher.DECRYPT_MODE, secret, new GCMParameterSpec(TAG_LENGTH_BIT, iv));
        byte[] plainText = cipher.doFinal(cText);
        return new String(plainText, UTF_8);

    }

    public static String decryptWithPrefixIV(byte[] cText, SecretKey secret) throws Exception {

        ByteBuffer bb = ByteBuffer.wrap(cText);

        byte[] iv = new byte[IV_LENGTH_BYTE];
        bb.get(iv);
        //bb.get(iv, 0, iv.length);

        byte[] cipherText = new byte[bb.remaining()];
        bb.get(cipherText);

        String plainText = decrypt(cipherText, secret, iv);
        return plainText;

    }

    public static void main3(String[] args) throws Exception {

        String OUTPUT_FORMAT = "%-30s:%s";

        String pText = "Hello World AESManual-GCM, Welcome to Cryptography!";

        // encrypt and decrypt need the same key.
        // get AESManual 256 bits (32 bytes) key
        SecretKey secretKey = CryptoUtils.getAESKey(AES_KEY_BIT);

        // encrypt and decrypt need the same IV.
        // AESManual-GCM needs IV 96-bit (12 bytes)
        byte[] iv = CryptoUtils.getRandomNonce(IV_LENGTH_BYTE);

        byte[] encryptedText = EncryptorAesGcm.encryptWithPrefixIV(pText.getBytes(UTF_8), secretKey, iv);

        System.out.println("\n------ AESManual GCM Encryption ------");
        System.out.printf((OUTPUT_FORMAT) + "%n", "Input (plain text)", pText);
        System.out.printf((OUTPUT_FORMAT) + "%n", "Key (hex)", CryptoUtils.hex(secretKey.getEncoded()));
        System.out.printf((OUTPUT_FORMAT) + "%n", "IV  (hex)", CryptoUtils.hex(iv));
        System.out.printf((OUTPUT_FORMAT) + "%n", "Encrypted (hex) ", CryptoUtils.hex(encryptedText));
        System.out.printf((OUTPUT_FORMAT) + "%n", "Encrypted (hex) (block = 16)", CryptoUtils.hexWithBlockSize(encryptedText, 16));

        System.out.println("\n------ AESManual GCM Decryption ------");
        System.out.printf((OUTPUT_FORMAT) + "%n", "Input (hex)", CryptoUtils.hex(encryptedText));
        System.out.printf((OUTPUT_FORMAT) + "%n", "Input (hex) (block = 16)", CryptoUtils.hexWithBlockSize(encryptedText, 16));
        System.out.printf((OUTPUT_FORMAT) + "%n", "Key (hex)", CryptoUtils.hex(secretKey.getEncoded()));

        String decryptedText = EncryptorAesGcm.decryptWithPrefixIV(encryptedText, secretKey);

        System.out.printf((OUTPUT_FORMAT) + "%n", "Decrypted (plain text)", decryptedText);

    }

}