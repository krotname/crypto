package name.krot.crypto;

import name.krot.crypto.util.Fish;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.security.SecureRandom;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FishTest {

    @Test
    @DisplayName("Загрузка рыбы Криптография EN")
    void testReadCryptographyEN() {
        assertEquals("Cryptography in practice", Fish.cryptographyEN());
    }

    @Test
    @DisplayName("Загрузка рыбы Криптография РУ")
    void testReadCryptographyRU() {
        assertEquals("Криптография на практике", Fish.cryptographyRU());
    }

    @Test
    @DisplayName("Загрузка рыбы с переносом строк")
    void testReadFishLW() {
        assertEquals("""
                        Равным образом, внедрение современных методик позволяет выполнить важные задания по разработке кластеризации усилий.
                        Противоположная точка зрения подразумевает, что многие известные личности представляют собой не что иное,
                        как квинтэссенцию победы маркетинга над разумом и должны быть своевременно верифицированы.
                        С учётом сложившейся международной обстановки, перспективное планирование позволяет выполнить важные
                        задания по разработке системы обучения кадров, соответствующей насущным потребностям.""",
                Fish.fishLW());
    }

}