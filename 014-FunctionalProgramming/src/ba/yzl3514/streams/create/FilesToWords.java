package ba.yzl3514.streams.create;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class FilesToWords {
    private String content;

    public FilesToWords(String filePath) throws Exception{
      content = Files
              .lines(Path.of(filePath)).collect(Collectors.joining(" "));
    }

    public Stream<String> stream(){
        return Pattern.compile("[ .,?!]+").splitAsStream(content);
    }
}
