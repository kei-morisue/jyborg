package cyborg.math.alg.ring;

import cyborg.math.alg.field.FieldSqr;

public class Split<F extends FieldSqr<F>>
        extends Binarion<F, Split<F>> {
    private F r;

    public Split(F a, F r) {
        super(a, a.zero());
        this.r = r;
    }

    public Split(F a, F b, F r) {
        super(a, b);
        this.r = r;
    }

    @Override
    public boolean isNan() {
        return super.isNan() || r.isNan();
    }

    @Override
    protected Split<F> sqrt() {
        F zero = b.zero();
        if (b.equals(zero)) {
            if (a.isNeg()) {
                return nan();
            }
            F aSqr = a.sqr();
            if (aSqr.isNan()) {
                aSqr = a.div(r).sqr();
                if (aSqr.isNan()) {
                    return nan();
                }
                return new Split<F>(
                        zero,
                        aSqr,
                        r);
            }
            return new Split<F>(
                    aSqr,
                    zero,
                    r);
        }
        F ss = a.pow(2).sub(b.pow(2).mul(r));
        if (ss.isNeg()) {
            return nan();
        }
        F s = ss.sqr();
        if (s.isNan()) {
            return nan();
        }
        F t = a.add(s).div(r.mul(2)).sqr();
        if (t.isNan()) {
            t = a.sub(s).div(r.mul(2)).sqr();
            if (t.isNan()) {
                return nan();
            }
        }
        return new Split<F>(
                b.div(t.mul(2)),
                t,
                r);

    }

    @Override
    protected double value() {
        return a.val() + b.val() * r.sqr().val();
    }

    @Override
    protected Split<F> multiply(Split<F> e) {
        return new Split<F>(
                a.mul(e.a).add(b.mul(e.b).mul(r)),
                a.mul(e.b).add(b.mul(e.a)),
                r);
    }

    @Override
    protected Split<F> inverse() {
        F d = a.pow(2).sub(b.pow(2).mul(r));
        return new Split<F>(
                a.div(d),
                b.neg().div(d),
                r);
    }

    @Deprecated
    public F getR() {
        return r;
    }

    @Deprecated
    public void setR(F r) {
        this.r = r;
    }

    @Override
    public int compareTo(Split<F> o) {
        int ca = a.compareTo(o.a);
        int cb = b.compareTo(o.b);
        if (ca == 0) {
            return cb;
        }
        if (cb == 0) {
            return ca;
        }
        int c = a.sub(o.a).pow(2).compareTo(r.mul(b.sub(o.b).pow(2)));
        return ca * cb * c;
    }

    @Override
    public String toString() {
        return isNan() ? "nan" : super.toString() + "r" + r;
    }

    @Override
    Split<F> createInstance(F a, F b) {
        return new Split<F>(a, b, r);
    }
}
