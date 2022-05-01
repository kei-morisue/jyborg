package jyborg.math;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import jyborg.math.alg.field.PerfectSquare;

public class PerfectSquareTest {
    private static long LARGE_LONG = 2645L;

    @Test
    void test1() {
        assertEquals(-1L, PerfectSquare.apply(-12214L));
        assertEquals(0L, PerfectSquare.apply(0L));
        assertEquals(1L, PerfectSquare.apply(1L));
        assertEquals(16L, PerfectSquare.apply(256L));
        assertEquals(LARGE_LONG,
                PerfectSquare.apply(LARGE_LONG * LARGE_LONG));

    }
}
