package cyborg.math.lin;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import cyborg.math.alg.field.Frac;
import cyborg.math.alg.lin.V2D;

public class V2DTest {
    private static V2D<Frac> u = v2d(4L, 3L);
    private static V2D<Frac> v = v2d(3L, -2L);

    @SuppressWarnings("deprecation")
    @Test
    void nrmTest1() {
        Frac c = u.nrm();
        assertEquals(5L, c.getN());
        assertEquals(1L, c.getD());
    }

    @Test
    void prdTest1() {
        Frac c = u.prd(v);
        assertEquals(new Frac(6L), c);
    }

    @SuppressWarnings("deprecation")
    @Test
    void scaleTest1() {
        V2D<Frac> c = u.scale(new Frac(3, 4));
        assertEquals(new Frac(3L), c.getX());
        assertEquals(new Frac(9L, 4L), c.getY());

    }

    private static V2D<Frac> v2d(long x, long y) {
        return new V2D<Frac>(
                new Frac(x),
                new Frac(y));
    }
}