package ba.yzl3514.streams;

import ba.yzl3514.streams.create.Prime;

import java.util.Optional;
import java.util.OptionalLong;
import java.util.stream.Stream;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class OptionalDriver {

    public static void main(String[] args) {


        Optional<Object> first = Stream.empty().findFirst();

        System.out.println(first.isPresent());

        OptionalLong first1 = new Prime().numbers().findFirst();

        System.out.println(first1.isPresent());
        System.out.println(first1.getAsLong());

        System.out.println("===============================");

        System.out.println(new Prime().numbers().boxed().findFirst().orElse(getDefaultValue()));

        System.out.println("===================================");

        System.out.println(Stream.empty().findFirst().orElseGet(() -> {
            System.out.println("or else get is evaluated");
            return 0L;
        }));
    }

    public static Long getDefaultValue() {
        System.out.println("getDefaultValue is evaluated");
        return 0L;
    }
}
