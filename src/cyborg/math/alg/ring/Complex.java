package cyborg.math.alg.ring;

import cyborg.math.alg.field.FieldSqr;

public class Complex<F extends FieldSqr<F>>
        extends Binarion<F, Complex<F>> {

    public Complex(F a) {
        super(a, a.zero());
    }

    public Complex(F a, F b) {
        super(a, b);
    }

    public Complex<F> cnj() {
        if (isNan()) {
            return nan();
        }
        return new Complex<F>(a, b.neg());
    }

    @Override
    protected Complex<F> sqrt() {
        F zero = a.zero();
        if (b.equals(zero)) {
            return new Complex<F>(
                    a.sqr(),
                    zero);
        }
        F aa = a.pow(2);
        F bb = b.pow(2);
        F d = aa.add(bb.mul(4));
        F sqrD = d.sqr();
        if (sqrD.isNan()) {
            return nan();
        }
        d = aa.add(sqrD).div(a.unit().mul(2));
        sqrD = d.sqr();
        if (sqrD.isNan()) {
            return nan();
        }
        return new Complex<F>(
                sqrD,
                b.div(sqrD));
    }

    @Override
    protected double value() {
        return 0.0;
    }

    @Override
    protected Complex<F> multiply(Complex<F> e) {
        return new Complex<F>(
                a.mul(e.a).sub(b.mul(e.b)),
                a.mul(e.b).add(b.mul(e.a)));
    }

    @Override
    protected Complex<F> inverse() {
        F d = a.pow(2).add(b.pow(2));
        return new Complex<F>(
                a.div(d),
                b.neg().div(d));
    }

    @Override
    public Complex<F> nan() {
        return new Complex<F>(
                a.nan(),
                b.nan());
    }

    @Override
    public int compareTo(Complex<F> o) {
        int ca = a.compareTo(o.a);
        int cb = b.compareTo(o.b);
        if (ca == 0) {
            return cb;
        }
        if (cb == 0) {
            return ca;
        }
        return 1;
    }

    @Override
    Complex<F> createInstance(F a, F b) {
        return new Complex<F>(a, b);
    }

}
