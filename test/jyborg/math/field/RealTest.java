package jyborg.math.field;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import jyborg.math.alg.field.Real;

class RealTest {
    static private final double d1 = 42.42;
    static private final double d2 = 0.42;
    static private final double NAN = Double.NaN;

    @SuppressWarnings("deprecation")
    @Test
    void test1() {
        final Real a = new Real(d1);
        assertEquals(d1, a.getV());
    }

    @SuppressWarnings("deprecation")
    @Test
    void test2() {
        final Real a = new Real(NAN);
        assertEquals(NAN, a.getV());
        assert (a.isNan());
    }

    @SuppressWarnings("deprecation")
    @Test
    void addTest1() {
        final Real a = new Real(d1);
        final Real b = new Real(d2);
        final Real c = a.add(b);
        assertEquals(d1 + d2, c.getV());
    }

    @SuppressWarnings("deprecation")
    @Test
    void mulTest1() {
        final Real a = new Real(d1);
        final Real b = new Real(d2);
        final Real c = a.mul(b);
        assertEquals(d1 * d2, c.getV());
    }

    @SuppressWarnings("deprecation")
    @Test
    void negTest1() {
        final Real a = new Real(d1).neg();
        assertEquals(-d1, a.getV());
    }

    @SuppressWarnings("deprecation")
    @Test
    void invTest1() {
        final Real a = new Real(d1).inv();
        assertEquals(1.0 / d1, a.getV());
    }

    @SuppressWarnings("deprecation")
    @Test
    void invTest2() {
        final Real a = new Real(0.0).inv();
        assertEquals(NAN, a.getV());
        assert (a.isNan());
    }

    @SuppressWarnings("deprecation")
    @Test
    void sqrtTest1() {
        final Real a = new Real(d1).sqr();
        assertEquals(Math.sqrt(d1), a.getV());
    }

    @SuppressWarnings("deprecation")
    @Test
    void sqrtTest2() {
        final Real a = new Real(-42.42).sqr();
        assertEquals(NAN, a.getV());
        assert (a.isNan());
    }

}
