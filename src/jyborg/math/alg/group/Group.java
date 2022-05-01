package jyborg.math.alg.group;

import jyborg.math.alg.Monoid;

public interface Group<E extends Group<E>> extends Monoid<E> {
    public abstract boolean isNan();

    public abstract E nan();

}
