package name.krot.crypto.other;

import lombok.extern.slf4j.Slf4j;
import name.krot.crypto.ShowExecutionTime;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.test.annotation.DirtiesContext;

import java.math.BigDecimal;
import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
@TestMethodOrder(MethodOrderer.MethodName.class)
@DirtiesContext(methodMode= DirtiesContext.MethodMode.AFTER_METHOD)
public class BigDecimalTest extends ShowExecutionTime {
    public static final int COUNT = 100_000_000;

    @Test
    public void testBigDecimalDeserializeConcat() {                                                     //COUNT = 100_000_000
        for (int i = 0; i < COUNT; i++) {BigDecimal bd = new BigDecimal("123" + "." + "45600");}}

    @Test
    public void testBigDecimalDeserializeNotConcat() {
        for (int i = 0; i < COUNT; i++) {BigDecimal bd = new BigDecimal("123.45600");}}
    @Test
    public void testBigDecimalDeserializeConstructAndValueOf() {
        for (int i = 0; i < COUNT; i++) {BigDecimal bd = new BigDecimal(BigInteger.valueOf(123456000), 5);}}
    @Test
    public void testBigDecimalDeserializeConstructAndValueOfx2() {
        for (int i = 0; i < COUNT; i++) {BigDecimal bd = new BigDecimal(BigInteger.valueOf(Long.parseLong("12345600")), 5);}}
    @Test
    public void testBigDecimalDeserializeValueOf() {
        for (int i = 0; i < COUNT; i++) {BigDecimal bd = BigDecimal.valueOf(12345600, 5);}}
    @Test
    @Disabled
    public void testBigDecimalCorrect() {
        BigDecimal bd1 = BigDecimal.valueOf(123456000, 6);
        BigDecimal bd2 = new BigDecimal("123.456000");
        assertEquals(0, bd1.compareTo(bd2));
    }

}
