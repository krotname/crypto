package name.krot.crypto;

import lombok.experimental.UtilityClass;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@UtilityClass
public class Util {
    public static String readFish(){
        try {
            File file = ResourceUtils.getFile("classpath:fish.txt");
            return new String(Files.readAllBytes(file.toPath()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
