package cyborg.kami.fold;

import cyborg.kami.geo.D0;
import cyborg.kami.geo.Dir;
import cyborg.math.alg.field.FieldSqr;
import cyborg.math.alg.lin.Matrix2x2;

public class Fold<F extends FieldSqr<F>> {
    private Matrix2x2<F, Dir<F>> u;
    private Dir<F> w;

    private Fold(
            Matrix2x2<F, Dir<F>> u,
            Dir<F> w) {
        this.u = u;
        this.w = w;
    }

    public <W extends D0<F, W>> Fold(W s, W e) {
        Dir<F> n = e.dir(s).n();
        F n2 = n.nrmSq();
        this.w = n.scale(n.prd(s.dir()).div(n2).x(2));
        Matrix2x2<F, Dir<F>> nn = new Matrix2x2<F, Dir<F>>(n);
        this.u = nn.idt().sub(nn.scale(n2.inv()).x(2));
    }

    public <W extends D0<F, W>> W apply(W v) {
        return u.apply(v.dir()).add(w).get(v.zero());
    }

    public Fold<F> inv() {
        Matrix2x2<F, Dir<F>> inv = u.inv();
        return new Fold<F>(
                inv,
                inv.apply(w).neg());
    }

    //TODO
    public <W extends D0<F, W>, P extends D0<F, P>> Fold(
            W w0,
            W w1,
            W w2,
            P p0,
            P p1,
            P p2) {
        Dir<F> c1 = w1.dir(w0);
        Dir<F> c2 = w2.dir(w0);
        Dir<F> d1 = p1.dir(p0);
        Dir<F> d2 = p2.dir(p0);
        F den = c2.prd(c1.n());
        c1.ketbra(d2).sub(c2.ketbra(d1));

    }
}
