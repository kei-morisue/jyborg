package jyborg.math.alg.group;

import jyborg.math.alg.Algebraic;
import jyborg.math.alg.Monoid;

public interface Group<E extends Algebraic<E>>
        extends Monoid<E> {
    @Deprecated
    public E inverse(E e);
}
