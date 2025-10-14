/**
 * @author Onder Sahin
 */
public class Characters {
    public static void main(String[] args) {


        char c = 'A';

        char v = 65;

        System.out.println(c);
        System.out.println(v);

        // ' ve \ olarak yapılan girişler kabul edilmez
        //System.out.println(''); // COMPILE-TIME ERROR
        //System.out.println('''); // COMPILE-TIME ERROR
        //System.out.println('\'); // COMPILE-TIME ERROR

        // Escape-sequence
        char newLine = '\n';
        char tab = '\t';
        char quote = '\'';
        char backslash = '\\';

        //char bad1 = 'ab'; // COMPILE-TIME ERROR
        //char bad2 = ''; // COMPILE-TIME ERROR
        //char bad3 = '; // COMPILE-TIME ERROR


        // Base-16 escape-sequence  \u0000 - \uFFFF
        char u1 = '\u0061';

        System.out.println(u1);

        char o1 = '\141';

        System.out.println(o1);\u000A

        //\u000A
        // char base16NewLine = '\u000A
        // \u0027 -> '
        //char base16Quote = '\u0027';' // COMPILE-TIME ERROR


    }
}
