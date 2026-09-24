import java.util.Iterator;

public class LinkedPositionalList<E> implements Iterable<E> {
    // --- Nested Node Class (implements Position) ---
    private static class Node<E> implements Position<E> {
        private E element;
        private Node<E> prev;
        private Node<E> next;

        public Node(E e, Node<E> p, Node<E> n) {
            element = e;
            prev = p;
            next = n;
        }

        // Getters and Setters
        @Override
        public E getElement() {return element;}
        public Node<E> getPrev() {return prev;}
        public Node<E> getNext() {return next;}
        public void setElement(E e) {element = e;}
        public void setPrev(Node<E> p) {prev = p;}
        public void setNext(Node<E> n) {next = n;}
    }

    private Node<E> header;
    private Node<E> trailer;
    private int size = 0;

    // Constructor
    public LinkedPositionalList() {
        header = new Node<>(null, null, null);
        trailer = new Node<>(null, header, null);
        header.setNext(trailer); // header connects with trailer
    }

    // --- Private useful methods ---
    private Node<E> validate(Position<E> p) { // Converting Position to Node
        Node<E> node = (Node<E>) p;
        return node;
    }

    private Position<E> position(Node<E> node) { // Getting position by node
        if (node == header || node == trailer) {
            return null; // Do not expose user to sentinels
        }
        return node;
    }

    // Getting Position methods
    public Position<E> first() {return position(header.getNext());}
    public Position<E> last() {return position(trailer.getPrev());}

    public Position<E> before(Position<E> p) {
        Node<E> node = validate(p);
        return position(node.getPrev());
    }

    public Position<E> after(Position<E> p) {
        Node<E> node = validate(p);
        return position(node.getNext());
    }

    // Useful method for adding nodes into list
    private Position<E> addBetween(E e, Node<E> prev, Node<E> next) {
        Node<E> newest = new Node<>(e, prev, next);
        prev.setNext(newest);
        next.setPrev(newest);
        size++;
        return newest;
    }

    // Setting Position methods
    public Position<E> addFirst(E e) {return addBetween(e, header, header.getNext());}
    public Position<E> addLast(E e) {return addBetween(e, trailer.getPrev(), trailer);}

    public Position<E> addBefore(Position<E> p, E e) {
        Node<E> node = validate(p);
        return addBetween(e, node.getPrev(), node);
    }

    public Position<E> addAfter(Position<E> p, E e) {
        Node<E> node = validate(p);
        return addBetween(e, node, node.getNext());
    }

    public E set(Position<E> p, E e) {
        Node<E> node = validate(p);
        E answer = node.getElement(); // Get old element
        node.setElement(e);
        return answer;
    }

    public E remove(Position<E> p)  {
        // Get p's nodes
        Node<E> node = validate(p);
        Node<E> predecessor = node.getPrev();
        Node<E> successor = node.getNext();
        predecessor.setNext(successor);
        successor.setPrev(predecessor);
        size--;
        E answer = node.getElement();
        // Garbage collection
        node.setElement(null);
        node.setNext(null);
        node.setPrev(null);
        return answer;
    }

    // --- Nested Iterator Class ---
    private class ElementIterator implements Iterator<E> {
        Position<E> cursor = first();

        @Override
        public boolean hasNext() {
            return cursor != null;
        }

        @Override
        public E next() {
            E currentElement = cursor.getElement(); // Get current element
            cursor = after(cursor); // Set cursor to the next position
            return currentElement;
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new ElementIterator();
    }
}
