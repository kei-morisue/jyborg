package cyborg.kami.geo;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

import cyborg.math.alg.field.Frac;

class PipTest {
    static final ArrayList<Pt<Frac>> hoop = new ArrayList<Pt<Frac>>(
            Arrays.asList(
                    pt(50L, -200L),
                    pt(80L, 160L),
                    pt(50L, 0L),
                    pt(0L, 100L),
                    pt(0L, 0L),
                    pt(-100L, -200L)));
    static Pip<Frac, Pt<Frac>> pip = new Pip<Frac, Pt<Frac>>(hoop);

    @Test
    void pipTest1() {
        assertEquals(
                Pip.ON,
                pip.apply(pt(50L, 0L)));
    }

    @Test
    void pipTest2() {
        assertEquals(
                Pip.ON,
                pip.apply(pt(-40L, -80L)));
    }

    private static Pt<Frac> pt(
            long x, long y) {
        return new Pt<Frac>(
                new Frac(x),
                new Frac(y));
    }

}
