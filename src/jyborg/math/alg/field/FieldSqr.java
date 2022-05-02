package jyborg.math.alg.field;

public abstract class Quad<E extends Quad<E>>
        extends Field<E> {

    public E sqr() {
        if (isNan() || compareTo(zero()) > 0) {
            return nan();
        }
        return sqrt();
    };

    protected abstract E sqrt();

    public Double val() {
        return isNan() ? Double.NaN : value();
    }

    protected abstract double value();

}