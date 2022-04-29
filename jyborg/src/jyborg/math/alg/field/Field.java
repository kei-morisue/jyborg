package jyborg.math.alg.field;

import jyborg.math.alg.Additive;
import jyborg.math.alg.Algebraic;
import jyborg.math.alg.Multiplicatives;

public interface Field<E extends Algebraic<E>>
        extends
        Additive<E>,
        Multiplicatives<E>,
        Comparable<E> {

}
