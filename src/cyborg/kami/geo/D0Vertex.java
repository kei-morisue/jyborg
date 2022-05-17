package cyborg.kami.geo;

import cyborg.math.alg.field.FieldSqr;

public final class D0Vertex<F extends FieldSqr<F>>
        extends D0<F, D0Vertex<F>> {
    private D0Point<F> pt;

    @Deprecated
    public D0Vertex() {
        super();
    }

    public D0Vertex(F x, F y, D0Point<F> pt) {
        super(x, y);
        this.pt = pt;
    }

    @Override
    public D0Vertex<F> createInstance(F x, F y) {
        return new D0Vertex<F>(x, y, pt);
    }

    public D0Point<F> getPt() {
        return pt;
    }

    @Deprecated
    public void setPt(D0Point<F> pt) {
        this.pt = pt;
    }
}
