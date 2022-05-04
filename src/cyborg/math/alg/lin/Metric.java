package cyborg.math.alg.lin;

import cyborg.math.alg.field.FieldSqr;

public interface Metric<F extends FieldSqr<F>, V extends Metric<F, V>> {
    public F prd(V v);
}
