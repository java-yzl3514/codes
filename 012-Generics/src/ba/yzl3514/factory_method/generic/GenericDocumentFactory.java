package ba.yzl3514.factory_method.generic;

import java.lang.reflect.InvocationTargetException;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public interface GenericDocumentFactory {

    /*
        factoryMethod
     */
    static <T> T createDocument(Class<T> type){
        try {
            return type.getDeclaredConstructor().newInstance();
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

}
