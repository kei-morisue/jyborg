package jyborg.math.alg;

import jyborg.math.alg.group.AbelianGroup;

public interface Additive<E extends Algebraic<E>>
        extends AbelianGroup<E> {
    public E add(E f);

    public E zero();

    public E neg(E e);
}
