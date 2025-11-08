package ba.yzl3514.exceptions;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;

/**
 *
 * @author Onder Sahin
 *
 */
public class LoggingException extends Exception{

    private static Logger logger = Logger.getLogger("LoggingException");

    public LoggingException(){
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        printStackTrace(printWriter);
        logger.severe(stringWriter.toString());
    }
}
