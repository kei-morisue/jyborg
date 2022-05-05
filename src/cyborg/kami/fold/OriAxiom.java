package cyborg.kami.fold;

import cyborg.kami.geo.Line;
import cyborg.kami.geo.Seg;
import cyborg.kami.geo.D0Vertex;
import cyborg.math.alg.field.FieldSqr;

public interface OriAxiom<F extends FieldSqr<F>> {

    public Line<F> apply(
            D0Vertex<F> v1,
            D0Vertex<F> v2,
            Seg<F> s1,
            Seg<F> s2);

}
