public class DynamicArray<T> {
    private T[] data;
    private int size;
    private static final int INITIAL_CAPACITY = 5;

    public DynamicArray() {
        this.data = (T[]) new Object[INITIAL_CAPACITY];
        this.size = 0;
    }

    public void add(T element) {
        if (size >= data.length) { // If the array is full
            resize(2 * data.length);
        }
        data[size] = element;
        size++;
    }

    public T get(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }

        return data[index];
    }

    public T remove(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }

        T removedElement = data[index];

        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }

        data[size - 1] = null;
        size--;

        return removedElement;
    }

    public int size() {return size;}

    public void displayArray() {
        for (int i = 0; i < data.length; i++) {
            System.out.println(i + ": " + data[i]);
        }
    }

    private void resize(int capacity) {
        T[] temp = (T[]) new Object[capacity];

        for (int i = 0; i < size; i++) {
            temp[i] = data[i];
        }
        data = temp;
    }
}
