package jyborg.math.alg;

import jyborg.math.alg.group.Group;

public interface Multiplicatives<E extends Algebraic<E>>
        extends Group<E> {

    public E mul(E f);

    public E unit();

    public E div(E e);
}
