package jyborg.math.alg;

import jyborg.math.alg.group.Group;

public interface Multiplicatives<E extends Multiplicatives<E>>
        extends Group<E> {

    public E mul(E f);

    public E unit();

    public E inv();

}
