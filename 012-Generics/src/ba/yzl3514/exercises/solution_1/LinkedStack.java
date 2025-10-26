package ba.yzl3514.exercises.solution_1;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class LinkedStack<T> {

    private final Node<T> END = new Node<T>(null, null);
    private Node<T> top = END;

    private static class Node<E> {
        E data;
        Node<E> next;

        public Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }
    }

    public void push(T item) {
        top = new Node<T>(item, top);
    }

    public T pop() {
        // The null ambiguity !!!
        if (isEmpty()) return null; // TODO throw exception NoSuchElementException
        T result = top.data;
        top = top.next;
        return result;
    }

    public boolean isEmpty() {
        return top == END;
    }

    @Override
    public String toString() {
        if (isEmpty())
            return "[]";
        StringBuilder builder = new StringBuilder("[");
        Node<T> node = top;
        while (true) {
            builder.append(node.data);
            if (node.next == END)
                return builder.append("]").toString();
            builder.append(", ");
            node = node.next;
        }
    }
}
