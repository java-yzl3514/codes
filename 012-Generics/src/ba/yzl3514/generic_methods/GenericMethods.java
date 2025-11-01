package ba.yzl3514.generic_methods;

/**
 *
 * @author Onder Sahin
 *
 */
public class GenericMethods {

    @SafeVarargs
    public final <T> void foo(T... t){
        // T[] t
        // new T[]
        // T[] arr = (T[])new Object[34];
        System.out.println(t.getClass().getName());
    }
}
