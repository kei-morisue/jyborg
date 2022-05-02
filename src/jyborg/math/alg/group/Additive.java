package jyborg.math.alg.group;

public abstract class Additive<E extends Additive<E>>
        implements AbelianGroup<E> {
    public E add(E e) {
        return isNan(e) ? nan() : plus(e);
    }

    public abstract E zero();

    public E neg() {
        return isNan() ? nan() : negate();
    };

    protected abstract E plus(E e);

    protected abstract E negate();

    protected boolean isNan(E e) {
        return e.isNan() || this.isNan();
    }

    public E sub(E e) {
        return this.add(neg());
    };

    public E x(int s) {
        if (s == 0) {
            return zero();
        }
        return (s > 0)
                ? times(zero(), s)
                : times(zero(), -s).neg();
    }

    private E me() {
        return add(zero());
    }

    private E times(E e, int s) {
        if (s == 0) {
            return e;
        }
        return times(me().add(e), s - 1);
    }
}
