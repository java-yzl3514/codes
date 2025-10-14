/**
 * @author Onder Sahin
 */
public class IfThenChaining {

    public static void main(String[] args) {

        boolean condition = true;

        if (condition)
            System.out.println("A");
        else if (!condition)
            System.out.println("B");
        else if (condition)
            System.out.println("C");
        else if (condition)
            System.out.println("D");
        else
            System.out.println("E");

    }
}
