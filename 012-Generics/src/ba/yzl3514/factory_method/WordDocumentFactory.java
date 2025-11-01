package ba.yzl3514.factory_method;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class WordDocumentFactory implements DocumentFactory{


    @Override
    public Document createDocument() {
        return new WordDocument();
    }
}
