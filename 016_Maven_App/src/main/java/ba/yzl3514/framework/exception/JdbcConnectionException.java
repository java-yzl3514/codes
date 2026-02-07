package ba.yzl3514.framework.exception;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class JdbcConnectionException extends RuntimeException {


    public JdbcConnectionException() {
    }

    public JdbcConnectionException(String message) {
        super(message);
    }

    public JdbcConnectionException(String message, Throwable cause) {
        super(message, cause);
    }
}
