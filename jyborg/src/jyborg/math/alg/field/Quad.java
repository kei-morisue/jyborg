package jyborg.math.alg.field;

public abstract class Quad<E extends Quad<E>>
        extends Field<E> {

    public E sqr() {
        return isNan() ? nan() : sqrt();
    };

    protected abstract E sqrt();

    public Double val() {
        return isNan() ? Double.NaN : value();
    }

    protected abstract double value();

}
