import java.util.EmptyStackException;

public class ArrayStack<E> implements Stack<E> {
    private Object[] data;
    private int t = -1; // Index of the top element
    private static final int DEFAULT_CAPACITY = 100;

    public ArrayStack() {
        this(DEFAULT_CAPACITY); // Constructs stack with default capacity
    }

    public ArrayStack(int capacity) {
        data = new Object[capacity]; // Constructs stack with given capacity
    }

    @Override
    public int size() {
        return (t + 1);
    }

    @Override
    public boolean isEmpty() {
        return (t == -1);
    }

    @Override
    public void push(E element) throws IllegalStateException {
        if (size() == data.length) {
            throw new IllegalStateException("Stack is full");
        }
        t++;
        data[t] = element;
    }

    @Override
    @SuppressWarnings("unchecked")
    public E top() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        // Cast the element back to E only when it's retrieved.
        return (E) data[t];
    }

    @Override
    @SuppressWarnings("unchecked")
    public E pop() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        // Cast the element back to E here as well.
        E answer = (E) data[t];
        data[t] = null; // Help garbage collection
        t--;
        return answer;
    }
}
