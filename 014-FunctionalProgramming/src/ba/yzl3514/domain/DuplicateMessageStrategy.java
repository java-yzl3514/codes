package ba.yzl3514.domain;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class DuplicateMessageStrategy{

    public static String apply(String msg) {
        return msg + " " + msg;
    }
}
