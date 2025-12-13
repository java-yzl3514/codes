package ba.yzl3514.streams;

import ba.yzl3514.streams.create.Prime;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class PrimeDriver {

    public static void main(String[] args) {

        new Prime()
                .numbers()
                .limit(10)
                .forEach(System.out::println);

    }
}
