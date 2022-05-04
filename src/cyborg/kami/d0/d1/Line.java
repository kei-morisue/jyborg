package cyborg.kami.d0.d1;

import cyborg.kami.d0.Dir;
import cyborg.kami.d0.Vertex;
import cyborg.math.alg.field.FieldSqr;

public class Line<F extends FieldSqr<F>> {
    private Vertex<F> p;
    private Dir<F> d;
}
