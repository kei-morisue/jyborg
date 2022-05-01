package jyborg.math;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import jyborg.math.alg.field.Dual;
import jyborg.math.alg.field.Frac;

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
        assertEquals(K, KONST.getV());
        assertEquals(ZERO, KONST.getD());
    }

    @SuppressWarnings("deprecation")
    @Test
    void test2() {
        assertEquals(X, IDENT.getV());
        assertEquals(ONE, IDENT.getD());
    }

    @SuppressWarnings("deprecation")
    @Test
    void addTest1() {
        final Dual<Frac> c = KONST.add(KONST);
        assertEquals(K.add(K), c.getV());
        assertEquals(ZERO, c.getD());
    }

    @SuppressWarnings("deprecation")
    @Test
    void addTest2() {
        final Dual<Frac> c = IDENT.add(KONST);
        assertEquals(K.add(X), c.getV());
        assertEquals(ONE, c.getD());
    }

    @SuppressWarnings("deprecation")
    @Test
    void addTest3() {
        final Dual<Frac> c = IDENT.add(IDENT);
        assertEquals(X.add(X), c.getV());
        assertEquals(TWO, c.getD());
    }

    @SuppressWarnings("deprecation")
    @Test
    void mulTest1() {
        final Dual<Frac> c = KONST.mul(KONST);
        assertEquals(K.mul(K), c.getV());
        assertEquals(ZERO, c.getD());
    }

    @SuppressWarnings("deprecation")
    @Test
    void mulTest2() {
        final Dual<Frac> c = IDENT.mul(KONST);
        assertEquals(K.mul(X), c.getV());
        assertEquals(K, c.getD());
    }

    @SuppressWarnings("deprecation")
    @Test
    void mulTest3() {
        final Dual<Frac> c = IDENT.mul(IDENT);
        assertEquals(X.mul(X), c.getV());
        assertEquals(X.add(X), c.getD());
    }

    @SuppressWarnings("deprecation")
    @Test
    void mulTest4() {
        final Dual<Frac> a = IDENT.mul(IDENT);
        final Dual<Frac> c = IDENT.mul(a);
        assertEquals(X.mul(X).mul(X), c.getV());
        assertEquals(X.mul(X).add(X.mul(X)).add(X.mul(X)), c.getD());
    }

    @SuppressWarnings("deprecation")
    @Test
    void mulTest5() {
        final Dual<Frac> a = IDENT.mul(IDENT);
        final Dual<Frac> c = a.mul(KONST);
        assertEquals(K.mul(X.mul(X)), c.getV());
        assertEquals(K.mul(X).add(K.mul(X)), c.getD());
    }

    @SuppressWarnings("deprecation")
    @Test
    void negTest1() {
        final Dual<Frac> a = KONST.neg();
        assertEquals(K.neg(), a.getV());
        assertEquals(ZERO, a.getD());
    }

    @SuppressWarnings("deprecation")
    @Test
    void negTest2() {
        final Dual<Frac> a = IDENT.neg();
        assertEquals(X.neg(), a.getV());
        assertEquals(ONE.neg(), a.getD());
    }

    @SuppressWarnings("deprecation")
    @Test
    void invTest1() {
        final Dual<Frac> a = KONST.inv();
        assertEquals(K.inv(), a.getV());
        assertEquals(ZERO, a.getD());
    }

    @SuppressWarnings("deprecation")
    @Test
    void invTest2() {
        final Dual<Frac> a = IDENT.inv();
        assertEquals(X.inv(), a.getV());
        assertEquals(X.mul(X).inv().neg(), a.getD());
    }

    @SuppressWarnings("deprecation")
    @Test
    void invTest3() {
        final Dual<Frac> a = IDENT.add(KONST).inv();
        assertEquals(K.add(X).inv(), a.getV());
        assertEquals(
                K.add(X).mul(K.add(X)).inv().neg(),
                a.getD());
    }

    @SuppressWarnings("deprecation")
    @Test
    void invTest4() {
        final Dual<Frac> a = IDENT.mul(IDENT).inv();
        assertEquals(X.mul(X).inv(), a.getV());
        Frac x3 = X.mul(X).mul(X);
        assertEquals(
                x3.inv().neg().add(x3.inv().neg()),
                a.getD());
    }

    @SuppressWarnings("deprecation")
    @Test
    void invTest5() {
        final Dual<Frac> a = KONST.mul(IDENT).mul(IDENT).inv();
        Frac x2k = X.mul(X).mul(K);
        Frac x3k = X.mul(x2k);
        assertEquals(x2k.inv(), a.getV());
        assertEquals(x3k.inv().add(x3k.inv()).neg(), a.getD());
    }

    @SuppressWarnings("deprecation")
    @Test
    void invTest6() {
        final Dual<Frac> a = new Dual<Frac>(X.zero()).inv();
        assertEquals(X.nan(), a.getV());
        assertEquals(X.nan(), a.getD());
        assert (a.isNan());

    }

    @SuppressWarnings("deprecation")
    @Test
    void sqrtTest1() {
        final Dual<Frac> a = KONST.sqr();
        assertEquals(K.sqr(), a.getV());
        assertEquals(ZERO, a.getD());
    }

    @SuppressWarnings("deprecation")
    @Test
    void sqrtTest2() {
        final Dual<Frac> a = IDENT.sqr();
        Frac sqr = X.sqr();
        assertEquals(sqr, a.getV());
        assertEquals(sqr.add(sqr).inv(), a.getD());
    }

    @SuppressWarnings("deprecation")
    @Test
    void sqrtTest3() {
        final Dual<Frac> a = KONST.add(IDENT).sqr();
        Frac sqrXK = X.add(K).sqr();
        assertEquals(sqrXK, a.getV());
        assertEquals(sqrXK.add(sqrXK).inv(), a.getD());
    }

    @SuppressWarnings("deprecation")
    @Test
    void sqrtTest4() {
        final Dual<Frac> a = IDENT.mul(IDENT).sqr();
        assertEquals(X, a.getV());
        assertEquals(ONE, a.getD());
    }

    @SuppressWarnings("deprecation")
    @Test
    void sqrtTest5() {
        final Dual<Frac> a = new Dual<Frac>(X.neg()).sqr();
        assertEquals(X.nan(), a.getV());
        assertEquals(X.nan(), a.getD());
        assert (a.isNan());
    }
}
