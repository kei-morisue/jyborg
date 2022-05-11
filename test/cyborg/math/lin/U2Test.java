package cyborg.math.lin;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import cyborg.kami.geo.Dir;
import cyborg.math.alg.field.Frac;
import cyborg.math.alg.lin.U2;

public class U2Test {
    private static Dir<Frac> u = dir(4L, 3L);
    private static U2<Frac, Dir<Frac>> m = mx(
            u,
            false);
    private static Dir<Frac> s = dir(-12L, 5L);
    private static U2<Frac, Dir<Frac>> n = mx(
            s,
            true);

    @SuppressWarnings("deprecation")
    @Test
    void zeroTest1() {
        assertEquals(
                m.nan(),
                m.zero());
    }

    @Test
    void addTest1() {
        assertEquals(
                m.nan(),
                m.add(n));
    }

    @Test
    void negTest1() {
        assertEquals(
                mx(u.neg(), false),
                m.neg());
    }

    @SuppressWarnings("deprecation")
    @Test
    void scaleTest1() {
        assertEquals(
                m.nan(),
                m.scale(new Frac(3L)));
    }

    @Test
    void applyTest1() {
        assertEquals(
                dir(
                        new Frac(0L),
                        new Frac(1L)),
                m.apply(u.n()));
    }

    @Test
    void applyTest2() {
        assertEquals(
                mx(
                        dir(-33L, 56L),
                        true),
                m.apply(n));
    }

    @Test
    void applyTest3() {
        assertEquals(
                mx(
                        dir(-63L, -16L),
                        true),
                n.apply(m));
    }

    @Test
    void applyTest4() {
        assertEquals(
                mx(
                        dir(1L, 0L),
                        false),
                n.apply(n.inv()));
    }

    @Test
    void applyTest5() {
        assertEquals(
                mx(
                        dir(1L, 0L),
                        false),
                m.apply(m.inv()));
    }

    @Test
    void idtTest1() {
        assertEquals(
                mx(
                        dir(1L, 0L),
                        false),
                m.idt());
    }

    @Test
    void detTest1() {
        assertEquals(new Frac(1L), m.det());
        assertEquals(new Frac(-1L), n.det());
    }

    @Test
    void invTest1() {
        assertEquals(n.trps(), n.inv());
        assertEquals(m.trps(), m.inv());
    }

    @Test
    void trspsTest1() {
        assertEquals(n, n.trps());
        assertEquals(mx(
                dir(4L, -3L),
                false), m.trps());
    }

    private static Dir<Frac> dir(long x, long y) {
        return dir(
                new Frac(x),
                new Frac(y));
    }

    private static Dir<Frac> dir(Frac x, Frac y) {
        return new Dir<Frac>(x, y).scale(x.pow(2).add(y.pow(2)).inv().sqr());
    }

    private static U2<Frac, Dir<Frac>> mx(
            Dir<Frac> x, boolean isNegDet) {
        return new U2<Frac, Dir<Frac>>(
                x,
                isNegDet);
    }
}