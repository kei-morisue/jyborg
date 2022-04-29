package jyborg.math.alg;

import jyborg.math.alg.group.SemiGroup;

public interface Monoid<E extends Algebraic<E>>
        extends SemiGroup<E> {
    @Deprecated
    public E identity();
}
