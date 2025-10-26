package ba.yzl3514.exercises.solution_0;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class FourTuple<A, B, C, D> extends ThreeTuple<A, B, C> {
    public final D d;

    public FourTuple(A a, B b, C c, D d) {
        super(a, b, c);
        this.d = d;
    }

    @Override
    public String toString() {
        return "{" + a + ", " + b + ", " + c + ", " + d + "}";
    }
}
