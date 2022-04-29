package jyborg.math.alg.group;

import jyborg.math.alg.Algebraic;

public interface SemiGroup<E extends Algebraic<E>> {
    // Must be associative
    @Deprecated
    public E apply(E a, E b, E c);
}
