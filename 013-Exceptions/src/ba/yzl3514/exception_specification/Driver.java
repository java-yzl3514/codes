package ba.yzl3514.exception_specification;

import java.io.IOException;
import java.util.logging.Logger;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class Driver {

    private static final Logger log = Logger.getLogger(Driver.class.getName());

    public static void main(String[] args) {

        DatabaseDriver databaseDriver = new DatabaseDriver();
        try {
            databaseDriver.connect();
        } catch (Exception e) {
            log.severe(e.getMessage());
        }
        log.info("main thread is continue");

    }
}
