package ba.yzl3514.factory_method;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class WordDocument implements Document{

    @Override
    public void open() {
        System.out.println("Opening the word document... ");
    }

    @Override
    public void close() {
        System.out.println("Closing the word document... ");
    }
}
