package cyborg.math.alg.group;

public interface Group<E extends Group<E>> extends Monoid<E> {
    public abstract boolean isNan();

    public abstract E nan();

}
