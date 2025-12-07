package ba.yzl3514.streams.create;

import java.util.stream.Stream;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class Fibonacci {

    private int startNumber = 1;


    public Stream<Integer> numbers(){

        return Stream.iterate(0, i-> {
                int r = startNumber + i;
                startNumber = i;
                return r;
        });
    }

}
