package jyborg.math.alg.field;

public class Frac
        extends FieldSqr<Frac> {
    private long n = 0;
    private long d = 1;

    @Deprecated
    public Frac() {
    }

    public <N extends Number> Frac(long n) {
        this.n = n;
    }

    public <N extends Number> Frac(long n, long d) {
        long gcd = gcd(Math.abs(n), d);
        this.n = n / gcd;
        this.d = d / gcd;
    }

    public static long gcd(long a, long b) {
        long r;
        while (b > 0) {
            r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

    @Override
    protected Frac plus(Frac f2) {
        long n2 = f2.n;
        long d2 = f2.d;
        return new Frac(
                n * d2 + n2 * d,
                d * d2);
    }

    @Override
    public Frac zero() {
        return new Frac();
    }

    @Override
    protected Frac multiply(Frac f) {
        return new Frac(
                n * f.n,
                d * f.d);
    }

    @Override
    public Frac unit() {
        return new Frac(1);
    }

    @Override
    public int compareTo(Frac f) {
        return (int) (f.n * d - n * f.d);
    }

    @Override
    protected Frac sqrt() {
        long m = PerfectSquare.apply(n);
        long c = PerfectSquare.apply(d);
        return (m * m == n && c * c == d) ? new Frac(m, c) : nan();
    }

    @Override
    protected double value() {
        return ((double) n) / ((double) d);
    }

    @Override
    protected Frac negate() {
        return new Frac(-n, d);
    }

    @Override
    public boolean isNan() {
        return d == 0;
    }

    @Override
    public Frac nan() {
        return new Frac(1, 0);
    }

    @Override
    protected Frac inverse() {
        return new Frac(
                (n < 0) ? -d : d,
                Math.abs(n));
    }

    @Deprecated
    public long getN() {
        return n;
    }

    @Deprecated
    public void setN(long n) {
        this.n = n;
    }

    @Deprecated
    public long getD() {
        return d;
    }

    @Deprecated
    public void setD(long d) {
        this.d = d;
    }

}
