package jyborg.math.alg.ring;

import jyborg.math.alg.field.FieldSqr;

public class Split<F extends FieldSqr<F>>
        extends Binarion<F, Split<F>> {
    private F r;

    @Deprecated
    public Split() {
        super();
    }

    public Split(F v, F r) {
        super(v, v.zero());
        if (r.sqr().isNan()) {
            r = v.nan();
        }
        this.r = r;
    }

    public Split(F v, F d, F r) {
        super(v, d);
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
        F t = a.add(s).div(r.x(2)).sqr();
        if (t.isNan()) {
            t = a.sub(s).div(r.x(2)).sqr();
            if (t.isNan()) {
                return nan();
            }
            return new Split<F>(
                    b.div(t.x(2)),
                    t,
                    r);

        }
        return new Split<F>(
                b.div(t.x(2)),
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

    @Override
    public Split<F> unit() {
        return new Split<F>(
                a.unit(),
                b.zero(),
                r);
    }

    @Override
    public Split<F> nan() {
        return new Split<F>(
                a.nan(),
                b.nan(),
                r);
    }

    @Override
    public Split<F> zero() {
        return new Split<F>(
                a.zero(),
                b.zero(),
                r);
    }

    @Override
    protected Split<F> plus(Split<F> e) {
        return new Split<F>(
                a.add(e.a),
                b.add(e.b),
                r);
    }

    @Override
    protected Split<F> negate() {
        return new Split<F>(
                a.neg(),
                b.neg(),
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
    public String toString() {
        return isNan() ? "nan" : super.toString() + "r" + r;
    }
}
