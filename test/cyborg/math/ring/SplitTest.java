package cyborg.math.ring;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import cyborg.math.alg.field.Frac;
import cyborg.math.alg.ring.Split;

class SplitTest {
    private static final Frac R = new Frac(2L);
    private static final Frac NAN = new Frac(1L).nan();

    @SuppressWarnings("deprecation")
    @Test
    void addTest1() {
        final Split<Frac> c1 = split(1L, 0L);
        final Split<Frac> c2 = split(1L, 0L);
        final Split<Frac> c = c1.add(c2);
        assertEquals(
                new Frac(2L),
                c.getA());
        assertEquals(
                new Frac(0L),
                c.getB());
    }

    @SuppressWarnings("deprecation")
    @Test
    void addTest2() {
        final Split<Frac> c1 = split(0L, 1L);
        final Split<Frac> c2 = split(0L, 1L);
        final Split<Frac> c = c1.add(c2);
        assertEquals(
                new Frac(0L),
                c.getA());
        assertEquals(
                new Frac(2L),
                c.getB());
    }

    @SuppressWarnings("deprecation")
    @Test
    void addTest3() {
        final Split<Frac> c1 = split(1L, 0L);
        final Split<Frac> c2 = split(0L, 1L);
        final Split<Frac> c = c1.add(c2);
        assertEquals(
                new Frac(1L),
                c.getA());
        assertEquals(
                new Frac(1L),
                c.getB());
    }

    @SuppressWarnings("deprecation")
    @Test
    void addTest4() {
        final Split<Frac> c1 = split(1L, 1L);
        final Split<Frac> c2 = split(0L, 1L);
        final Split<Frac> c = c1.add(c2);
        assertEquals(
                new Frac(1L),
                c.getA());
        assertEquals(
                new Frac(2L),
                c.getB());
    }

    @SuppressWarnings("deprecation")
    @Test
    void mulTest1() {
        final Split<Frac> c1 = split(1L, 0L);
        final Split<Frac> c2 = split(1L, 0L);
        final Split<Frac> c = c1.mul(c2);
        assertEquals(
                new Frac(1L),
                c.getA());
        assertEquals(
                new Frac(0L),
                c.getB());
    }

    @SuppressWarnings("deprecation")
    @Test
    void mulTest2() {
        final Split<Frac> c1 = split(0L, 1L);
        final Split<Frac> c2 = split(0L, 1L);
        final Split<Frac> c = c1.mul(c2);
        assertEquals(
                new Frac(2L),
                c.getA());
        assertEquals(
                new Frac(0L),
                c.getB());
    }

    @SuppressWarnings("deprecation")
    @Test
    void mulTest3() {
        final Split<Frac> c1 = split(1L, 0L);
        final Split<Frac> c2 = split(0L, 1L);
        final Split<Frac> c = c1.mul(c2);
        assertEquals(
                new Frac(0L),
                c.getA());
        assertEquals(
                new Frac(1L),
                c.getB());
    }

    @SuppressWarnings("deprecation")
    @Test
    void mulTest4() {
        final Split<Frac> c1 = split(1L, 1L);
        final Split<Frac> c2 = split(0L, 1L);
        final Split<Frac> c = c1.mul(c2);
        assertEquals(
                new Frac(2L),
                c.getA());
        assertEquals(
                new Frac(1L),
                c.getB());
    }

    @SuppressWarnings("deprecation")
    @Test
    void negTest1() {
        final Split<Frac> c1 = split(1L, 0L);
        final Split<Frac> c = c1.neg();
        assertEquals(
                new Frac(-1L),
                c.getA());
        assertEquals(
                new Frac(0L),
                c.getB());
    }

    @SuppressWarnings("deprecation")
    @Test
    void negTest2() {
        final Split<Frac> c1 = split(0L, 1L);
        final Split<Frac> c = c1.neg();
        assertEquals(
                new Frac(0L),
                c.getA());
        assertEquals(
                new Frac(-1L),
                c.getB());
    }

    @SuppressWarnings("deprecation")
    @Test
    void negTest4() {
        final Split<Frac> c1 = split(1L, 1L);
        final Split<Frac> c = c1.neg();
        assertEquals(
                new Frac(-1L),
                c.getA());
        assertEquals(
                new Frac(-1L),
                c.getB());
    }

    @SuppressWarnings("deprecation")
    @Test
    void invTest1() {
        final Split<Frac> c1 = split(1L, 0L);
        final Split<Frac> c = c1.inv();
        assertEquals(
                new Frac(1L),
                c.getA());
        assertEquals(
                new Frac(0L),
                c.getB());
    }

