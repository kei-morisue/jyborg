package cyborg.kami.geo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import cyborg.math.alg.field.Frac;
import cyborg.math.alg.ring.Split;

public class AxiomTest {

    @Test
    void axiom1Test1() {
        final D0Point<Frac> p1 = pt(0L, 100L);
        final D0Point<Frac> r = pt(-100L, -200L);

        Line<Frac, D0Point<Frac>> line = Axiom.apply(p1, r);
        assertEquals(
                new Line<Frac, D0Point<Frac>>(
                        pt(-50L, -50L),
                        p1.dir(r)),
                line);
    }

    @Test
    void axiom4Test1() {
        final D0Point<Frac> p = pt(121L, 200L);
        final D0Point<Frac> q = pt(-79L, -200L);
        final D0Point<Frac> r = pt(0L, 0L);

        Line<Frac, D0Point<Frac>> line = Axiom.apply(
                new Seg<Frac, D0Point<Frac>>(
                        p,
                        q),
                r);
        assertEquals(
                new Line<Frac, D0Point<Frac>>(
                        pt(100L, -50L),
                        p.dir(q).n()),
                line);
    }

    @Test
    void axiom2Test1() {
        final D0Point<Frac> p1 = pt(0L, 200L);
        final D0Point<Frac> p2 = pt(-200L, -200L);

        Line<Frac, D0Point<Frac>> line = Axiom.apply(
                new Seg<Frac, D0Point<Frac>>(
                        p1,
                        p2));
        assertEquals(
                new Line<Frac, D0Point<Frac>>(
                        pt(0L, -50L),
                        p1.dir(p2).n()),
                line);
    }

    @Test
    void axiom3Test1() {
        final D0Point<Frac> p1 = pt(-200L, 0L);
        final D0Point<Frac> p2 = pt(150L, 50L);
        final D0Point<Frac> q1 = pt(-150L, -50L);
        final D0Point<Frac> q2 = pt(184L, 16L);

        Line<Frac, D0Point<Frac>> line = Axiom.apply(
                new Seg<Frac, D0Point<Frac>>(
                        p1,
                        q1),
                new Seg<Frac, D0Point<Frac>>(
                        p2,
                        q2),
                false);
        assertEquals(
                new Line<Frac, D0Point<Frac>>(
                        pt(-25L, 25L),
                        dir(1L, -1L)),
                line);
    }

    @Test
    void axiom3Test2() {
        final D0Point<Split<Frac>> p1 = split(50L, 200L);
        final D0Point<Split<Frac>> p2 = split(150L, 100L);
        final D0Point<Split<Frac>> q1 = split(0L, 150L);
        final D0Point<Split<Frac>> q2 = split(200L, 100L);

        Line<Split<Frac>, D0Point<Split<Frac>>> line = Axiom.apply(
                new Seg<Split<Frac>, D0Point<Split<Frac>>>(
                        p1,
                        q1),
                new Seg<Split<Frac>, D0Point<Split<Frac>>>(
                        p2,
                        q2),
                false);
        assertEquals(
                new Line<Split<Frac>, D0Point<Split<Frac>>>(
                        split(-50L, 100L),
                        split(1L, 0L, 1L, 1L).dir()),
                line);
    }

    @Test
    void axiom3Test3() {
        final D0Point<Split<Frac>> p1 = split(50L, 200L);
        final D0Point<Split<Frac>> p2 = split(150L, 100L);
        final D0Point<Split<Frac>> q1 = split(0L, 150L);
        final D0Point<Split<Frac>> q2 = split(200L, 100L);

        Line<Split<Frac>, D0Point<Split<Frac>>> line = Axiom.apply(
                new Seg<Split<Frac>, D0Point<Split<Frac>>>(
                        p1,
                        q1),
                new Seg<Split<Frac>, D0Point<Split<Frac>>>(
                        p2,
                        q2),
                true);
        assertEquals(
                new Line<Split<Frac>, D0Point<Split<Frac>>>(
                        split(-50L, 100L),
                        split(1L, 1L, 1L, 0L).dir()),
                line);
    }

    private static D0Point<Split<Frac>> split(
            long x,
            long y) {
        final D0Point<Split<Frac>> p1 = new D0Point<Split<Frac>>(
                new Split<Frac>(
                        new Frac(x),
                        new Frac(2L)),
                new Split<Frac>(
                        new Frac(y),
                        new Frac(2L)));
        return p1;
    }

    private static D0Point<Split<Frac>> split(
            long xa,
            long xb,
            long ya,
            long yb) {
        final D0Point<Split<Frac>> p1 = new D0Point<Split<Frac>>(
                new Split<Frac>(
                        new Frac(xa),
                        new Frac(xb),
                        new Frac(2L)),
                new Split<Frac>(
                        new Frac(ya),
                        new Frac(yb),
                        new Frac(2L)));
        return p1;
    }

    private static Dir<Frac> dir(
            long x,
            long y) {
        return new Dir<Frac>(
                new Frac(x),
                new Frac(y));
    }

    private static D0Point<Frac> pt(
            long x,
            long y) {
        return new D0Point<Frac>(
                new Frac(x),
                new Frac(y));
    }
}