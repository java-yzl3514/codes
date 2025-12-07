package ba.yzl3514.streams.create;

import java.util.function.Consumer;
import java.util.stream.IntStream;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class Iterations {

    public static void iterateTo(int bound, Consumer<Integer> action){
        IntStream.range(0,bound).forEach(action::accept);
    }
}
