package ba.yzl3514.streams.create;

import ba.yzl3514.streams.Action;

import java.util.function.Consumer;
import java.util.stream.IntStream;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class RepeatUtil {

    /*
    public static void repeat(int n, Action action){
        IntStream.range(0,n).forEach((i) -> action.execute());
    }
     */

    public static void repeat(int n, Runnable action){
        IntStream.range(0,n).forEach((i) -> action.run());
    }

}
