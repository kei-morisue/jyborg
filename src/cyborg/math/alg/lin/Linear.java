package cyborg.math.alg.lin;

import cyborg.math.alg.field.FieldSqr;
import cyborg.math.alg.group.Additive;

public abstract class Linear<F extends FieldSqr<F>, V extends Linear<F, V>>
        extends Additive<V> {
    abstract public V scale(F f);

}