    @SuppressWarnings("deprecation")
    @Test
    void invTest2() {
        final Split<Frac> c1 = split(0L, 1L);
        final Split<Frac> c = c1.inv();
        assertEquals(
                new Frac(0L),
                c.getA());
        assertEquals(
                new Frac(1L, 2L),
                c.getB());
    }

    @SuppressWarnings("deprecation")
    @Test
    void invTest4() {
        final Split<Frac> c1 = split(1L, 1L);
        final Split<Frac> c = c1.inv();
        assertEquals(
                new Frac(-1L),
                c.getA());
        assertEquals(
                new Frac(1L),
                c.getB());
    }

    @SuppressWarnings("deprecation")
    @Test
    void invTest5() {
        final Split<Frac> c1 = split(0L, 0L);
        final Split<Frac> c = c1.inv();
        assertEquals(
                NAN,
                c.getA());
        assertEquals(
                NAN,
                c.getB());
        assert (c.isNan());
    }

    @SuppressWarnings("deprecation")
    @Test
    void sqrTest1() {
        final Split<Frac> c1 = split(-42L, 4242L);
        final Split<Frac> c = c1.sqr();
        assertEquals(
                NAN,
                c.getA());
        assertEquals(
                NAN,
                c.getB());
        assert (c.isNan());
    }

    @SuppressWarnings("deprecation")
    @Test
    void sqrTest2() {
        final Split<Frac> c1 = split(3L, 0L);
        final Split<Frac> c = c1.sqr();
        assertEquals(
                NAN,
                c.getA());
        assertEquals(
                NAN,
                c.getB());
        assert (c.isNan());
    }

    @SuppressWarnings("deprecation")
    @Test
    void sqrTest3() {
        final Split<Frac> c1 = split(4L, 0L);
        final Split<Frac> c = c1.sqr();
        assertEquals(
                new Frac(2L),
                c.getA());
        assertEquals(
                new Frac(0L),
                c.getB());
    }

    @SuppressWarnings("deprecation")
    @Test
    void sqrTest4() {
        final Split<Frac> c1 = split(18L, 0L);
        final Split<Frac> c = c1.sqr();
        assertEquals(
                new Frac(0L),
                c.getA());
        assertEquals(
                new Frac(3L),
                c.getB());
    }

    @SuppressWarnings("deprecation")
    @Test
    void sqrTest5() {
        final Split<Frac> c1 = split(2L, 3L);
        final Split<Frac> c = c1.sqr();
        assertEquals(
                NAN,
                c.getA());
        assertEquals(
                NAN,
                c.getB());
        assert (c.isNan());
    }

    @SuppressWarnings("deprecation")
    @Test
    void sqrTest6() {
        final Split<Frac> c1 = split(3L, 2L);
        final Split<Frac> c = c1.sqr();
        assertEquals(
                new Frac(1L),
                c.getA());
        assertEquals(
                new Frac(1L),
                c.getB());
    }

    @SuppressWarnings("deprecation")
    @Test
    void sqrTest7() {
        final Split<Frac> c1 = split(17L, 12L);
        final Split<Frac> c = c1.sqr();
        assertEquals(
                new Frac(3L),
                c.getA());
        assertEquals(
                new Frac(2L),
                c.getB());
    }

    @SuppressWarnings("deprecation")
    @Test
    void sqrTest8() {
        final Split<Frac> c1 = split(12L, 5L);
        final Split<Frac> c = c1.sqr();
        assertEquals(
                NAN,
                c.getA());
        assertEquals(
                NAN,
                c.getB());
        assert (c.isNan());
    }

    @SuppressWarnings("deprecation")
    @Test
    void sqrTest9() {
        final Split<Frac> c1 = split(9L, 6L);
        final Split<Frac> c = c1.sqr();
        assertEquals(
                NAN,
                c.getA());
        assertEquals(
                NAN,
                c.getB());
        assert (c.isNan());
    }

    @SuppressWarnings("deprecation")
    @Test
    void sqrTest0() {
        final Split<Frac> c1 = split(0L, 0L);
        final Split<Frac> c = c1.sqr();
        assertEquals(
                new Frac(0L),
                c.getA());
        assertEquals(
                new Frac(0L),
                c.getB());
    }

    private Split<Frac> split(final long a, final long b) {
        final Frac a2 = new Frac(a);
        final Frac b2 = new Frac(b);
        final Split<Frac> c2 = new Split<Frac>(
                a2,
                b2,
                R);
        return c2;
    }
}
