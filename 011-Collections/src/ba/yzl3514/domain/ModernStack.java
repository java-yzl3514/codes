package ba.yzl3514.domain;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class ModernStack<T> {

    private Deque<T> storage = new ArrayDeque<>();

    public void push(T item) {
        storage.push(item);
    }

    public T peek() {
        return storage.peek();
    }

    public T pop() {
        return storage.pop();
    }

    public boolean isEmpty(){
        return storage.isEmpty();
    }

    @Override
    public String toString() {
        return storage.toString();
    }
}
