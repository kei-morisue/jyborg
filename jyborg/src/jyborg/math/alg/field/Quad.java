package jyborg.math.alg.field;

import jyborg.math.alg.Algebraic;

public interface Quad<E extends Algebraic<E>>
        extends Field<E> {

    public E sqrt();

    public boolean isSquared();

}
