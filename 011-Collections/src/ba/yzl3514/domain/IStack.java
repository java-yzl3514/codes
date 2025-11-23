package ba.yzl3514.domain;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public interface IStack<T> {

     void push(T item);


    /**
     *
     * @throws java.util.NoSuchElementException
     * @return
     */
    T peek();

    /**
     * @throws java.util.NoSuchElementException
     * @return
     */
     T pop();

     boolean isEmpty();
}
