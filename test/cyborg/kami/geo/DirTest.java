package cyborg.kami.geo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import cyborg.math.alg.field.Frac;
import cyborg.math.alg.lin.AbstractM2x2;
import cyborg.math.alg.lin.M2x2;

public class DirTest {
    private static Dir<Frac> u = dir(4L, 3L);
    private static Dir<Frac> v = dir(3L, -2L);

    @SuppressWarnings("deprecation")
    @Test
    void nrmTest1() {
        Frac c = u.nrm();
        assertEquals(5L, c.getN());
        assertEquals(1L, c.getD());
    }

    @Test
    void prdTest1() {
        Frac c = u.prd(v);
        assertEquals(new Frac(6L), c);
    }

    @SuppressWarnings("deprecation")
    @Test
    void scaleTest1() {
        Dir<Frac> c = u.scale(new Frac(3, 4));
        assertEquals(new Frac(3L), c.getX());
        assertEquals(new Frac(9L, 4L), c.getY());

    }

    @Test
    void nrmSqTest1() {
        Frac c = u.nrmSq();
        assertEquals(new Frac(25L), c);
    }

    @SuppressWarnings("deprecation")
    @Test
    void nTest1() {
        Dir<Frac> c = u.n();
        assertEquals(new Frac(-3L), c.getX());
        assertEquals(new Frac(4L), c.getY());
    }

    @Test
    void isPerpTest1() {
        assert (!u.isPerp(v));
        assert (u.isPerp(u.n()));
    }

    @Test
    void outTest1() {
        Frac c = u.out(v);
        assertEquals(new Frac(-17L), c);
    }

    @SuppressWarnings("deprecation")
    @Test
    void exTest1() {
        Dir<Frac> c = u.ex();
        assertEquals(new Frac(1L), c.getX());
        assertEquals(new Frac(0L), c.getY());
    }

    @SuppressWarnings("deprecation")
    @Test
    void eyTest1() {
        Dir<Frac> c = u.ey();
        assertEquals(new Frac(0L), c.getX());
        assertEquals(new Frac(1L), c.getY());
    }

    @Test
    void ketbraTest1() {
        M2x2<Frac, Dir<Frac>> c = u.ketbra(v);
        assertEquals(mx(
                dir(12L, -8L),
                dir(9L, -6L)), c);
    }

    private static Dir<Frac> dir(long x, long y) {
        return new Dir<Frac>(
                new Frac(x),
                new Frac(y));
    }

    private static AbstractM2x2<Frac, Dir<Frac>> mx(
            Dir<Frac> x,
            Dir<Frac> y) {
        return new M2x2<Frac, Dir<Frac>>(
                x,
                y);
    }
}