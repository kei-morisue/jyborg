package cyborg.kami.geo;

import cyborg.math.alg.field.FieldSqr;
import cyborg.math.alg.lin.V2D;

public final class Dir<F extends FieldSqr<F>>
        extends V2D<F, Dir<F>> {

    public Dir(F x, F y) {
        super(x, y);
    }

    public <D extends D0<F, D>> D get(D d) {
        return d.createInstance(
                this.x.add(d.getX()),
                this.y.add(d.getY()));
    }

    @Override
    public Dir<F> createInstance(F x, F y) {
        return new Dir<F>(x, y);
    }

}
