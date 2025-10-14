/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class Initializers {

    public static final int VALUE = 100;

    public final int finalValue = 900;

    static {
        System.out.println("Initializers.static.block");
    }
}
