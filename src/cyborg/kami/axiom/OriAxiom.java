package cyborg.kami.axiom;

import cyborg.kami.d0.Vertex;
import cyborg.kami.d0.d1.Line;
import cyborg.kami.d0.d1.Seg;
import cyborg.math.alg.field.FieldSqr;

public interface OriAxiom<F extends FieldSqr<F>> {

    public Line<F> apply(
            Vertex<F> v1,
            Vertex<F> v2,
            Seg<F> s1,
            Seg<F> s2);

}
