package cyborg.kami.geo;

import cyborg.math.alg.field.FieldSqr;

public final class Pt<F extends FieldSqr<F>>
        extends D0<F, Pt<F>> {
    @Deprecated
    public Pt() {
        super();
    }

    public Pt(F x, F y) {
        super(x, y);
    }

    @Override
    public Pt<F> createInstance(F x, F y) {
        return new Pt<F>(x, y);
    }

}
