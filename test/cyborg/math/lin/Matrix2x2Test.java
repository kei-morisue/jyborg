package cyborg.math.lin;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import cyborg.kami.geo.Dir;
import cyborg.math.alg.field.Frac;
import cyborg.math.alg.lin.AbstractM2x2;
import cyborg.math.alg.lin.M2x2;

public class Matrix2x2Test {
    private static Dir<Frac> u = dir(4L, 3L);
    private static Dir<Frac> v = dir(3L, -2L);
    private static AbstractM2x2<Frac, Dir<Frac>> m = mx(
            u,
            v);
    private static Dir<Frac> s = dir(-5L, 4L);
    private static Dir<Frac> t = dir(1L, -12L);
    private static AbstractM2x2<Frac, Dir<Frac>> n = mx(
            s,
            t);

    @Test
    void zeroTest1() {
        AbstractM2x2<Frac, Dir<Frac>> c = m.zero();
        assertEquals(mx(
                dir(0L, 0L),
                dir(0L, 0L)), c);
    }

    @Test
    void addTest1() {
        AbstractM2x2<Frac, Dir<Frac>> c = m.add(n);
        assertEquals(mx(
                dir(-1L, 7L),
                dir(4L, -14L)), c);
    }

    @Test
    void negTest1() {
        AbstractM2x2<Frac, Dir<Frac>> c = m.neg();
        assertEquals(mx(
                dir(-4L, -3L),
                dir(-3L, 2L)), c);
    }

    @Test
    void scaleTest1() {
        AbstractM2x2<Frac, Dir<Frac>> c = m.scale(new Frac(3L));
        assertEquals(mx(
                dir(12L, 9L),
                dir(9L, -6L)), c);
    }

    @Test
    void applyTest1() {
        Dir<Frac> c = m.apply(u.n());
        assertEquals(dir(
                new Frac(0L),
                u.n().prd(v)), c);
    }

    @Test
    void applyTest2() {
        AbstractM2x2<Frac, Dir<Frac>> c = m.apply(n);
        assertEquals(mx(
                dir(-17L, -20L),
                dir(-17L, 36L)), c);
    }

    @Test
    void idtTest1() {
        AbstractM2x2<Frac, Dir<Frac>> c = m.idt();
        assertEquals(mx(
                dir(1L, 0L),
                dir(0L, 1L)), c);
    }

    @Test
    void detTest1() {
        assertEquals(new Frac(-17L), m.det());
        assertEquals(new Frac(56L), n.det());
    }

    @Test
    void invTest1() {
        assertEquals(mx(
                dir(-12L, -4L),
                dir(-1L, -5L)).scale(n.det().inv()), n.inv());
    }

    @Test
    void trspsTest1() {
        AbstractM2x2<Frac, Dir<Frac>> c = n.trps();
        assertEquals(mx(
                dir(-5L, 1L),
                dir(4L, -12L)), c);
    }

    private static Dir<Frac> dir(long x, long y) {
        return new Dir<Frac>(
                new Frac(x),
                new Frac(y));
    }

    private static Dir<Frac> dir(Frac x, Frac y) {
        return new Dir<Frac>(x, y);
    }

    private static AbstractM2x2<Frac, Dir<Frac>> mx(
            Dir<Frac> x,
            Dir<Frac> y) {
        return new M2x2<Frac, Dir<Frac>>(
                x,
                y);
    }
}