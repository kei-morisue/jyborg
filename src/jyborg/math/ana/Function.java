package jyborg.math.ana;

import jyborg.math.alg.field.Field;

public interface Function {
    public <E extends Field<E>> E apply(E e);

    public <E extends Field<E>> E der(E e);

    public <E extends Field<E>> E init();

    public <N extends Number> N apply(N e);

    public <N extends Number> N der(N e);

    public <N extends Number> N init(N e);

}
