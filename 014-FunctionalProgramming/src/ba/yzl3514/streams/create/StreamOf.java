package ba.yzl3514.streams.create;

import java.util.stream.Stream;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class StreamOf {


    public static void main(String[] args) {

        Stream.of("It", "is ", " a ", " wonderful ", "day", "for", "learning", "Java", "Stream", " API")
                .forEach(System.out::println);
        Stream.of(1,45,123,63547).forEach(System.out::println);

    }

}
