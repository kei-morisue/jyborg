package cyborg.math.ring;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import cyborg.math.alg.field.Frac;
import cyborg.math.alg.ring.Complex;

class ComplexTest {
    private static final Complex<Frac> a = complex(2, 17);
    private static final Complex<Frac> b = complex(5, 3);

    @SuppressWarnings("deprecation")
    @Test
    void addTest1() {
        final Complex<Frac> c = a.add(b);
        assertEquals(
                new Frac(7L),
                c.getA());
        assertEquals(
                new Frac(20L),
                c.getB());
    }

    @SuppressWarnings("deprecation")
    @Test
    void mulTest1() {
        final Complex<Frac> c = a.mul(b);
        assertEquals(
                new Frac(10L - 51L),
                c.getA());
        assertEquals(
                new Frac(6L + 85L),
                c.getB());
    }

    @SuppressWarnings("deprecation")
    @Test
    void negTest1() {
        final Complex<Frac> c = a.neg();
        assertEquals(
                new Frac(-2),
                c.getA());
        assertEquals(
                new Frac(-17),
                c.getB());
    }

    @SuppressWarnings("deprecation")
    @Test
    void invTest1() {
        final Complex<Frac> c = a.inv();
        assertEquals(
                new Frac(2L, 293),
                c.getA());
        assertEquals(
                new Frac(-17L, 293),
                c.getB());
    }

    @SuppressWarnings("deprecation")
    @Test
    void invTest2() {
        final Complex<Frac> c1 = complex(0L, 0L);
        final Complex<Frac> c = c1.inv();

        assert (c.isNan());
    }

    @SuppressWarnings("deprecation")
    @Test
    void sqrTest1() {
        final Complex<Frac> c1 = complex(-42L, 4242L);
        final Complex<Frac> c = c1.sqr();
        assert (c.isNan());
    }

    @SuppressWarnings("deprecation")
    @Test
    void sqrTest2() {
        final Complex<Frac> c1 = complex(0L, 4L);
        final Complex<Frac> c = c1.sqr();
        assertEquals(
                new Frac(2L),
                c.getA());
        assertEquals(
                new Frac(2L),
                c.getB());
    }

    @SuppressWarnings("deprecation")
    @Test
    void cnjTest1() {
        final Complex<Frac> c = a.cnj();
        assertEquals(
                new Frac(2L),
                c.getA());
        assertEquals(
                new Frac(-17L),
                c.getB());
    }

    private static Complex<Frac> complex(
            final long a,
            final long b) {
        final Frac a2 = new Frac(a);
        final Frac b2 = new Frac(b);
        final Complex<Frac> c2 = new Complex<Frac>(
                a2,
                b2);
        return c2;
    }
}
