package cyborg.kami.geo;

import java.io.Serializable;

import cyborg.math.alg.field.FieldSqr;

public abstract class D0<F extends FieldSqr<F>, D extends D0<F, D>>
        implements Serializable {
    protected F x;
    protected F y;

    @Deprecated
    public D0() {
    }

    public D0(F x, F y) {
        this.x = x;
        this.y = y;
    }

    public D zero() {
        return createInstance(x.zero(), y.zero());
    }

    public Dir<F> dir(D d0) {
        return new Dir<F>(
                x.sub(d0.x),
                y.sub(d0.y));
    }

    public Dir<F> dir() {
        return new Dir<F>(x, y);
    }

    abstract D createInstance(F x, F y);

    public F getX() {
        return x;
    }

    @Deprecated
    public void setX(F x) {
        this.x = x;
    }

    public F getY() {
        return y;
    }

    @Deprecated
    public void setY(F y) {
        this.y = y;
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        D0<F, D> d0 = (D0<F, D>) obj;
        return x.equals(d0.x) && y.equals(d0.y);
    }

    @Override
    public int hashCode() {
        return x.hashCode() * 17 + y.hashCode();
    }
}
