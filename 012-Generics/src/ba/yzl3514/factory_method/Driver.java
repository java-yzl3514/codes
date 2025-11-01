package ba.yzl3514.factory_method;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class Driver {

    public static void main(String[] args) {


        DocumentFactory documentFactory = new WordDocumentFactory();

        Document document = documentFactory.createDocument();
        document.open();

        document.close();

        System.out.println("----");

        //...
        documentFactory = new PdfDocumentFactory();
        document = documentFactory.createDocument();

        document.open();

        document.close();
    }
}
