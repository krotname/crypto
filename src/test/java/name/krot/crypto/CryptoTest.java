package name.krot.crypto;

import lombok.extern.slf4j.Slf4j;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;

import static org.junit.jupiter.api.Assertions.assertEquals;


@Slf4j
public class CryptoTest {

    @Test
    @DisplayName("Загрузка рыбы")
    void testReadFish() {
        assertEquals("""
                Равным образом, внедрение современных методик позволяет выполнить важные задания по разработке кластеризации усилий.
                Противоположная точка зрения подразумевает, что многие известные личности представляют собой не что иное,
                как квинтэссенцию победы маркетинга над разумом и должны быть своевременно верифицированы.
                С учётом сложившейся международной обстановки, перспективное планирование позволяет выполнить важные
                задания по разработке системы обучения кадров, соответствующей насущным потребностям.""",
                Util.readFish());
    }

    @Test
    @DisplayName("AES зашифровка и расшифровка")
    void testAESCrypto() throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException, InvalidKeySpecException {

        Security.addProvider(new BouncyCastleProvider());
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16]; // todo разная соль?
        random.nextBytes(salt);
        KeySpec spec = new PBEKeySpec("password".toCharArray(), salt,
                65536, 256); // AES-256
        SecretKeyFactory f = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        byte[] key = f.generateSecret(spec).getEncoded();
        SecretKeySpec keySpec = new SecretKeySpec(key, "AES");
        byte[] ivBytes = new byte[16];
        random.nextBytes(ivBytes);
        IvParameterSpec iv = new IvParameterSpec(ivBytes);
        cipher.init(Cipher.ENCRYPT_MODE, keySpec, iv);

        byte[] plainText = Util.readFish().getBytes(StandardCharsets.UTF_8);

        byte[] encValue = cipher.doFinal(plainText);

/*        byte[] finalCiphertext = new byte[encValue.length+2*16];
        System.arraycopy(ivBytes, 0, finalCiphertext, 0, 16);
        System.arraycopy(salt, 0, finalCiphertext, 16, 16);
        System.arraycopy(encValue, 0, finalCiphertext, 32, encValue.length);*/

        cipher.init(Cipher.DECRYPT_MODE, keySpec, iv);

        byte[] decryptValue = cipher.doFinal(encValue);
        String decryptString = new String(decryptValue, StandardCharsets.UTF_8);
        assertEquals(Util.readFish(), decryptString);
    }

}
