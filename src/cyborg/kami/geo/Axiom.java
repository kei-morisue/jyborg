package cyborg.kami.geo;

import cyborg.math.alg.field.FieldSqr;

public class Axiom {

    // Axiom 1
    public static <F extends FieldSqr<F>, V extends D0<F, V>> Line<F, V> apply(
            V p1,
            V r) {
        return new Line<F, V>(r, p1.dir(r));
    }

    // Axiom 4
    public static <F extends FieldSqr<F>, V extends D0<F, V>> Line<F, V> apply(
            Seg<F, V> d1,
            V r) {
        return new Line<F, V>(r, d1.n());
    }

    // Axiom 2
    public static <F extends FieldSqr<F>, V extends D0<F, V>> Line<F, V> apply(
            Seg<F, V> seg) {
        Dir<F> d = seg.d();

        return new Line<F, V>(
                seg.m(),
                d.n());
    }

    // Axiom 3
    public static <F extends FieldSqr<F>, V extends D0<F, V>> Line<F, V> apply(
            Seg<F, V> seg1,
            Seg<F, V> seg2,
            boolean isAlt) {
        Dir<F> d1 = seg1.d();
        Dir<F> n2 = seg2.n();
        Dir<F> d2 = seg2.d();

        F d = n2.prd(d1);
        Dir<F> d0 = seg1.p.dir(seg2.p);
        if (d.equals(d.zero())) {
            return new Line<F, V>(
                    (new Seg<F, V>(seg1.p, seg2.p)).m(),
                    d1);
        }

        Dir<F> dp = d1.scale(d2.nrm()).add(d2.scale(d1.nrm()));
        Dir<F> dm = dp.n();
        return new Line<F, V>(
                seg1.extend(n2.prd(d0).neg().div(d)),
                isAlt ? dm : dp);
    }

    // Axiom 3
    public static <F extends FieldSqr<F>, V extends D0<F, V>> Line<F, V> apply(
            V p1,
            Seg<F, V> seg2,
            V r,
            boolean isAlt) {
        //TODO
        return null;
    }
}
