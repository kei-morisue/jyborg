package cyborg.math.field;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import cyborg.math.alg.field.Frac;

public class FieldTest {
    @SuppressWarnings("deprecation")
    @Test
    void xTest1() {
        final Frac a = new Frac(24, 3);
        final Frac b = a.mul(2);
        assertEquals(16, b.getN());
        assertEquals(1, b.getD());
    }

    @SuppressWarnings("deprecation")
    @Test
    void xTest2() {
        final Frac a = new Frac(24, 5);
        final Frac b = a.mul(2);
        assertEquals(48, b.getN());
        assertEquals(5, b.getD());
    }

    @SuppressWarnings("deprecation")
    @Test
    void xTest3() {
        final Frac a = new Frac(24, 5);
        final Frac b = a.mul(5);
        assertEquals(24, b.getN());
        assertEquals(1, b.getD());
    }

    @SuppressWarnings("deprecation")
    @Test
    void xTest4() {
        final Frac a = new Frac(24, 3);
        final Frac b = a.mul(-3);
        assertEquals(-24L, b.getN());
        assertEquals(1L, b.getD());
    }

    @SuppressWarnings("deprecation")
    @Test
    void xTest5() {
        final Frac a = new Frac(24, 5);
        final Frac b = a.mul(-5);
        assertEquals(-24L, b.getN());
        assertEquals(1L, b.getD());
    }

    @SuppressWarnings("deprecation")
    @Test
    void xTest6() {
        final Frac a = new Frac(24, 5);
        final Frac b = a.mul(0);
        assertEquals(0L, b.getN());
        assertEquals(1L, b.getD());
    }

    @SuppressWarnings("deprecation")
    @Test
    void xTest7() {
        final Frac a = new Frac(24, 5);
        final Frac b = a.mul(256);
        assertEquals(24L * 256L, b.getN());
        assertEquals(5L, b.getD());
    }

    @SuppressWarnings("deprecation")
    @Test
    void powTest1() {
        final Frac a = new Frac(24, 8);
        final Frac b = a.pow(2);
        assertEquals(9L, b.getN());
        assertEquals(1L, b.getD());
    }

    @SuppressWarnings("deprecation")
    @Test
    void powTest2() {
        final Frac a = new Frac(24, 5);
        final Frac b = a.pow(2);
        assertEquals(24L * 24L, b.getN());
        assertEquals(25L, b.getD());
    }

    @SuppressWarnings("deprecation")
    @Test
    void powTest3() {
        final Frac a = new Frac(24, 5);
        final Frac b = a.pow(-3);
        assertEquals(125L, b.getN());
        assertEquals(24L * 24L * 24L, b.getD());
    }

    @SuppressWarnings("deprecation")
    @Test
    void powTest4() {
        final Frac a = new Frac(24, 5);
        final Frac b = a.pow(0);
        assertEquals(1L, b.getN());
        assertEquals(1L, b.getD());
    }

    @SuppressWarnings("deprecation")
    @Test
    void powTest5() {
        final Frac a = new Frac(24, 5);
        final Frac b = a.pow(-0);
        assertEquals(1L, b.getN());
        assertEquals(1L, b.getD());
    }

    @SuppressWarnings("deprecation")
    @Test
    void divTest1() {
        final Frac a = new Frac(24, 5);
        final Frac b = a.div(5);
        assertEquals(24L, b.getN());
        assertEquals(25L, b.getD());
    }

    @Test
    void divTest2() {
        final Frac a = new Frac(24, 5);
        final Frac b = a.div(0);
        assertEquals(b.nan(), b);
    }
}
