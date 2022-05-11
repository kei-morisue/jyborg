package cyborg.kami.geo;

import cyborg.math.alg.affine.Affine;
import cyborg.math.alg.field.FieldSqr;
import cyborg.math.alg.lin.AbstractM2x2;
import cyborg.math.alg.lin.U2;

public class Fold<F extends FieldSqr<F>>
        extends Affine<F, Dir<F>, U2<F, Dir<F>>> {

    public <V extends D0<F, V>> Fold(V s, V e) {
        super(null, null);
        AbstractM2x2<F, Dir<F>> proj = proj(s, e);
        this.a = u(proj);
        this.b = w(proj, s);
    }

    private static <E extends FieldSqr<E>> U2<E, Dir<E>> u(
            AbstractM2x2<E, Dir<E>> p) {
        Dir<E> ab = p.ab();
        return new U2<E, Dir<E>>(ab.ex().sub(ab.x(2)), true);
    }

    private static <E extends FieldSqr<E>, V extends D0<E, V>> Dir<E> w(
            AbstractM2x2<E, Dir<E>> p,
            V s) {
        return p.x(2).apply(s.dir());
    }

    private static <E extends FieldSqr<E>, V extends D0<E, V>> AbstractM2x2<E, Dir<E>> proj(
            V s,
            V e) {
        Dir<E> d = e.dir(s);
        Dir<E> n = d.n();
        return n.ketbra(n).scale(n.nrmSq().inv());
    }

    public <V extends D0<F, V>> Fold(
            V p0,
            V p1,
            V p2,
            V v0,
            V v1,
            V v2) {
        super(u(
                p1.dir(p0),
                p2.dir(p0),
                v1.dir(v0),
                v2.dir(v0)), null);
        this.b = v0.dir().sub(this.a.apply(p0.dir()));
    }

    private static <E extends FieldSqr<E>> U2<E, Dir<E>> u(
            Dir<E> p1,
            Dir<E> p2,
            Dir<E> v1,
            Dir<E> v2) {
        Dir<E> n1 = v1.n();
        Dir<E> n2 = v2.n();
        AbstractM2x2<E, Dir<E>> u = n1.ketbra(p2).sub(n2.ketbra(p1));
        E d = v2.prd(n1);
        u = u.scale(d.inv());
        return new U2<E, Dir<E>>(u.ab(), u.det().isNeg());
    }

    @Deprecated
    public Fold(U2<F, Dir<F>> a, Dir<F> b) {
        super(a, b);
    }

    @Override
    public void setA(U2<F, Dir<F>> a) {
        this.a = a;
    }

    @Override
    public void setB(Dir<F> b) {
        this.b = b;
    }

    @Override
    public Affine<F, Dir<F>, U2<F, Dir<F>>> createInstance(U2<F, Dir<F>> a,
            Dir<F> b) {
        return new Fold<F>(a, b);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj.getClass() != getClass()) {
            return false;
        }
        @SuppressWarnings("unchecked")
        Fold<F> t = (Fold<F>) obj;
        return a.equals(t.a) && b.equals(t.b);
    }

    @Override
    public String toString() {
        return a.toString() + "| " + b.toString();
    }
}
