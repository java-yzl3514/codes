package ba.yzl3514.main;

import ba.yzl3514.exceptions.CustomException;
import ba.yzl3514.exceptions.SimpleRuntimeException;

import java.io.IOException;
import java.util.logging.Logger;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class ZeroDivisionApp {

    private static Logger logger = Logger.getLogger("ZeroDivisionApp");

    public static void main(String[] args) {

        logger.info("flow is started...");
        System.out.println("---This is sys.out message---");

        try {
            //throw new Error();
            System.out.println(division(5, 0));
        } catch (SimpleRuntimeException e) {
            logger.severe(e.toString());
            //e.printStackTrace();
            // call recoveryMethod() !!!
        }

        logger.info("After try/catch block");

        division(10, 0);

        logger.info("flow is continue...");


    }

    private static int division(int dividend, int divisor) {
        if (divisor == 0)
            throw new SimpleRuntimeException();
        return dividend / divisor;
    }

}
