package cyborg.math.alg.lin;

import cyborg.math.alg.field.FieldSqr;

public final class U2<F extends FieldSqr<F>, V extends V2D<F, V>>
        extends Matrix<F, V, U2<F, V>> {
    final private V ab;
    final private boolean isNegDet;

    // (a, b; -b, a) : positive determinant
    // (a, b; b, -a) : negative determinant
    // , (a, b) is an unit vector
    public U2(V ab, boolean isNegDet) {
        F nrmSq = ab.nrmSq();
        F unit = nrmSq.unit();
        if (nrmSq.equals(unit)) {
            this.ab = ab;
            this.isNegDet = isNegDet;
            return;
        }
        this.ab = ab.nan();
        this.isNegDet = false;
    }

    private V cd() {
        V n = ab.n();
        return (isNegDet) ? n.neg() : n;
    }

    @Override
    public boolean isNan() {
        return ab.isNan();
    }

    @Override
    public U2<F, V> nan() {
        return new U2<F, V>(ab.nan(), false);
    }

    @Override
    public V apply(V v) {
        return v.createInstance(
                ab.prd(v),
                cd().prd(v));
    }

    @Override
    public U2<F, V> apply(U2<F, V> m) {
        return new U2<F, V>(
                m.trps().apply(ab),
                isNegDet ^ m.isNegDet);
    }

    @Override
    public U2<F, V> idt() {
        return new U2<F, V>(ab.ex(), false);
    }

    @Override
    public F det() {
        F unit = ab.x.unit();
        return isNegDet
                ? unit.neg()
                : unit;
    }

    @Override
    public U2<F, V> inv() {
        return trps();
    }

    @Override
    public U2<F, V> trps() {
        return isNegDet
                ? this
                : new U2<F, V>(
                        ab.createInstance(
                                ab.x,
                                ab.y.neg()),
                        false);
    }

    @Deprecated
    @Override
    public U2<F, V> scale(F f) {
        return nan();
    }

    @Deprecated
    @Override
    public U2<F, V> zero() {
        return nan();
    }

    @Deprecated
    @Override
    protected U2<F, V> plus(U2<F, V> e) {
        return nan();
    }

    @Override
    protected U2<F, V> negate() {
        return new U2<F, V>(ab.neg(), isNegDet);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj.getClass() != getClass()) {
            return false;
        }
        @SuppressWarnings("unchecked")
        U2<F, V> u2 = (U2<F, V>) obj;
        return ab.equals(u2.ab)
                && isNegDet == u2.isNegDet;
    }

    @Override
    public String toString() {
        return toString(ab) + "; " + toString(cd());
    }

    private String toString(V v) {
        return v.x + "," + v.y;
    }
}
