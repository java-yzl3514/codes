package ba.yzl3514.main;

import java.util.logging.Logger;

/**
 * "Unwind"
 *
 *
 * @author Onder Sahin
 *
 */
public class NestedTryStatements {

    private static final Logger log = Logger.getLogger(NestedTryStatements.class.getName());


    public static void main(String[] args) {

        try {
            int a = 0;
            int result = 100 / a;
            try {
                int[] arr = {};
                arr[10] = 9;
            }catch (ArithmeticException e){
                log.severe("Inner TRY");
                log.severe(e.getMessage());
            }
        } catch (ArithmeticException e) {
            log.severe(e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e){
            log.severe("Outer TRY ");
            log.severe(e.getMessage());
        }

    }
}
