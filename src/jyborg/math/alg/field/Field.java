package jyborg.math.alg.field;

import jyborg.math.alg.Additive;
import jyborg.math.alg.Multiplicatives;

public abstract class Field<E extends Field<E>>
        extends
        Additive<E>
        implements
        Multiplicatives<E>,
        Comparable<E> {

    @Override
    public E mul(E e) {
        return isNan(e) ? nan() : multiply(e);
    }

    protected abstract E multiply(E e);

    @Override
    public E inv() {
        return (isNan() || equals(zero())) ? nan() : inverse();
    }

    protected abstract E inverse();

    public E div(E e) {
        return this.mul(e.inv());
    }

}
