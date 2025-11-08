package ba.yzl3514.main;

import ba.yzl3514.exceptions.LoggingException;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class LoggingExceptionApp {

    public static void main(String[] args) {

        try {
            throw new LoggingException();
        } catch (LoggingException e) {
            System.err.println("Handler : " + e);
        }

    }

}
