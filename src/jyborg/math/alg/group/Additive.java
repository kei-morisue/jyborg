package jyborg.math.alg.group;

public abstract class Additive<E extends Additive<E>>
        implements AbelianGroup<E> {
    final public E add(E e) {
        return isNan(e) ? nan() : plus(e);
    }

    public abstract E zero();

    final public E neg() {
        return isNan() ? nan() : negate();
    };

    protected abstract E plus(E e);

    protected abstract E negate();

    final protected boolean isNan(E e) {
        return e.isNan() || this.isNan();
    }

    final public E sub(E e) {
        return this.add(neg());
    };

    @SuppressWarnings("unchecked")
    final public E x(int s) {
        if (s == 0) {
            return zero();
        }
        return (s > 0)
                ? times((E) this, zero(), s)
                : times((E) this, zero(), -s).neg();
    }

    final private E times(E t, E e, int s) {
        if (s == 0) {
            return e;
        }
        return times(t, t.add(e), s - 1);
    }
}
