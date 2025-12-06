package ba.yzl3514.hof;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class ProduceFunc {


    // hof
    public static StringToStringFunction produce(){
        return s -> s.toUpperCase();
    }


    public static void main(String[] args) {

        StringToStringFunction stringToStringFunction = produce();

        System.out.println(stringToStringFunction.apply("higher-order function"));

    }
}
