package cyborg.math.alg.field;

import cyborg.math.alg.group.Additive;
import cyborg.math.alg.group.Multiplicatives;

public abstract class Field<E extends Field<E>>
        extends
        Additive<E>
        implements
        Multiplicatives<E>,
        Comparable<E> {

    @Override
    final public E mul(E e) {
        return isNan(e) ? nan() : multiply(e);
    }

    final public boolean isNeg() {
        return compareTo(zero()) < 0;
    }

    protected abstract E multiply(E e);

    @Override
    final public E inv() {
        return (isNan() || equals(zero()))
                ? nan()
                : inverse();
    }

    protected abstract E inverse();

    final public E div(E e) {
        return this.mul(e.inv());
    }

    @SuppressWarnings("unchecked")
    final public E pow(int s) {
        if (s == 0) {
            return unit();
        }
        return (s > 0)
                ? power((E) this, unit(), s)
                : power((E) this, unit(), -s).inv();
    }

    final private E power(E t, E e, int s) {
        if (s == 0) {
            return e;
        }
        return power(t, t.mul(e), s - 1);
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean equals(Object obj) {
        if (getClass() != obj.getClass()) {
            return false;
        }
        return compareTo((E) obj) == 0;
    }
}
