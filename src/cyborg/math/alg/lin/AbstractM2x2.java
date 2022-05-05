package cyborg.math.alg.lin;

import cyborg.math.alg.field.FieldSqr;

public abstract class AbstractM2x2<F extends FieldSqr<F>, V extends V2D<F, V>>
        extends Matrix<F, V, AbstractM2x2<F, V>> {
    protected abstract V ab();

    protected abstract V cd();

    public V ac() {
        return trps().ab();
    }

    public V bd() {
        return trps().cd();
    }

    @Override
    public boolean isNan() {
        return ab().isNan() || cd().isNan();
    }

    @Override
    public V apply(V v) {
        return v.createInstance(
                ab().prd(v),
                cd().prd(v));
    }

    @Override
    public AbstractM2x2<F, V> apply(AbstractM2x2<F, V> m) {
        AbstractM2x2<F, V> trps = m.trps();
        return createInstance(
                apply(trps.ab()),
                apply(trps.cd())).trps();
    }

    @Override
    public AbstractM2x2<F, V> idt() {
        return id2();
    }

    @Override
    public F det() {
        return ab().out(cd());
    }

    @Override
    public AbstractM2x2<F, V> inv() {
        F d = det().inv();
        return createInstance(
                cd().n().neg(),
                ab().n()).trps().scale(d);
    }

    @Override
    public AbstractM2x2<F, V> trps() {
        V ab = ab();
        V cd = cd();
        return createInstance(
                ab.createInstance(ab.x, cd.x),
                ab.createInstance(ab.y, cd.y));
    }

    @Override
    public AbstractM2x2<F, V> scale(F f) {
        return createInstance(
                ab().scale(f),
                cd().scale(f));
    }

    @Override
    public AbstractM2x2<F, V> zero() {
        return createInstance(
                ab().zero(),
                cd().zero());
    }

    @Override
    protected AbstractM2x2<F, V> plus(AbstractM2x2<F, V> e) {
        return createInstance(
                ab().add(e.ab()),
                cd().add(e.cd()));
    }

    @Override
    protected AbstractM2x2<F, V> negate() {
        return createInstance(
                ab().neg(),
                cd().neg());
    };

    @Override
    public boolean equals(Object obj) {
        if (obj.getClass() != getClass()) {
            return false;
        }
        @SuppressWarnings("unchecked")
        AbstractM2x2<F, V> m = (AbstractM2x2<F, V>) obj;
        return ab().equals(m.ab()) && cd().equals(m.cd());
    }

    public abstract AbstractM2x2<F, V> createInstance(V ab, V cd);

    @Override
    public String toString() {
        return ab().toString() + "; " + cd().toString();
    }

    private AbstractM2x2<F, V> id2() {
        return createInstance(ab().ex(), ab().ey());
    }
}
