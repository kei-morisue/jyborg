package cyborg.math.alg.field;

public final class Real
        extends FieldSqr<Real> {
    private Double v = 0.0;

    public <V extends Number> Real(V v) {
        this.v = v.doubleValue();
    }

    @Override
    protected Real plus(Real f2) {
        return new Real(v + f2.v);
    }

    @Override
    public Real zero() {
        return new Real(0.0);
    }

    @Override
    protected Real multiply(Real f) {
        return new Real(v * f.v);
    }

    @Override
    public Real unit() {
        return new Real(1.0);
    }

    @Override
    public int compareTo(Real f) {
        return Double.compare(v, f.v);
    }

    @Override
    protected Real sqrt() {
        return new Real(Math.sqrt(v));
    }

    @Override
    protected double value() {
        return v;
    }

    @Override
    protected Real negate() {
        return new Real(-v);
    }

    @Override
    public boolean isNan() {
        return Double.isNaN(v);
    }

    @Override
    public Real nan() {
        return new Real(Double.NaN);
    }

    @Override
    protected Real inverse() {
        return new Real(1.0 / v);
    }

    @Deprecated
    public Double getV() {
        return v;
    }

    @Deprecated
    public void setV(Double v) {
        this.v = v;
    }

    @Override
    public String toString() {
        return v.toString();
    }

    @Override
    protected int getHash() {
        return v.hashCode();
    }
}
