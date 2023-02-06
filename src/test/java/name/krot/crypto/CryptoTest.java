package name.krot.crypto;

import lombok.extern.slf4j.Slf4j;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.security.Security;

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
    @DisplayName("Загрузка криптопровайдера")
    void test1() {

        Security.addProvider(new BouncyCastleProvider());

    }

}
