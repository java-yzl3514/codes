package ba.yzl3514.factory_method.generic;

import ba.yzl3514.factory_method.Document;
import ba.yzl3514.factory_method.WordDocument;

/**
 *
 * factory_method paketi altındaki Driver sınıfı ile kıyaslayınız
 *
 * @author Onder Sahin
 *
 */
public class Driver {

    public static void main(String[] args) {
        Document document = GenericDocumentFactory.createDocument(WordDocument.class);
        document.open();
        document.close();

    }
}
