package ba.yzl3514.streams.create;

import java.util.Random;
import java.util.stream.Stream;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class RandomGenerators {


    public static <T> void printFirst5(Stream<T> stream){
        stream.limit(5).forEach(System.out::println);
        System.out.println("--------------------------------");
    }

    public static void main(String[] args) {
        Random random = new Random();

        printFirst5(random.ints().boxed());
        printFirst5(random.longs().boxed());
        printFirst5(random.doubles().boxed());


        printFirst5(random.ints(30,80).boxed());
        printFirst5(random.longs(1_000_000, 4_000_000).boxed());
        printFirst5(random.doubles(100,1000).boxed());

        printFirst5(random.ints(3,30,80).boxed());
        printFirst5(random.longs(3,1_000_000, 4_000_000).boxed());
        printFirst5(random.doubles(3,100,1000).boxed());

    }
}
