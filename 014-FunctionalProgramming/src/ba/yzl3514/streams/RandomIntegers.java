package ba.yzl3514.streams;

import java.util.Random;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.IntStream;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class RandomIntegers {


    public static IntStream declarativeWay() {
        return new Random()
                .ints(5, 20)
                .distinct()
                .limit(10)
                .sorted();
    }

    public static void imperativeWay() {
        Set<Integer> numbers = new TreeSet<>();
        Random random = new Random();
        /*
        for (int i = 0; i < 10; ) {
            int randomNumber = random.nextInt(5, 20);
            if (numbers.contains(randomNumber)) continue;
            numbers.add(randomNumber);
            i++;
        }
         */

        /*
        for (int i = 0; i < 10; ) {
            if (numbers.add(random.nextInt(5, 20)))
                i++;
        }
         */

        /*
        int control = 10;
        while (control > 0) {
            if (numbers.add(random.nextInt(5, 20)))
                control--;
        }
         */

        while(numbers.size() < 10)
            numbers.add(random.nextInt(5, 20));
        System.out.println(numbers);
        System.out.println(numbers.size());
    }

    public static void main(String[] args) {

        IntStream ints = new Random().ints(1, 10);


    }
}
