package cyborg.math.alg.affine;

import cyborg.math.alg.field.FieldSqr;
import cyborg.math.alg.lin.Matrix;
import cyborg.math.alg.lin.Vector;

public abstract class Affine<F extends FieldSqr<F>, V extends Vector<F, V>, M extends Matrix<F, V, M>> {
    protected M a;
    protected V b;

    protected Affine(M a, V b) {
        setA(a);
        setB(b);
    }

    // a.v + b
    public V apply(V v) {
        return a.apply(v).add(b);
    };

    // this o t
    public Affine<F, V, M> apply(Affine<F, V, M> t) {
        return createInstance(
                a.apply(t.a),
                b.add(a.apply(t.b)));
    }

    public Affine<F, V, M> inv() {
        M inv = a.inv();
        return createInstance(
                inv,
                inv.apply(b).neg());
    }

    public abstract void setA(M a);

    public abstract void setB(V b);

    public abstract Affine<F, V, M> createInstance(
            M a,
            V b);

}
