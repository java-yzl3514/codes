package ba.yzl3514.domain;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class PreJava6Stack<T> {

    private Deque<T> storage = new LinkedList<>();

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
