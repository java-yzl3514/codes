/**
 * @author Onder Sahin
 */
public class DividendIntegerOverflow {
    public static void main(String[] args) {


        int n = Integer.MIN_VALUE;
        int d = -1;

        int result = n / d;
        System.out.println(result);
    }
}
