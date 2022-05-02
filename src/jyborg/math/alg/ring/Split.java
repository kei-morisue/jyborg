package jyborg.math.alg.ring;

import jyborg.math.alg.field.FieldSqr;

public class Split<F extends FieldSqr<F>> extends FieldSqr<Split<F>> {
    private F a = null;
    private F b = null;

    @Deprecated
    public Split() {
        super();
    }

    public Split(F v) {
        this.a = v;
        this.b = v.zero();
    }

    private Split(F a, F b) {
        this.a = a;
        this.b = b;
    }

    public static <F extends FieldSqr<F>> Split<F> konst(F c) {
        return new Split<F>(c, c.zero());
    }

    @Override
    public Split<F> unit() {
        return new Split<F>(a.unit());
    }

    @Override
    public boolean isNan() {
        return a.isNan()
                || b.isNan();
    }

    @Override
    public Split<F> nan() {
        return new Split<F>(a.nan(), b.nan());
    }

    @Override
    public int compareTo(Split<F> o) {
        return a.compareTo(o.a);
    }

    @Override
    protected Split<F> sqrt() {
        F sqr = a.sqr();
        return new Split<F>(
                sqr,
                b.div(sqr.add(sqr)));
    }

    @Override
    protected double value() {
        return b.val();
    }

    @Override
    protected Split<F> multiply(Split<F> e) {
        return new Split<F>(
                a.mul(e.a),
                a.mul(e.b).add(b.mul(e.a)));
    }

    @Override
    protected Split<F> inverse() {
        F inv = a.inv();
        return new Split<F>(
                inv,
                b.neg().mul(inv).mul(inv));
    }

    @Override
    public Split<F> zero() {
        return new Split<F>(a.zero());
    }

    @Override
    protected Split<F> plus(Split<F> e) {
        return new Split<F>(
                a.add(e.a),
                b.add(e.b));
    }

    @Override
    protected Split<F> negate() {
        return new Split<F>(
                a.neg(),
                b.neg());
    }

    @Deprecated
    public F getA() {
        return a;
    }

    @Deprecated
    public void setA(F a) {
        this.a = a;
    }

    @Deprecated
    public F getB() {
        return b;
    }

    @Deprecated
    public void setB(F b) {
        this.b = b;
    }

}
