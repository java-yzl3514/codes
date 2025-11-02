package ba.yzl3514.generic_methods;

/**
 *
 * @author Onder Sahin
 *
 */
public class GenericMethods<T> {

    public void foo(T... t){
        // T[] t
        // new T[]
        // T[] arr = (T[])new Object[34];
        System.out.println(t.getClass().getName());

        Object[] obj = t;
        obj[0] = "100";


        for(int i = 0; i < t.length; i++){
            System.out.println(obj[i]);
        }
    }
}
