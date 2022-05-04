package jyborg.math.alg.lin;

import jyborg.math.alg.field.FieldSqr;

public class V2D<F extends FieldSqr<F>>
        extends Vector<F, V2D<F>> {
    private F x;
    private F y;

    @Deprecated
    public V2D() {
    }

    public V2D(F x, F y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public F prd(V2D<F> v) {
        return x.mul(v.x).add(y.mul(v.y));
    }

    @Override
    public boolean isNan() {
        return x.isNan() || y.isNan();
    }

    @Override
    public V2D<F> nan() {
        return new V2D<F>(
                x.nan(),
                y.nan());
    }

    @Override
    public F nrm() {
        return prd(this).sqr();
    }

    @Override
    public V2D<F> scale(F f) {
        return new V2D<F>(
                f.mul(x),
                f.mul(y));
    }

    @Override
    public V2D<F> zero() {
        return new V2D<F>(
                x.zero(),
                y.zero());
    }

    @Override
    protected V2D<F> plus(V2D<F> e) {
        return new V2D<F>(
                x.add(e.x),
                y.add(e.y));
    }

    @Override
    protected V2D<F> negate() {
        return new V2D<F>(
                x.neg(),
                y.neg());
    }

    @Deprecated
    public F getX() {
        return x;
    }

    @Deprecated
    public void setX(F x) {
        this.x = x;
    }

    @Deprecated
    public F getY() {
        return y;
    }

    @Deprecated
    public void setY(F y) {
        this.y = y;
    }

}
