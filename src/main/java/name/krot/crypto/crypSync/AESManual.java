package name.krot.crypto.crypSync;

import lombok.extern.slf4j.Slf4j;
import name.krot.crypto.exception.CryptException;
import name.krot.crypto.util.Constants;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.springframework.stereotype.Component;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;

@Slf4j
@Component
public class AESManual implements CryptSync {

    public static final String AES = "AES";
    public static final String PBKDF_2 = "PBKDF2WithHmacSHA1";
    public static final String PADDING = "AES/CBC/PKCS7Padding"; // todo "AES/GCM/NoPadding" смотреть в спринге
    public static final int ITERATION_COUNT = 65536;
    public static final String CP_1251 = "cp1251"; // todo в константы

    private static String getString(String password, String salt, String iv, int decryptMode, String string)
            throws NoSuchAlgorithmException, NoSuchPaddingException, UnsupportedEncodingException,
            InvalidKeySpecException, InvalidKeyException, InvalidAlgorithmParameterException,
            IllegalBlockSizeException, BadPaddingException {

        Security.addProvider(new BouncyCastleProvider());
        Cipher cipher = Cipher.getInstance(PADDING);
        KeySpec spec = new PBEKeySpec(password.toCharArray(), salt.getBytes(CP_1251),
                ITERATION_COUNT, Constants.KEY_LENGTH);
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(PBKDF_2);
        byte[] key = keyFactory.generateSecret(spec).getEncoded();
        SecretKeySpec keySpec = new SecretKeySpec(key, AES);

        IvParameterSpec ivSpec = new IvParameterSpec(iv.getBytes(CP_1251));

        cipher.init(decryptMode, keySpec, ivSpec);

        byte[] encValue = cipher.doFinal(string.getBytes(CP_1251));

        return new String(encValue);
    }

    @Override
    public String encrypt(String string, String password, String salt, String iv) {
        try {
            return getString(password, salt, iv, Cipher.ENCRYPT_MODE, string);

        } catch (NoSuchAlgorithmException | InvalidKeySpecException | InvalidAlgorithmParameterException |
                 IllegalBlockSizeException | BadPaddingException | InvalidKeyException | NoSuchPaddingException |
                 UnsupportedEncodingException e) {
            throw new CryptException(e);
        }
    }

    @Override
    public String decrypt(String string, String password, String salt, String iv) {
        try {
            return getString(password, salt, iv, Cipher.DECRYPT_MODE, string);

        } catch (NoSuchAlgorithmException | InvalidKeySpecException | InvalidAlgorithmParameterException |
                 IllegalBlockSizeException | BadPaddingException | InvalidKeyException | NoSuchPaddingException |
                 UnsupportedEncodingException e) {
            throw new CryptException(e);
        }
    }
}
