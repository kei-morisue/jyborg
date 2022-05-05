package cyborg.math.alg.lin;

import cyborg.math.alg.field.FieldSqr;

public class Matrix2x2<F extends FieldSqr<F>, V extends V2D<F, V>>
        extends Linear<F, Matrix2x2<F, V>> {
    private V ab;
    private V cd;

    public Matrix2x2(Matrix2x2<F, V> m) {
        this(m.ab, m.cd);
    }

    // applies v to this matrix
    public V apply(V v) {
        return ab.createInstance(
                ab.prd(v),
                cd.prd(v));
    }

    // gives matrix multiplication
    public Matrix2x2<F, V> apply(Matrix2x2<F, V> m) {
        return new Matrix2x2<F, V>(
                m.apply(ab),
                m.apply(cd));
    }

    // gives (ab; cd)
    public Matrix2x2(V ab, V cd) {
        this.ab = ab;
        this.cd = cd;
    }

    // gives | v x v |
    public Matrix2x2(V v) {
        this(v.ketbra(v));
    }

    // gives identity matrix
    public Matrix2x2<F, V> idt() {
        return new Matrix2x2<F, V>(
                ab.ex(),
                cd.ey());
    }

    public F det() {
        return ab.out(cd);
    }

    public Matrix2x2<F, V> inv() {
        return new Matrix2x2<F, V>(
                cd.n().neg(),
                ab.n()).trps().scale(det().inv());
    }

    // get transpose
    public Matrix2x2<F, V> trps() {
        return new Matrix2x2<F, V>(
                ab.createInstance(ab.x, cd.x),
                ab.createInstance(ab.y, cd.y));
    }

    @Override
    public boolean isNan() {
        return ab.isNan() || cd.isNan();
    }

    @Override
    public Matrix2x2<F, V> nan() {
        return new Matrix2x2<F, V>(ab.nan(), cd.nan());
    }

    @Override
    public Matrix2x2<F, V> zero() {
        return new Matrix2x2<F, V>(ab.zero(), cd.zero());
    }

    @Override
    protected Matrix2x2<F, V> plus(Matrix2x2<F, V> e) {
        return new Matrix2x2<F, V>(
                ab.add(e.ab),
                cd.add(e.cd));
    }

    @Override
    protected Matrix2x2<F, V> negate() {
        return new Matrix2x2<F, V>(
                ab.neg(),
                cd.neg());
    }

    @Override
    public String toString() {
        return ab.toString() + "; " + cd.toString();
    }

    @Override
    public Matrix2x2<F, V> scale(F f) {
        return new Matrix2x2<F, V>(
                ab.scale(f),
                cd.scale(f));
    }

    @Deprecated
    public V getAb() {
        return ab;
    }

    @Deprecated
    public void setAb(V ab) {
        this.ab = ab;
    }

    @Deprecated
    public V getCd() {
        return cd;
    }

    @Deprecated
    public void setCd(V cd) {
        this.cd = cd;
    }

}
