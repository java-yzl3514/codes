/**
 * @author Onder Sahin
 */
public class TextBlocks {
    public static void main(String[] args) {


        String block = """
                Bu bir
                            metin

                                    bloğudur
    """;

        String block2 = """
                Bu bir
                \u000d
                           metin
                                    \n
                                    bloğudur
                                    \u000A
    """;

        System.out.println(block);
        System.out.println(block2);

        String block3 = """
                \\
                """;
        System.out.println(block3);
    }
}
