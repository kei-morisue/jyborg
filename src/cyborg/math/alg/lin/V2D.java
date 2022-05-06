package cyborg.math.alg.lin;

import cyborg.math.alg.field.FieldSqr;

public abstract class V2D<F extends FieldSqr<F>, V extends V2D<F, V>>
        extends Vector<F, V> {
    protected F x;
    protected F y;

    public V2D(F x, F y) {
        this.x = x;
        this.y = y;
    }

    public V2D(V2D<F, V> v) {
        this(v.x, v.y);
    }

    public abstract V createInstance(F x, F y);

    @Override
    public F prd(V v) {
        return x.mul(v.x).add(y.mul(v.y));
    }

    @Override
    final public boolean isNan() {
        return x.isNan() || y.isNan();
    }

    @Override
    final public V nan() {
        return createInstance(
                x.nan(),
                y.nan());
    }

    @Override
    final public F nrm() {
        return nrmSq().sqr();
    }

    final public F nrmSq() {
        return x.pow(2).add(y.pow(2));
    }

    // gets an orthogonal V2D: (-y, x)
    final public V n() {
        return createInstance(y.neg(), x);
    }

    // gets (y, x)
    final public V yx() {
        return createInstance(y, x);
    }

    final public boolean isPerp(V v) {
        return prd(v).equals(x.zero());
    }

    final public F out(V v) {
        return n().prd(v);
    }

    final public M2x2<F, V> ketbra(V v) {
        return new M2x2<F, V>(
                scale(v.x),
                scale(v.y));
    }

    final public V ex() {
        return createInstance(x.unit(), y.zero());
    }

    final public V ey() {
        return createInstance(x.zero(), y.unit());
    }

    @Override
    final public V scale(F f) {
        return createInstance(
                f.mul(x),
                f.mul(y));
    }

    @Override
    final public V zero() {
        return createInstance(
                x.zero(),
                y.zero());
    }

    @Override
    final protected V plus(V e) {
        return createInstance(
                x.add(e.x),
                y.add(e.y));
    }

    @Override
    final protected V negate() {
        return createInstance(
                x.neg(),
                y.neg());
    }

    @Override
    final public boolean equals(Object obj) {
        if (obj.getClass() != this.getClass()) {
            return false;
        }
        @SuppressWarnings("unchecked")
        V2D<F, V> v = (V2D<F, V>) obj;
        return v.x.equals(x) && v.y.equals(y);
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

    @Override
    public String toString() {
        return x + "; " + y;
    }
}
