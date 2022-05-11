package cyborg.kami.geo;

import cyborg.math.alg.field.FieldSqr;

public interface Axiom<F extends FieldSqr<F>> {

    public Line<F> apply(
            D0Vertex<F> v1,
            D0Vertex<F> v2,
            Seg<F> s1,
            Seg<F> s2);

}
