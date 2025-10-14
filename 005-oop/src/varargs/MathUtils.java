package varargs;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class MathUtils {

    public static int sum(int... numbers){
        int sum = 0;
        for(int number: numbers)
            sum += number;
        return sum;
    }
}
