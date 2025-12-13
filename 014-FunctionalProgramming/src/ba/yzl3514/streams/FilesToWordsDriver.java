package ba.yzl3514.streams;

import ba.yzl3514.streams.create.FilesToWords;

import java.util.Comparator;
import java.util.Objects;
import java.util.Optional;
import java.util.Random;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class FilesToWordsDriver {

    public static void main(String[] args) {

        try {
            FilesToWords filesToWords = new FilesToWords("lorem.txt");
//            filesToWords.stream()
//                    .skip(20)
//                    .peek(System.out::println)
//                    .map(String::toUpperCase)
//                    .peek(System.out::println)
//                    .map(String::toLowerCase)
//                    .forEach(System.out::println);

//            filesToWords.stream()
//                    .limit(10)
//                    .map(String::toLowerCase)
//                    .sorted(Comparator.reverseOrder())
//                    .forEach(System.out::println);


            new Random()
                    .ints(0, 100)
                    .limit(10)
                    .boxed()
                    .sorted(Comparator.reverseOrder())
                    .forEach(System.out::println);



        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
