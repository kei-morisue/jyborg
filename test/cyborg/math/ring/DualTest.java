package cyborg.math.ring;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import cyborg.math.alg.field.Frac;
import cyborg.math.alg.ring.Dual;

class DualTest {
    private static final Frac K = new Frac(16);
    private static final Frac X = new Frac(9);
    private static final Dual<Frac> KONST = Dual.konst(K);
    private static final Dual<Frac> IDENT = new Dual<Frac>(X);
    private static final Frac ONE = K.unit();
    private static final Frac TWO = ONE.add(ONE);
    private static final Frac ZERO = K.zero();

    @SuppressWarnings("deprecation")
    @Test
    void test1() {
        assertEquals(K, KONST.getA());
        assertEquals(ZERO, KONST.getB());
    }

    @SuppressWarnings("deprecation")
    @Test
    void test2() {
        assertEquals(X, IDENT.getA());
        assertEquals(ONE, IDENT.getB());
    }

    @SuppressWarnings("deprecation")
    @Test
    void addTest1() {
        final Dual<Frac> c = KONST.add(KONST);
        assertEquals(K.add(K), c.getA());
        assertEquals(ZERO, c.getB());
    }

    @SuppressWarnings("deprecation")
    @Test
    void addTest2() {
        final Dual<Frac> c = IDENT.add(KONST);
        assertEquals(K.add(X), c.getA());
        assertEquals(ONE, c.getB());
    }

    @SuppressWarnings("deprecation")
    @Test
    void addTest3() {
        final Dual<Frac> c = IDENT.add(IDENT);
        assertEquals(X.add(X), c.getA());
        assertEquals(TWO, c.getB());
    }

    @SuppressWarnings("deprecation")
    @Test
    void mulTest1() {
        final Dual<Frac> c = KONST.mul(KONST);
        assertEquals(K.pow(2), c.getA());
        assertEquals(ZERO, c.getB());
    }

    @SuppressWarnings("deprecation")
    @Test
    void mulTest2() {
        final Dual<Frac> c = IDENT.mul(KONST);
        assertEquals(K.mul(X), c.getA());
        assertEquals(K, c.getB());
    }

    @SuppressWarnings("deprecation")
    @Test
    void mulTest3() {
        final Dual<Frac> c = IDENT.mul(IDENT);
        assertEquals(X.pow(2), c.getA());
        assertEquals(X.x(2), c.getB());
    }

    @SuppressWarnings("deprecation")
    @Test
    void mulTest4() {
        final Dual<Frac> a = IDENT.mul(IDENT);
        final Dual<Frac> c = IDENT.mul(a);
        assertEquals(X.pow(3), c.getA());
        assertEquals(X.pow(2).x(3), c.getB());
    }

    @SuppressWarnings("deprecation")
    @Test
    void mulTest5() {
        final Dual<Frac> a = IDENT.mul(IDENT);
        final Dual<Frac> c = a.mul(KONST);
        assertEquals(K.mul(X.pow(2)), c.getA());
        assertEquals(K.mul(X).x(2), c.getB());
    }

    @SuppressWarnings("deprecation")
    @Test
    void negTest1() {
        final Dual<Frac> a = KONST.neg();
        assertEquals(K.neg(), a.getA());
        assertEquals(ZERO, a.getB());
    }

    @SuppressWarnings("deprecation")
    @Test
    void negTest2() {
        final Dual<Frac> a = IDENT.neg();
        assertEquals(X.neg(), a.getA());
        assertEquals(ONE.neg(), a.getB());
    }

    @SuppressWarnings("deprecation")
    @Test
    void invTest1() {
        final Dual<Frac> a = KONST.inv();
        assertEquals(K.inv(), a.getA());
        assertEquals(ZERO, a.getB());
    }

    @SuppressWarnings("deprecation")
    @Test
    void invTest2() {
        final Dual<Frac> a = IDENT.inv();
        assertEquals(X.inv(), a.getA());
        assertEquals(X.pow(-2).neg(), a.getB());
    }

    @SuppressWarnings("deprecation")
    @Test
    void invTest3() {
        final Dual<Frac> a = IDENT.add(KONST).inv();
        assertEquals(K.add(X).inv(), a.getA());
        assertEquals(
                K.add(X).pow(-2).neg(),
                a.getB());
    }

    @SuppressWarnings("deprecation")
    @Test
    void invTest4() {
        final Dual<Frac> a = IDENT.mul(IDENT).inv();
        assertEquals(X.pow(-2), a.getA());
        assertEquals(X.pow(-3).x(-2), a.getB());
    }

    @SuppressWarnings("deprecation")
    @Test
    void invTest5() {
        final Dual<Frac> a = KONST.mul(IDENT).mul(IDENT).inv();
        Frac x2k = X.pow(2).mul(K);
        Frac x3k = X.mul(x2k);
        assertEquals(x2k.inv(), a.getA());
        assertEquals(x3k.inv().x(-2), a.getB());
    }

    @SuppressWarnings("deprecation")
    @Test
    void invTest6() {
        final Dual<Frac> a = new Dual<Frac>(X.zero()).inv();
        assertEquals(X.nan(), a.getA());
        assertEquals(X.nan(), a.getB());
        assert (a.isNan());

    }

    @SuppressWarnings("deprecation")
    @Test
    void sqrtTest1() {
        final Dual<Frac> a = KONST.sqr();
        assertEquals(K.sqr(), a.getA());
        assertEquals(ZERO, a.getB());
    }

    @SuppressWarnings("deprecation")
    @Test
    void sqrtTest2() {
        final Dual<Frac> a = IDENT.sqr();
        Frac sqr = X.sqr();
        assertEquals(sqr, a.getA());
        assertEquals(sqr.x(2).inv(), a.getB());
    }

    @SuppressWarnings("deprecation")
    @Test
    void sqrtTest3() {
        final Dual<Frac> a = KONST.add(IDENT).sqr();
        Frac sqrXK = X.add(K).sqr();
        assertEquals(sqrXK, a.getA());
        assertEquals(sqrXK.x(2).inv(), a.getB());
    }

    @SuppressWarnings("deprecation")
    @Test
    void sqrtTest4() {
        final Dual<Frac> a = IDENT.mul(IDENT).sqr();
        assertEquals(X, a.getA());
        assertEquals(ONE, a.getB());
    }

    @SuppressWarnings("deprecation")
    @Test
    void sqrtTest5() {
        final Dual<Frac> a = new Dual<Frac>(X.neg()).sqr();
        assertEquals(X.nan(), a.getA());
        assertEquals(X.nan(), a.getB());
        assert (a.isNan());
    }
}
