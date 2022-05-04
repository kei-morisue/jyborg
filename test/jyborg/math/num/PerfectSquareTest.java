package jyborg.math.num;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class PerfectSquareTest {
    private static long LARGE_LONG = 2645L;

    @Test
    void test1() {
        assertEquals(-1L, PerfectSquare.apply(-12214L));
    }

    @Test
    void test2() {
        assertEquals(0L, PerfectSquare.apply(0L));
    }

    @Test
    void test3() {
        assertEquals(1L, PerfectSquare.apply(1L));
    }

    @Test
    void test4() {
        assertEquals(16L, PerfectSquare.apply(256L));
    }

    @Test
    void test5() {
        assertEquals(LARGE_LONG,
                PerfectSquare.apply(LARGE_LONG * LARGE_LONG));
    }

    @Test
    void test6() {
        assertEquals(-1L, PerfectSquare.apply(255L));
    }
}
