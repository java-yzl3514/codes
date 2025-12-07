package ba.yzl3514.streams.create;

import java.util.Random;
import java.util.function.Supplier;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class RandomTextGenerator implements Supplier<String>{
    private Random random = new Random();
    private char[] letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

    @Override
    public String get() {
        return "" + letters[random.nextInt(letters.length)];
    }
}
