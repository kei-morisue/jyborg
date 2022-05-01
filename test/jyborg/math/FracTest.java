package jyborg.math;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import jyborg.math.alg.field.Frac;

class FracTest {
    @SuppressWarnings("deprecation")
    @Test
    void test1() {
        final Frac a = new Frac(24, 3);
        assertEquals(8, a.getN());
        assertEquals(1, a.getD());
    }

    @SuppressWarnings("deprecation")
    @Test
    void test2() {
        final Frac a = new Frac(-24, 3);
        assertEquals(-8, a.getN());
        assertEquals(1, a.getD());
    }

    @SuppressWarnings("deprecation")
    @Test
    void test3() {
        final Frac a = new Frac(17, 17);
        assertEquals(1, a.getN());
        assertEquals(1, a.getD());
    }

    @SuppressWarnings("deprecation")
    @Test
    void test4() {
        final Frac a = new Frac(17, 1);
        assertEquals(17, a.getN());
        assertEquals(1, a.getD());
    }

    @SuppressWarnings("deprecation")
    @Test
    void test5() {
        final Frac a = new Frac(0, 100);
        assertEquals(0, a.getN());
        assertEquals(1, a.getD());
    }

    @SuppressWarnings("deprecation")
    @Test
    void test6() {
        final Frac a = new Frac(42, 0);
        assertEquals(1, a.getN());
        assertEquals(0, a.getD());
        assert (a.isNan());
    }

    @SuppressWarnings("deprecation")
    @Test
    void addTest1() {
        final Frac a = new Frac(24, 3);
        final Frac b = new Frac(-24, 5);
        final Frac c = a.add(b);
        assertEquals(16, c.getN());
        assertEquals(5, c.getD());
    }

    @SuppressWarnings("deprecation")
    @Test
    void addTest2() {
        final Frac a = new Frac(5, 3);
        final Frac b = new Frac(2, 6);
        final Frac c = a.add(b);
        assertEquals(2, c.getN());
        assertEquals(1, c.getD());
    }

    @SuppressWarnings("deprecation")
    @Test
    void addTest3() {
        final Frac a = new Frac(-3435, 32);
        final Frac b = new Frac(24246, 54);
        final Frac c = a.add(b);
        assertEquals(10933, c.getN());
        assertEquals(32, c.getD());
    }

    @SuppressWarnings("deprecation")
    @Test
    void addTest4() {
        final Frac a = new Frac(67, 1);
        final Frac b = new Frac(434, 1);
        final Frac c = a.add(b);
        assertEquals(501, c.getN());
        assertEquals(1, c.getD());
    }

    @SuppressWarnings("deprecation")
    @Test
    void mulTest1() {
        final Frac a = new Frac(24, 3);
        final Frac b = new Frac(-24, 5);
        final Frac c = a.mul(b);
        assertEquals(-192, c.getN());
        assertEquals(5, c.getD());
    }

    @SuppressWarnings("deprecation")
    @Test
    void mulTest2() {
        final Frac a = new Frac(5, 3);
        final Frac b = new Frac(2, 6);
        final Frac c = a.mul(b);
        assertEquals(5, c.getN());
        assertEquals(9, c.getD());
    }

    @SuppressWarnings("deprecation")
    @Test
    void mulTest3() {
        final Frac a = new Frac(-3435, 32);
        final Frac b = new Frac(24246, 54);
        final Frac c = a.mul(b);
        assertEquals(-1542315, c.getN());
        assertEquals(32, c.getD());
    }

    @SuppressWarnings("deprecation")
    @Test
    void mulTest4() {
        final Frac a = new Frac(67, 1);
        final Frac b = new Frac(434, 1);
        final Frac c = a.mul(b);
        assertEquals(29078, c.getN());
        assertEquals(1, c.getD());
    }

    @SuppressWarnings("deprecation")
    @Test
    void negTest1() {
        final Frac a = new Frac(7, 3).neg();
        assertEquals(-7, a.getN());
        assertEquals(3, a.getD());
    }

    @SuppressWarnings("deprecation")
    @Test
    void negTest2() {
        final Frac a = new Frac(-25, 3).neg();
        assertEquals(25, a.getN());
        assertEquals(3, a.getD());
    }

    @SuppressWarnings("deprecation")
    @Test
    void negTest3() {
        final Frac a = new Frac(11, 17).neg();
        assertEquals(-11, a.getN());
        assertEquals(17, a.getD());
    }

    @SuppressWarnings("deprecation")
    @Test
    void negTest4() {
        final Frac a = new Frac(17, 1).neg();
        assertEquals(-17, a.getN());
        assertEquals(1, a.getD());
    }

    @SuppressWarnings("deprecation")
    @Test
    void invTest1() {
        final Frac a = new Frac(7, 3).inv();
        assertEquals(3, a.getN());
        assertEquals(7, a.getD());
    }

    @SuppressWarnings("deprecation")
    @Test
    void invTest2() {
        final Frac a = new Frac(-25, 3).inv();
        assertEquals(-3, a.getN());
        assertEquals(25, a.getD());
    }

    @SuppressWarnings("deprecation")
    @Test
    void invTest3() {
        final Frac a = new Frac(11, 17).inv();
        assertEquals(17, a.getN());
        assertEquals(11, a.getD());
    }

    @SuppressWarnings("deprecation")
    @Test
    void invTest4() {
        final Frac a = new Frac(17, 1).inv();
        assertEquals(1, a.getN());
        assertEquals(17, a.getD());
    }

    @SuppressWarnings("deprecation")
    @Test
    void invTest5() {
        final Frac a = new Frac(0, 42).inv();
        assertEquals(1, a.getN());
        assertEquals(0, a.getD());
    }

    @SuppressWarnings("deprecation")
    @Test
    void sqrtTest1() {
        final Frac a = new Frac(25, 4).sqr();
        assertEquals(5, a.getN());
        assertEquals(2, a.getD());
    }

    @SuppressWarnings("deprecation")
    @Test
    void sqrtTest2() {
        final Frac a = new Frac(25, 3).sqr();
        assertEquals(1, a.getN());
        assertEquals(0, a.getD());
        assert (a.isNan());
    }

    @SuppressWarnings("deprecation")
    @Test
    void sqrtTest3() {
        final Frac a = new Frac(-64, 36).sqr();
        assertEquals(1, a.getN());
        assertEquals(0, a.getD());
        assert (a.isNan());
    }

    @SuppressWarnings("deprecation")
    @Test
    void sqrtTest4() {
        final Frac a = new Frac(0, 1).sqr();
        assertEquals(0, a.getN());
        assertEquals(1, a.getD());
    }

}
