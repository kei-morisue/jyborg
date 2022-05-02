package jyborg.math.alg.ring;

import jyborg.math.alg.field.FieldSqr;

public class Dual<F extends FieldSqr<F>> extends FieldSqr<Dual<F>> {
    private F v = null;
    private F d = null;

    @Deprecated
    public Dual() {
        super();
    }

    public Dual(F v) {
        this.v = v;
        this.d = v.unit();
    }

    private Dual(F v, F d) {
        this.v = v;
        this.d = d;
    }

    public static <F extends FieldSqr<F>> Dual<F> konst(F c) {
        return new Dual<F>(c, c.zero());
    }

    @Override
    public Dual<F> unit() {
        return new Dual<F>(v.unit());
    }

    @Override
    public boolean isNan() {
        return v.isNan()
                || d.isNan();
    }

    @Override
    public Dual<F> nan() {
        return new Dual<F>(v.nan(), d.nan());
    }

    @Override
    public int compareTo(Dual<F> o) {
        return v.compareTo(o.v);
    }

    @Override
    protected Dual<F> sqrt() {
        F sqr = v.sqr();
        return new Dual<F>(
                sqr,
                d.div(sqr.add(sqr)));
    }

    @Override
    protected double value() {
        return d.val();
    }

    @Override
    protected Dual<F> multiply(Dual<F> e) {
        return new Dual<F>(
                v.mul(e.v),
                v.mul(e.d).add(d.mul(e.v)));
    }

    @Override
    protected Dual<F> inverse() {
        F inv = v.inv();
        return new Dual<F>(
                inv,
                d.neg().mul(inv).mul(inv));
    }

    @Override
    public Dual<F> zero() {
        return new Dual<F>(v.zero());
    }

    @Override
    protected Dual<F> plus(Dual<F> e) {
        return new Dual<F>(
                v.add(e.v),
                d.add(e.d));
    }

    @Override
    protected Dual<F> negate() {
        return new Dual<F>(
                v.neg(),
                d.neg());
    }

    @Deprecated
    public F getV() {
        return v;
    }

    @Deprecated
    public void setV(F v) {
        this.v = v;
    }

    @Deprecated
    public F getD() {
        return d;
    }

    @Deprecated
    public void setD(F d) {
        this.d = d;
    }

}
