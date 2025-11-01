package ba.yzl3514.factory_method;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class PdfDocumentFactory implements DocumentFactory {

    @Override
    public PdfDocument createDocument() {
        return new PdfDocument();
    }
}
