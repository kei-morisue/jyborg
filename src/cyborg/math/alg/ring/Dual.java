package cyborg.math.alg.ring;

import cyborg.math.alg.field.FieldSqr;

public class Dual<F extends FieldSqr<F>>
        extends Binarion<F, Dual<F>> {

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
    public int compareTo(Dual<F> o) {
        int ca = a.compareTo(o.a);
        int cb = b.compareTo(o.b);
        return (ca == 0 && cb == 0) ? 0 : 1;
    }

    @Override
    Dual<F> createInstance(F a, F b) {
        return new Dual<F>(a, b);
    }

}
