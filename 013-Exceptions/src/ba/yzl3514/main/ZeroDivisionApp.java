package ba.yzl3514.main;

import ba.yzl3514.exceptions.CustomException;
import ba.yzl3514.exceptions.SimpleRuntimeException;

import java.io.IOException;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class ZeroDivisionApp {

    public static void main(String[] args) {

        System.out.println("flow is started...");

        try {
            //throw new Error();
            // System.out.println(division(5, 0));
        } catch (ArithmeticException e) {
            System.out.println("divided by 0(zero)");
        }

        System.out.println("flow is continue...");

    }

    private static int division(int dividend, int divisor) {
        if (divisor == 0)
            throw new SimpleRuntimeException();
        return dividend / divisor;
    }

}
