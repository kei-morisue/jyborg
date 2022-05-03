package jyborg.math.alg.ring;

import jyborg.math.alg.field.FieldSqr;

public abstract class Binarion<F extends FieldSqr<F>, B extends Binarion<F, B>>
        extends FieldSqr<B> {
    protected F a = null;
    protected F b = null;

    @Deprecated
    public Binarion() {
        super();
    }

    protected Binarion(F a, F b) {
        this.a = a;
        this.b = b;
    }

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

    @Deprecated
    final public void setB(F b) {
        this.b = b;
    }

    @Override
    public boolean isNan() {
        return a.isNan() || b.isNan();
    }

    @Override
    final public int compareTo(B o) {
        int ca = a.compareTo(o.a);
        int cb = b.compareTo(o.b);
        return (ca == 0 && cb == 0) ? 0 : -1;
    }

    @Override
    public String toString() {
        if (isNan()) {
            return "nan";
        }
        return a.toString() + ", " + b.toString();
    }
}
