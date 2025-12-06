package ba.yzl3514.hof;

import java.util.function.Function;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */

class A{
    @Override
    public String toString() {
        return "A";
    }
}

class B{
    @Override
    public String toString() {
        return "B";
    }
}

public class TransformFunction {

    public static Function<A,B> beforeTransform(Function<A, B> in) {

        return in.compose(a -> {
            System.out.println("compose: " + a);
            return a;
        });
    }

    public static Function<A,B> transform(Function<A, B> in) {

        return in.andThen(b -> {
            System.out.println(b);
            return b;
        });
    }


    public static void main(String[] args) {

        Function<A, B> function = beforeTransform(a -> {
            System.out.println(a);
            return new B();
        });

        //B b = function.apply(new A());

    }

}
