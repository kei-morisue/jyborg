package cyborg.kami.geo;

import java.util.ArrayList;
import java.util.List;

import cyborg.math.alg.field.FieldSqr;

public class Pip<F extends FieldSqr<F>, V extends D0<F, V>> {
    public static final int IN = 1;
    public static final int OUT = -1;
    public static final int ON = 0;

    private final List<V> hoop;
    private List<Dir<F>> d = new ArrayList<Dir<F>>();
    private List<F> a = new ArrayList<F>();
    private Dir<F> d0;

    public Pip(List<V> hoop) {
        this.hoop = hoop;
    }

    public int apply(V w) {
        if (testV(w) != null) {
            return ON;
        }
        if (testE(w) != null) {
            return ON;
        }
        if (hoop.size() == 3) {
            return testTriangle(w);
        }
        setD0(w);
        return testEvenOdd(w);

    }

    private V testV(
            V w) {
        for (V v : hoop) {
            if (v.equals(w)) {
                return v;
            }
        }
        return null;
    }

    // TODO refactor
    private V testE(V w) {
        V vi = hoop.get(hoop.size() - 1);
        Dir<F> di = vi.dir(w);
        for (V vj : hoop) {
            Dir<F> dj = vj.dir(w);
            F aij = dj.out(di);
            F zero = aij.zero();
            if (aij.equals(zero)) {
                if (dj.prd(di).isNeg()) {
                    return vi;
                }
            }
            d.add(dj);
            a.add(aij);
            di = dj;
        }
        return null;
    }

    private int testTriangle(V w) {
        boolean a1 = a.get(0).isNeg();
        boolean a2 = a.get(1).isNeg();
        if (!a1 == a2) {
            return OUT;
        }
        boolean a3 = a.get(2).isNeg();
        if (!a2 == a3) {
            return OUT;
        }
        return IN;
    }

    // TODO refactor
    private void setD0(V w) {
        Dir<F> dn = d.get(d.size() - 1);
        F x = null;
        F y = null;
        F tan = null;
        for (Dir<F> di : d) {
            F xi = di.prd(dn);
            F zero = xi.zero();
            if (xi.equals(zero)) {
                continue;
            }
            F yi = di.out(dn);
            if (yi.equals(zero)) {
                continue;
            }
            F tani = yi.div(xi).abs();
            if (tan == null || tani.isSmaller(tan)) {
                tan = tani;
                x = xi.abs();
                y = yi.abs();
            }
        }
        d0 = dn.add(dn.createInstance(x, y));
    }

    //TODO Implementation
    private int testEvenOdd(V w) {
        return IN;
    }
}
