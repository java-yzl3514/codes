package ba.yzl3514.data;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class AbstractEntity<T> implements GenericEntity<T> {
    private T id;

    @Override
    public T getId() {
        return id;
    }

    public void setId(T id) {
        this.id = id;
    }
}
