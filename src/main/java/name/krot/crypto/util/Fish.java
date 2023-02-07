package name.krot.crypto.util;

import lombok.experimental.UtilityClass;
import name.krot.crypto.exception.ResorceNotFoundException;
import org.apache.commons.io.FileUtils;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

@UtilityClass
public class Fish {
    public static String cryptographyEN() {
        return read("fish/CryptographyEN.txt");
    }

    public static String cryptographyRU() {
        return read("fish/CryptographyRU.txt");
    }

    public static String loremIpsum() {
        return read("fish/LoremIpsum.txt");
    }

    public static String loremIpsumLW() {
        return read("fish/LoremIpsumLW.txt");
    }

    public static String fish() {
        return read("fish/Fish.txt");
    }

    public static String fishLW() {
        return read("fish/FishLW.txt");
    }

    private static String read(String filename) {
        try {
            File file = ResourceUtils.getFile("classpath:" + filename);
            try (InputStream inputStream = FileUtils.openInputStream(file)) {
                return new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
            }
        } catch (IOException e) {
            throw new ResorceNotFoundException(e);
        }
    }
}
