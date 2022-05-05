package cyborg.kami.geo;

import cyborg.math.alg.field.FieldSqr;

public final class D0Point<F extends FieldSqr<F>>
        extends D0<F, D0Point<F>> {
    @Deprecated
    public D0Point() {
        super();
    }

    public D0Point(F x, F y) {
        super(x, y);
    }

    @Override
    public D0Point<F> createInstance(F x, F y) {
        return new D0Point<F>(x, y);
    }

}
