package cyborg.kami.geo;

import cyborg.math.alg.field.FieldSqr;

public class Intersection {
    public static <F extends FieldSqr<F>, V extends D0<F, V>> F c1(
            Dir<F> d1,
            Dir<F> d2,
            V p1,
            V p2) {
        Dir<F> n2 = d2.n();
        return n2.prd(p2.dir(p1)).div(n2.prd(d1));
    }

    public static <F extends FieldSqr<F>, V extends D0<F, V>> F c2(
            Dir<F> d1,
            Dir<F> d2,
            V p1,
            V p2) {
        return c1(d2, d1, p2, p1);
    }

    public static <F extends FieldSqr<F>, V extends D0<F, V>> V Connection(
            Seg<F, V> l1,
            Seg<F, V> l2) {
        V r = apply(l1, l2);
        if (r == null) {
            return null;
        }
        if (r.equals(l2.p)) {
            return r;
        }
        if (r.equals(l2.q)) {
            return r;
        }
        return null;
    }

    public static <F extends FieldSqr<F>, V extends D0<F, V>> V apply(
            Line<F, V> l1,
            Line<F, V> l2) {
        Dir<F> d1 = l1.d;
        Dir<F> n2 = l2.d.n();
        if (d1.isPerp(n2)) {
            return null;
        }
        V p1 = l1.p;
        F c1 = c1(d1, l2.d, p1, l2.p);
        return d1.scale(c1).from(p1);
    }

    public static <F extends FieldSqr<F>, V extends D0<F, V>> V apply(
            Seg<F, V> s1,
            Line<F, V> l2) {
        Dir<F> d1 = s1.d();
        Dir<F> d2 = l2.d;
        Dir<F> n2 = d2.n();
        if (d1.isPerp(n2)) {
            return null;
        }
        F c1 = c1(d1, d2, s1.p, l2.p);
        return apply(s1, c1);
    }

    private static <F extends FieldSqr<F>, V extends D0<F, V>> V apply(
            Seg<F, V> s,
            F c) {
        F one = c.unit();
        if (c.isNeg()) {
            return null;
        }
        if (one.isSmaller(c)) {
            return null;
        }
        if (c.equals(one)) {
            return s.p;
        }
        if (c.equals(c.zero())) {
            return s.q;
        }
        return s.extend(c);
    }

    public static <F extends FieldSqr<F>, V extends D0<F, V>> V apply(
            Seg<F, V> s1,
            Seg<F, V> s2) {
        Dir<F> d1 = s1.d();
        Dir<F> d2 = s2.d();
        Dir<F> n2 = d2.n();
        if (d1.isPerp(n2)) {
            return null;
        }
        V p1 = s1.p;
        V p2 = s2.p;
        F c1 = c1(d1, d2, p1, p2);
        F c2 = c2(d1, d2, p1, p2);

        F one = c1.unit();
        F zero = c1.zero();
        if (c1.isNeg()) {
            return null;
        }
        if (one.isSmaller(c1)) {
            return null;
        }

        V q2 = s2.q;
        if (c1.equals(one)) {
            return apply(s1.q, p2, q2, c2);
        }
        if (c1.equals(zero)) {
            return apply(p1, p2, q2, c2);
        }
        return apply(s2, c2);
    }

    private static <F extends FieldSqr<F>, V extends D0<F, V>> V apply(
            V r,
            V p2,
            V q2,
            F c2) {
        if (c2.isNeg()) {
            return null;
        }
        if (c2.isNeg()) {
            return null;
        }
        return r;
    }
}
