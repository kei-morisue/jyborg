package cyborg.math.alg.group;

public abstract class Additive<E extends Additive<E>>
        implements AbelianGroup<E> {
    final public E add(E e) {
        return e.isNan() ? nan() : plus(e);
    }

    public abstract E zero();

    final public E neg() {
        return isNan() ? nan() : negate();
    };

    protected abstract E plus(E e);

    protected abstract E negate();

    final public E sub(E e) {
        return this.add(e.neg());
    };

    final public E mul(int s) {
        E zero = zero();
        if (s == 0) {
            return zero;
        }
        return (s > 0)
                ? times(add(zero), zero, s)
                : times(add(zero), zero, -s).neg();
    }

    final private E times(E t, E e, int s) {
        if (s == 0) {
            return e;
        }
        return times(t, t.add(e), s - 1);
    }
}
