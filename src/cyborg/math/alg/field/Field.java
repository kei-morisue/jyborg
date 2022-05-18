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
        return e.isNan() ? nan() : multiply(e);
    }

    final public boolean isNeg() {
        return isSmaller(zero());
    }

    final public boolean isSmaller(E e) {
        return compareTo(e) < 0;
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

    final public E div(int e) {
        return this.div(unit().mul(e));
    }

    final public E pow(int s) {
        E unit = unit();
        if (s == 0) {
            return unit;
        }
        return (s > 0)
                ? power(mul(unit), unit, s)
                : power(mul(unit), unit, -s).inv();
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
        if (this == obj) {
            return true;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        return compareTo((E) obj) == 0;
    }

    @Override
    public int hashCode() {
        return getHash();
    }

    protected abstract int getHash();
}
