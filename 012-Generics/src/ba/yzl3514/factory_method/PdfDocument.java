package ba.yzl3514.factory_method;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class PdfDocument implements Document{

    @Override
    public void open() {
        System.out.println("Opening the pdf document...");
    }

    @Override
    public void close() {
        System.out.println("Closing the pdf document...");
    }
}
