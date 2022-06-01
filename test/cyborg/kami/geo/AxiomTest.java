package cyborg.kami.geo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import cyborg.math.alg.field.Frac;
import cyborg.math.alg.ring.Split;

public class AxiomTest {

    @Test
    void axiom1Test1() {
        final Pt<Frac> p1 = pt(0L, 100L);
        final Pt<Frac> r = pt(-100L, -200L);

        Line<Frac, Pt<Frac>> line = Axiom.apply(p1, r);
        assertEquals(
                new Line<Frac, Pt<Frac>>(
                        pt(-50L, -50L),
                        p1.dir(r)),
                line);
    }

    @Test
    void axiom4Test1() {
        final Pt<Frac> p = pt(121L, 200L);
        final Pt<Frac> q = pt(-79L, -200L);
        final Pt<Frac> r = pt(0L, 0L);

        Line<Frac, Pt<Frac>> line = Axiom.apply(
                new Seg<Frac, Pt<Frac>>(
                        p,
                        q),
                r);
        assertEquals(
                new Line<Frac, Pt<Frac>>(
                        pt(100L, -50L),
                        p.dir(q).n()),
                line);
    }

    @Test
    void axiom2Test1() {
        final Pt<Frac> p1 = pt(0L, 200L);
        final Pt<Frac> p2 = pt(-200L, -200L);

        Line<Frac, Pt<Frac>> line = Axiom.apply(
                new Seg<Frac, Pt<Frac>>(
                        p1,
                        p2));
        assertEquals(
                new Line<Frac, Pt<Frac>>(
                        pt(0L, -50L),
                        p1.dir(p2).n()),
                line);
    }

    @Test
    void axiom3Test1() {
        final Pt<Frac> p1 = pt(-200L, 0L);
        final Pt<Frac> p2 = pt(150L, 50L);
        final Pt<Frac> q1 = pt(-150L, -50L);
        final Pt<Frac> q2 = pt(184L, 16L);

        Line<Frac, Pt<Frac>> line = Axiom.apply(
                new Seg<Frac, Pt<Frac>>(
                        p1,
                        q1),
                new Seg<Frac, Pt<Frac>>(
                        p2,
                        q2),
                false);
        assertEquals(
                new Line<Frac, Pt<Frac>>(
                        pt(-25L, 25L),
                        dir(1L, -1L)),
                line);
    }

    @Test
    void axiom3Test2() {
        final Pt<Split<Frac>> p1 = split(50L, 200L);
        final Pt<Split<Frac>> p2 = split(150L, 100L);
        final Pt<Split<Frac>> q1 = split(0L, 150L);
        final Pt<Split<Frac>> q2 = split(200L, 100L);

        Line<Split<Frac>, Pt<Split<Frac>>> line = Axiom.apply(
                new Seg<Split<Frac>, Pt<Split<Frac>>>(
                        p1,
                        q1),
                new Seg<Split<Frac>, Pt<Split<Frac>>>(
                        p2,
                        q2),
                false);
        assertEquals(
                new Line<Split<Frac>, Pt<Split<Frac>>>(
                        split(-50L, 100L),
                        split(1L, 0L, 1L, 1L).dir()),
                line);
    }

    @Test
    void axiom3Test3() {
        final Pt<Split<Frac>> p1 = split(50L, 200L);
        final Pt<Split<Frac>> p2 = split(150L, 100L);
        final Pt<Split<Frac>> q1 = split(0L, 150L);
        final Pt<Split<Frac>> q2 = split(200L, 100L);

        Line<Split<Frac>, Pt<Split<Frac>>> line = Axiom.apply(
                new Seg<Split<Frac>, Pt<Split<Frac>>>(
                        p1,
                        q1),
                new Seg<Split<Frac>, Pt<Split<Frac>>>(
                        p2,
                        q2),
                true);
        assertEquals(
                new Line<Split<Frac>, Pt<Split<Frac>>>(
                        split(-50L, 100L),
                        split(1L, 1L, 1L, 0L).dir()),
                line);
    }

    @Test
    void axiom5Test1() {
        final Pt<Split<Frac>> p1 = split(200L, -50L, 3L);
        final Pt<Split<Frac>> p2 = split(-100L, -100L, 3L);
        final Pt<Split<Frac>> q2 = split(-100L, 150L, 3L);
        final Pt<Split<Frac>> r = split(0L, -50L, 3L);

        Line<Split<Frac>, Pt<Split<Frac>>> line = Axiom.apply(
                p1,
                new Seg<Split<Frac>, Pt<Split<Frac>>>(
                        p2,
                        q2),
                r,
                false);
        assertEquals(
                new Line<Split<Frac>, Pt<Split<Frac>>>(
                        r,
                        split(1L, 1L, 3L).dir()),
                line);
    }

    @Test
    void axiom5Test2() {
        final Pt<Split<Frac>> p1 = split(200L, -50L, 3L);
        final Pt<Split<Frac>> p2 = split(-100L, -100L, 3L);
        final Pt<Split<Frac>> q2 = split(-100L, 150L, 3L);
        final Pt<Split<Frac>> r = split(0L, -50L, 3L);

        Line<Split<Frac>, Pt<Split<Frac>>> line = Axiom.apply(
                p1,
                new Seg<Split<Frac>, Pt<Split<Frac>>>(
                        p2,
                        q2),
                r,
                true);
        assertEquals(
                new Line<Split<Frac>, Pt<Split<Frac>>>(
                        r,
                        split(1L, -1L, 3L).dir()),
                line);
    }

    @Test
    void axiom5Test3() {
        final Pt<Split<Frac>> p1 = split(50L, -50L, 3L);
        final Pt<Split<Frac>> p2 = split(-100L, -100L, 3L);
        final Pt<Split<Frac>> q2 = split(-100L, 150L, 3L);
        final Pt<Split<Frac>> r = split(0L, -50L, 3L);

        Line<Split<Frac>, Pt<Split<Frac>>> line = Axiom.apply(
                p1,
                new Seg<Split<Frac>, Pt<Split<Frac>>>(
                        p2,
                        q2),
                r,
                true);
        assertEquals(
                null,
                line);
    }

    private static Pt<Split<Frac>> split(
            long x,
            long y) {
        final Pt<Split<Frac>> p1 = new Pt<Split<Frac>>(
                new Split<Frac>(
                        new Frac(x),
                        new Frac(2L)),
                new Split<Frac>(
                        new Frac(y),
                        new Frac(2L)));
        return p1;
    }

    private static Pt<Split<Frac>> split(
            long x,
            long y,
            long r) {
        final Pt<Split<Frac>> p1 = new Pt<Split<Frac>>(
                new Split<Frac>(
                        new Frac(x),
                        new Frac(r)),
                new Split<Frac>(
                        new Frac(y),
                        new Frac(r)));
        return p1;
    }

    private static Pt<Split<Frac>> split(
            long xa,
            long xb,
            long ya,
            long yb) {
        final Pt<Split<Frac>> p1 = new Pt<Split<Frac>>(
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

    private static Pt<Frac> pt(
            long x,
            long y) {
        return new Pt<Frac>(
                new Frac(x),
                new Frac(y));
    }
}