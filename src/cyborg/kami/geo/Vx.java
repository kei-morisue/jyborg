package cyborg.kami.geo;

import cyborg.math.alg.field.FieldSqr;

public final class Vx<F extends FieldSqr<F>>
        extends D0<F, Vx<F>> {
    private Pt<F> pt;

    @Deprecated
    public Vx() {
        super();
    }

    public Vx(F x, F y, Pt<F> pt) {
        super(x, y);
        this.pt = pt;
    }

    @Override
    public Vx<F> createInstance(F x, F y) {
        return new Vx<F>(x, y, pt);
    }

    public Pt<F> getPt() {
        return pt;
    }

    @Deprecated
    public void setPt(Pt<F> pt) {
        this.pt = pt;
    }
}
