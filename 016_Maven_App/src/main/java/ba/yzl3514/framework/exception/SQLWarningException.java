package ba.yzl3514.framework.exception;

import java.sql.SQLWarning;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class SQLWarningException extends RuntimeException {


    public SQLWarningException(String message, SQLWarning ex) {
        super(message, ex);
    }


    public SQLWarning getSQLWarning() {
        return (SQLWarning) getCause();
    }
}
