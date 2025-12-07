package ba.yzl3514.streams;

import ba.yzl3514.streams.create.RandomText;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class RandomTextDriver {
    // logger

    public static void main(String[] args) {
        try {
            RandomText randomText = new RandomText("lorem.txt");
            String collected = Stream.generate(randomText).limit(10).collect(Collectors.joining("-"));
            System.out.println(collected);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
