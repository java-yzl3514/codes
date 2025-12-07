package ba.yzl3514.streams;

import ba.yzl3514.streams.create.Fibonacci;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class FibonacciDriver {

    public static void main(String[] args) {
        new Fibonacci().numbers().skip(10)
                .limit(10).forEach(System.out::println);
    }
}
