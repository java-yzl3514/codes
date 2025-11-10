package ba.yzl3514.main;

import java.util.logging.Logger;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class MultipleCatchClauses {

    private static final Logger log = Logger.getLogger(MultipleCatchClauses.class.getName());

    public static void main(String[] args) {

        try {
            int argCount = args.length;
            int division = 34 / argCount;
            int[] arr = {100};
            arr[9] = 400;
        }catch (ArithmeticException e){
            log.severe(e.toString());
        }catch (ArrayIndexOutOfBoundsException e){
            log.severe(e.getMessage());
        }

        log.info("After try/catch block");
    }

}
