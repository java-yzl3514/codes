package ba.yzl3514.streams;

import ba.yzl3514.streams.create.RandomTextGenerator;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class RandomTextGeneratorDriver {

    public static void main(String[] args) {
        String word = Stream.generate(new RandomTextGenerator())
                .limit(20)
                .collect(Collectors.joining());
        System.out.println(word);
    }
}
