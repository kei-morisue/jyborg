package jyborg.math.field;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import jyborg.math.alg.field.Frac;

public class FieldTest {
    @SuppressWarnings("deprecation")
    @Test
    void xTest1() {
        final Frac a = new Frac(24, 3);
        final Frac b = a.x(2);
        assertEquals(16, b.getN());
        assertEquals(1, b.getD());
    }

    @SuppressWarnings("deprecation")
    @Test
    void xTest2() {
        final Frac a = new Frac(24, 5);
        final Frac b = a.x(2);
        assertEquals(48, b.getN());
        assertEquals(5, b.getD());
    }

    @SuppressWarnings("deprecation")
    @Test
    void xTest3() {
        final Frac a = new Frac(24, 5);
        final Frac b = a.x(5);
        assertEquals(24, b.getN());
        assertEquals(1, b.getD());
    }

    @SuppressWarnings("deprecation")
    @Test
    void xTest4() {
        final Frac a = new Frac(24, 3);
        final Frac b = a.x(-3);
        assertEquals(-24L, b.getN());
        assertEquals(1L, b.getD());
    }

    @SuppressWarnings("deprecation")
    @Test
    void xTest5() {
        final Frac a = new Frac(24, 5);
        final Frac b = a.x(-5);
        assertEquals(-24L, b.getN());
        assertEquals(1L, b.getD());
    }

    @SuppressWarnings("deprecation")
    @Test
    void xTest6() {
        final Frac a = new Frac(24, 5);
        final Frac b = a.x(0);
        assertEquals(0L, b.getN());
        assertEquals(1L, b.getD());
    }

    @SuppressWarnings("deprecation")
    @Test
    void xTest7() {
        final Frac a = new Frac(24, 5);
        final Frac b = a.x(256);
        assertEquals(24L * 256L, b.getN());
        assertEquals(5L, b.getD());
    }
}
