package cyborg.math.alg.ring;

import cyborg.math.alg.field.FieldSqr;

public abstract class Binarion<F extends FieldSqr<F>, B extends Binarion<F, B>>
        extends FieldSqr<B> {
    protected F a = null;
    protected F b = null;

    protected Binarion(F a, F b) {
        this.a = a;
        this.b = b;
    }

    abstract B createInstance(F a, F b);

    @Deprecated
    final public F getA() {
        return a;
    }

    @Deprecated
    final public void setA(F a) {
        this.a = a;
    }

    @Deprecated
    final public F getB() {
        return b;
    }

    @Override
    public B unit() {
        return createInstance(
                a.unit(),
                b.zero());
    }

    @Override
    protected B negate() {
        return createInstance(
                a.neg(),
                b.neg());
    }

    @Override
    public B nan() {
        return createInstance(
                a.nan(),
                b.nan());
    }

    @Override
    public B zero() {
        return createInstance(
                a.zero(),
                b.zero());
    }

    @Override
    protected B plus(B e) {
        return createInstance(
                a.add(e.a),
                b.add(e.b));
    }

    @Deprecated
    final public void setB(F b) {
        this.b = b;
    }

    @Override
    public boolean isNan() {
        return a.isNan() || b.isNan();
    }

    @Override
    public String toString() {
        if (isNan()) {
            return "nan";
        }
        return a.toString() + ", " + b.toString();
    }
}
