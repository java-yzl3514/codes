package ba.yzl3514.streams.create;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class RandomText implements Supplier<String> {

    private List<String> words = new ArrayList<>();
    private Random random= new Random();

    public RandomText(String filePath) throws IOException{
        List<String> allLines = Files.readAllLines(Path.of(filePath));
        for(String line : allLines){
            for(String word : line.split("[ .?,]+")){
                    words.add(word.toLowerCase());
            }
        }
    }

    @Override
    public String toString() {
        // TODO
        return "";
    }

    @Override
    public String get() {
        return words.get(random.nextInt(words.size()));
    }
}
