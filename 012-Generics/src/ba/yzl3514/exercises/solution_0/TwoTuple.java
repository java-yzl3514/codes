package ba.yzl3514.exercises.solution_0;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class TwoTuple<A, B> {

    public final A a;
    public final B b;

    public TwoTuple(A a, B b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public String toString() {
        return "{" + a + "," + b + "}";
    }
}
