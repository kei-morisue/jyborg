package cyborg.math.lin;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import cyborg.kami.geo.Dir;
import cyborg.math.alg.field.Frac;
import cyborg.math.alg.lin.Matrix2x2;

public class Matrix2x2Test {
    private static Dir<Frac> u = dir(4L, 3L);
    private static Dir<Frac> v = dir(3L, -2L);
    private static Matrix2x2<Frac, Dir<Frac>> m = mx(
            u,
            v);
    private static Dir<Frac> s = dir(-5L, 4L);
    private static Dir<Frac> t = dir(1L, -12L);
    private static Matrix2x2<Frac, Dir<Frac>> n = mx(
            s,
            t);

    @SuppressWarnings("deprecation")
    @Test
    void zeroTest1() {
        Matrix2x2<Frac, Dir<Frac>> c = m.zero();
        assertEquals(dir(0L, 0L), c.getAb());
        assertEquals(dir(0L, 0L), c.getCd());
    }

    @SuppressWarnings("deprecation")
    @Test
    void addTest1() {
        Matrix2x2<Frac, Dir<Frac>> c = m.add(n);
        assertEquals(dir(-1L, 7L), c.getAb());
        assertEquals(dir(4L, -14L), c.getCd());
    }

    @SuppressWarnings("deprecation")
    @Test
    void negTest1() {
        Matrix2x2<Frac, Dir<Frac>> c = m.neg();
        assertEquals(dir(-4L, -3L), c.getAb());
        assertEquals(dir(-3L, 2L), c.getCd());
    }

    @SuppressWarnings("deprecation")
    @Test
    void scaleTest1() {
        Matrix2x2<Frac, Dir<Frac>> c = m.scale(new Frac(3L));
        assertEquals(dir(12L, 9L), c.getAb());
        assertEquals(dir(9L, -6L), c.getCd());
    }

    @Test
    void applyTest1() {
        Dir<Frac> c = m.apply(u.n());
        assertEquals(dir(
                new Frac(0L),
                u.n().prd(v)), c);
    }

    @SuppressWarnings("deprecation")
    @Test
    void applyTest2() {
        Matrix2x2<Frac, Dir<Frac>> c = m.apply(n);
        assertEquals(
                dir(u.prd(s), u.prd(t)),
                c.getAb());
        assertEquals(
                dir(v.prd(s), v.prd(t)),
                c.getCd());
    }

    @SuppressWarnings("deprecation")
    @Test
    void idtTest1() {
        Matrix2x2<Frac, Dir<Frac>> c = m.idt();
        assertEquals(
                dir(1L, 0L),
                c.getAb());
        assertEquals(
                dir(0L, 1L),
                c.getCd());
    }

    @SuppressWarnings("deprecation")
    @Test
    void detTest1() {
        Frac c = m.det();
        assertEquals(new Frac(-17L), c);
    }

    @SuppressWarnings("deprecation")
    @Test
    void invTest1() {
        Matrix2x2<Frac, Dir<Frac>> c = n.inv();
        Frac inv = n.det().inv();
        assertEquals(
                dir(-12L, -4L).scale(inv),
                c.getAb());
        assertEquals(
                dir(-1L, -5L).scale(inv),
                c.getCd());
    }

    @SuppressWarnings("deprecation")
    @Test
    void trspsTest1() {
        Matrix2x2<Frac, Dir<Frac>> c = n.trps();
        assertEquals(
                dir(-5L, 1L),
                c.getAb());
        assertEquals(
                dir(4L, -12L),
                c.getCd());
    }

    private static Dir<Frac> dir(long x, long y) {
        return new Dir<Frac>(
                new Frac(x),
                new Frac(y));
    }

    private static Dir<Frac> dir(Frac x, Frac y) {
        return new Dir<Frac>(x, y);
    }

    private static Matrix2x2<Frac, Dir<Frac>> mx(
            Dir<Frac> x,
            Dir<Frac> y) {
        return new Matrix2x2<Frac, Dir<Frac>>(
                x,
                y);
    }
}