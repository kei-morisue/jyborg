package cyborg.math.alg.lin;

import cyborg.math.alg.field.FieldSqr;

public class M2x2<F extends FieldSqr<F>, V extends V2D<F, V>>
        extends AbstractM2x2<F, V> {
    private V ab;
    private V cd;

    public M2x2(M2x2<F, V> m) {
        this(m.ab, m.cd);
    }

    public M2x2(V ab, V cd) {
        this.ab = ab;
        this.cd = cd;
    }

    @Override
    public AbstractM2x2<F, V> nan() {
        return createInstance(
                ab.nan(),
                cd.nan());
    }

    @Override
    protected V ab() {
        return ab;
    }

    @Override
    protected V cd() {
        return cd;
    }

    @Override
    public AbstractM2x2<F, V> createInstance(V ab, V cd) {
        return new M2x2<F, V>(ab, cd);
    }

}
