package ba.yzl3514.bound;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class Box<T> {
    private T item;

    /*
    ERROR !
       T'nin Object olduğu varsayılır
       'Object' sınıfında doSomething() yoktur.
    public void foo(){
        item.doSomething();

    }
     */


    public void foo(){
        // item.toString(); // OK
    }
}
