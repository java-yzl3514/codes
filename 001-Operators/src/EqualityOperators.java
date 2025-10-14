/**
 * @author Onder Sahin
 */
public class EqualityOperators {

    public static void main(String[] args) {

        String str1 = new String("yazı");
        String str2 = new String("yazı");

        System.out.println("yazı" == "yazı");
        System.out.println(str1 == str2);
        System.out.println(str1.equals(str2));

    }
}
