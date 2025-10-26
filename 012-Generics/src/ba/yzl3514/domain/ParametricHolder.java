package ba.yzl3514.domain;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class ParametricHolder<T> {
    private T data;
    //private T[] items;

    public void setData(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }
}
