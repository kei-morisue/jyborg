package cyborg.math.alg.lin;

import cyborg.math.alg.field.FieldSqr;

public abstract class Matrix<F extends FieldSqr<F>, V extends Vector<F, V>, M extends Matrix<F, V, M>>
        extends Linear<F, M> {
    // applies v to this matrix
    public abstract V apply(V v);

    // gives matrix multiplication
    public abstract M apply(M m);

    // gives identity matrix
    public abstract M idt();

    // get determinant value
    public abstract F det();

    //get inverse matrix
    public abstract M inv();

    // get transpose
    public abstract M trps();

}
