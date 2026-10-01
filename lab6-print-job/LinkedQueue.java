public class LinkedQueue<E> implements Queue<E> {
    //---------- Nested Node Class ----------
    private static class Node<E> {
        private E element;
        private Node<E> next;

        public Node(E e, Node<E> n) {
            element = e;
            next = n;
        }

        public E getElement() { return element; }
        public Node<E> getNext() { return next; }
    }

    // Instance variables for the LinkedQueue
    private Node<E> head = null; // Head node, points to the front of the queue
    private Node<E> tail = null; // Tail node, points to the rear of the queue
    private int size = 0;        // The number of elements in the queue

    public LinkedQueue() { }

    public int size() {
        return size;
    }
    public boolean isEmpty() {
        return size == 0;
    }

    public void enqueue(E e) {
        Node<E> newest = new Node<>(e, null); // Create a new node
        if (isEmpty()) {
            head = newest; // If the queue is empty, the new node is both head and tail
        } else {
            tail.next = newest; // Otherwise, the old tail points to the new node
        }
        tail = newest; // The new node becomes the new tail
        size++;
    }

    public E first() {
        if (isEmpty()) {
            return null;
        }
        return head.getElement();
    }

    public E dequeue() {
        if (isEmpty()) {
            return null;
        }
        E answer = head.getElement(); // Get the element from the head
        head = head.getNext();       // Move the head pointer to the next node
        size--;
        if (isEmpty()) {
            tail = null; // Special case: if the queue is now empty, the tail must also be null
        }
        return answer;
    }
}
