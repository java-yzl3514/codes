package ba.yzl3514.streams;

import ba.yzl3514.streams.create.CountTask;
import ba.yzl3514.streams.create.Iterations;
import ba.yzl3514.streams.create.RepeatUtil;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class RepeatDriver {

    public static void main(String[] args) {

        RepeatUtil.repeat(5, ()-> System.out.println("Hello Java Streams !"));

        Iterations.iterateTo(10, System.out::println);
        System.out.println("------------------------");
        RepeatUtil.repeat(10, new CountTask()::run);

    }
}
