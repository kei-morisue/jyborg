package jyborg.math.alg.lin;

import jyborg.math.alg.field.FieldSqr;
import jyborg.math.alg.group.Additive;

public abstract class Linear<F extends FieldSqr<F>, V extends Linear<F, V>>
        extends Additive<V> {
    abstract public V scale(F f);
}
