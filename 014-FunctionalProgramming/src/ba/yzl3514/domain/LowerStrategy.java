package ba.yzl3514.domain;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class LowerStrategy implements Strategy{
    @Override
    public String apply(String msg) {
        return msg.toLowerCase();
    }
}
