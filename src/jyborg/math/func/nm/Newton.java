package jyborg.math.func.nm;

public class Newton {
    public static long apply(long c) {
        long e = c;
        for (int i = 0; i < 100; i++) {
            long next = next(e, c);
            if (next == e) {
                return e;
            }
            e = next;
        }
        return e;
    }

    //TODO extend to arbitrary functions
    private static long next(long e, long c) {
        return (e * e + c) / (2L * e);
    }
}
