package jyborg.math.alg.field;

import java.util.Arrays;

import jyborg.math.func.nm.Newton;

public class PerfectSquare {
    private static Long[] m256 = { 0L, 1L, 4L, 9L, 16L, 17L, 25L, 33L, 36L, 41L,
            49L, 57L,
            64L, 65L, 68L, 73L, 81L, 89L, 97L, 100L, 105L, 113L, 121L, 129L,
            132L, 137L, 144L,
            145L, 153L, 161L, 164L, 169L, 177L, 185L, 193L, 196L, 201L, 209L,
            217L, 225L,
            228L, 233L, 241L, 249L };

    public static long apply(long n) {
        if (n < 0L) {
            return -1L;
        }
        if (n == 0L || n == 1L) {
            return n;
        }
        if (Arrays.asList(m256).contains(n % 256L)) {
            return (long) Math.floor(Math.sqrt(n));
        }
        return Newton.apply(n);
    }

}
