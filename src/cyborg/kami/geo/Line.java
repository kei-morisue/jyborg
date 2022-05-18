package cyborg.kami.geo;

import cyborg.math.alg.field.FieldSqr;

public class Line<F extends FieldSqr<F>, V extends D0<F, V>> {
    V p;
    Dir<F> d;

    public Line(V p, Dir<F> d) {
        this.p = p;
        this.d = d;
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean equals(Object obj) {
        if (getClass() != obj.getClass()) {
            return false;
        }
        Line<F, V> line = (Line<F, V>) obj;
        Dir<F> p0 = p.dir(line.p);
        return p0.isPerp(d.n())
                && p0.isPerp(line.d.n());
    }

    @Override
    public int hashCode() {
        Dir<F> n = d.n();
        F a = n.prd(p.dir()).div(d.nrmSq());
        return n.scale(a).hashCode();
    }
}
