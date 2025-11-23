package ba.yzl3514.domain;

import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 *
 * pushdown stack
 *
 * Operations:
 * - push()
 * - pop()
 * - peek()
 *
 * @author Onder Sahin
 *
 */
public class MyStack<T> implements IStack<T> {

    private static final int DEFAULT_CAPACITY = 10;
    private T[] data;
    private int size;


    public MyStack() {
        data = (T[]) new Object[DEFAULT_CAPACITY];
    }

    public void push(T item) {
        if (size == data.length) {
            grow();
        }
        data[size++] = item;
    }

    public T peek() {
        if (isEmpty()) throw new NoSuchElementException("Stack is empty");
        return data[size - 1];
    }

    public T pop() {
        if (isEmpty()) throw new NoSuchElementException("Stack is empty");
        T item = data[--size];
        //Loitering Object Risc !
        data[size] = null;
        return item;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    private void grow() {
        int newCapacity = data.length + data.length >> 1;
        data = Arrays.copyOf(data, newCapacity);
    }


    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            builder.append(data[i]);
            if(i < size - 1) builder.append(", ");
        }
        return builder.append("]").toString();

    }
}
