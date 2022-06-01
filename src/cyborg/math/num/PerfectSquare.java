package cyborg.math.num;

import java.util.Arrays;

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
            return nm(n);
        }
        return -1L;
    }

    private static long nm(long c) {
        long e = c;
        for (int i = 0; i < 100; i++) {
            long next = next(e, c);
            if (next * next == c) {
                return next;
            }
            if (next == e) {
                --next;
            }
            e = next == e
                    ? e - 1
                    : next;
        }
        return -1L;
    }

    private static long next(long e, long c) {
        long de = (e * e - c) / e >> 1;
        return e - de;
    }

}
