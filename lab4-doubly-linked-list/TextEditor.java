public class TextEditor {
    private static class Node {
        String textState;
        Node next;
        Node prev;

        public Node (String text, Node n, Node p) {
            textState = text;
            next = n;
            prev = p;
        }

        public String getText() {return textState;}
        public Node getNext() {return next;}
        public Node getPrev() {return prev;}
        public void setNext(Node n) {next = n;}
    }

    private Node currentNode;

    public TextEditor() {
        this.currentNode = new Node("", null, null);
    }

    public void add(String newText) {
        Node newNode = new Node(newText, null, currentNode);
        currentNode.setNext(newNode);
        currentNode = newNode;
    }

    public String undo() {
        if (currentNode.getPrev() != null) {
            currentNode = currentNode.getPrev();
            return currentNode.getText();
        }
        else {
            System.out.println("Cannot undo");
            return null;
        }
    }

    public String redo() {
        if (currentNode.getNext() != null) {
            currentNode = currentNode.getNext();
            return currentNode.getText();
        }
        else {
            System.out.println("Cannot redo");
            return null;
        }
    }

    public void printCurrent() {
        System.out.println(currentNode.getText());
    }
}
