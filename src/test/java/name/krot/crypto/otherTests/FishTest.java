package name.krot.crypto.otherTests;

import name.krot.crypto.codingTests.BaseCoderTest;
import name.krot.crypto.util.Fish;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FishTest extends BaseCoderTest {

    @Test
    void testReadCryptographyEN() {
        assertEquals("Cryptography in practice", Fish.cryptographyEN());
    }

    @Test
    void testReadCryptographyRU() {
        assertEquals("Криптография на практике", Fish.cryptographyRU());
    }

    @Test
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