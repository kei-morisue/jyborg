package cyborg.kami.geo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import cyborg.math.alg.field.Frac;
import cyborg.math.alg.lin.U2;

class FoldTest {
    static final D0Point<Frac> s = pt(-1L, 4L);
    static final D0Point<Frac> e = pt(5L, 12L);
    static final Fold<Frac> f = f(s, e);

    @SuppressWarnings("deprecation")
    @Test
    void foldTest1() {
        assertEquals(
                new Fold<Frac>(
                        mx(
                                dir(
                                        new Frac(-28, 100),
                                        new Frac(96, 100)),
                                true),
                        dir(
                                new Frac(-512, 100),
                                new Frac(384, 100))),
                f);
    }

    @SuppressWarnings("deprecation")
    @Test
    void foldTest2() {
        final D0Point<Frac> p0 = pt(-1L, -1L);
        final D0Point<Frac> p1 = pt(-1L, 1L);
        final D0Point<Frac> p2 = pt(1L, 1L);
        final D0Vertex<Frac> v0 = new D0Vertex<Frac>(
                f(-6L, 5L),
                f(-6L, 5L),
                p0);
        final D0Vertex<Frac> v1 = new D0Vertex<Frac>(
                f(0L, 1L),
                f(2L, 5L),
                p1);
        final D0Vertex<Frac> v2 = new D0Vertex<Frac>(
                f(8L, 5L),
                f(-4L, 5L),
                p2);

        assertEquals(
                new Fold<Frac>(
                        mx(
                                dir(
                                        f(4L, 5L),
                                        f(3L, 5L)),
                                false),
                        dir(
                                f(1L, 5L),
                                f(-1L, 1L))),
                new Fold<Frac>(
                        v0,
                        v1,
                        v2));
    }

    private static D0Point<Frac> pt(
            long x, long y) {
        return new D0Point<Frac>(
                new Frac(x),
                new Frac(y));
    }

    private static Frac f(
            long n, long d) {
        return new Frac(n, d);
    }

    private static Fold<Frac> f(
            D0Point<Frac> s,
            D0Point<Frac> e) {
        return new Fold<Frac>(s, e);
    }

    private static Dir<Frac> dir(Frac x, Frac y) {
        return new Dir<Frac>(x, y);
    }

    private static U2<Frac, Dir<Frac>> mx(
            Dir<Frac> d, boolean isNegDet) {
        return new U2<Frac, Dir<Frac>>(
                d,
                isNegDet);
    }
}
