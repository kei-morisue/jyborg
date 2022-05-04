package jyborg.math.alg.lin;

import jyborg.math.alg.field.FieldSqr;

public abstract class Vector<F extends FieldSqr<F>, V extends Vector<F, V>>
        extends Linear<F, V>
        implements Metric<F, V> {

    public abstract F nrm();
}
