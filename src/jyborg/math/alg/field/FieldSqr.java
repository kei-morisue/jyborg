package jyborg.math.alg.field;

public abstract class FieldSqr<E extends FieldSqr<E>>
        extends Field<E> {

    final public E sqr() {
        if (isNan() || isNeg()) {
            return nan();
        }
        return sqrt();
    };

    protected abstract E sqrt();

    final public Double val() {
        return isNan() ? Double.NaN : value();
    }

    protected abstract double value();

}
