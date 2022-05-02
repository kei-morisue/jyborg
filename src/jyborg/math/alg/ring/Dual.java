package jyborg.math.alg.ring;

import jyborg.math.alg.field.FieldSqr;

public class Dual<F extends FieldSqr<F>>
        extends Binarion<F, Dual<F>> {

    @Deprecated
    public Dual() {
        super();
    }

    public Dual(F v) {
        super(v, v.unit());
    }

    private Dual(F v, F d) {
        super(v, d);
    }

    public static <F extends FieldSqr<F>> Dual<F> konst(F c) {
        return new Dual<F>(c, c.zero());
    }

    @Override
    protected Dual<F> sqrt() {
        F sqr = a.sqr();
        return new Dual<F>(
                sqr,
                b.div(sqr.x(2)));
    }

    @Override
    protected double value() {
        return b.val();
    }

    @Override
    protected Dual<F> multiply(Dual<F> e) {
        return new Dual<F>(
                a.mul(e.a),
                a.mul(e.b).add(b.mul(e.a)));
    }

    @Override
    protected Dual<F> inverse() {
        F inv = a.inv();
        return new Dual<F>(
                inv,
                b.neg().mul(inv).mul(inv));
    }

    @Override
    public Dual<F> unit() {
        return new Dual<F>(
                a.unit(),
                b.zero());
    }

    @Override
    public Dual<F> nan() {
        return new Dual<F>(
                a.nan(),
                b.nan());
    }

    @Override
    public Dual<F> zero() {
        return new Dual<F>(
                a.zero(),
                b.zero());
    }

    @Override
    protected Dual<F> plus(Dual<F> e) {
        return new Dual<F>(
                a.add(e.a),
                b.add(e.b));
    }

    @Override
    protected Dual<F> negate() {
        return new Dual<F>(
                a.neg(),
                b.neg());
    }

}
