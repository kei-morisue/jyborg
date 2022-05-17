package cyborg.kami.geo;

import cyborg.math.alg.field.FieldSqr;

public class Seg<F extends FieldSqr<F>, V extends D0<F, V>> {
    V p;
    V q;

    public Seg(V p, V q) {
        this.p = p;
        this.q = q;
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (getClass() != obj.getClass())
            return false;
        Seg<F, V> seg = (Seg<F, V>) obj;
        return seg.p.equals(p) && seg.q.equals(q);
    }

    public Dir<F> d() {
        return q.dir(p);
    }

    public Dir<F> n() {
        return d().n();
    }

    public V m() {
        return d().div(2).from(p);
    }

    public V extend(F c) {
        return d().scale(c).from(p);
    }

    @Override
    public int hashCode() {
        return p.hashCode() * 17 + q.hashCode();
    }
}
