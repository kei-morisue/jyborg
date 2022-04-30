package jyborg.math.alg;

import jyborg.math.alg.group.AbelianGroup;

public abstract class Additive<E extends Additive<E>>
        implements AbelianGroup<E> {
    public E add(E e) {
        return isNan(e) ? nan() : plus(e);
    }

    public abstract E zero();

    public E neg() {
        return isNan() ? nan() : negate();
    };

    protected abstract E plus(E e);

    protected abstract E negate();

    protected boolean isNan(E e) {
        return e.isNan() || this.isNan();
    }

    public E sub(E e) {
        return this.add(neg());
    };
}
