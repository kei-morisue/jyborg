package cyborg.kami.geo;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import cyborg.math.alg.field.Frac;

public class D0Test {
    private static D0Point<Frac> u = pt(4L, 3L);
    private static D0Point<Frac> v = pt(3L, -2L);

    @SuppressWarnings("deprecation")
    @Test
    void dirTest1() {
        Dir<Frac> c = u.dir(v);
        assertEquals(new Frac(1L), c.getX());
        assertEquals(new Frac(5L), c.getY());
    }

    @Test
    void serializeTest1() throws IOException, ClassNotFoundException {
        D0Point<Frac> read = TestUtil.io(u);
        assertEquals(new Frac(4L), read.getX());
        assertEquals(new Frac(3L), read.getY());
    }

    @Test
    void serializeTest2() throws IOException, ClassNotFoundException {
        D0Point<Frac> read = TestUtil.io(v);
        assertEquals(new Frac(3L), read.getX());
        assertEquals(new Frac(-2L), read.getY());
    }

    private static D0Point<Frac> pt(long x, long y) {
        return new D0Point<Frac>(
                new Frac(x),
                new Frac(y));
    }
}