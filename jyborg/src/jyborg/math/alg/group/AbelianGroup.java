package jyborg.math.alg.group;

import jyborg.math.alg.Algebraic;

public interface AbelianGroup<E extends Algebraic<E>>
        extends Group<E> {
    // Must be comutable
    @Deprecated
    public E apply(E a, E b);
}
