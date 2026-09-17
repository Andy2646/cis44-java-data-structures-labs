import java.util.Objects;

public class Playlist {
    private static class Node {
        private Song song;
        private Node next;

        public Node(Song s, Node n) {
            song = s;
            next = n;
        }

        public Song getSong() {return song;}
        public Node getNext() {return next;}
        public void setNext(Node n) {next = n;}
    }

    private Node head;
    private Node tail;
    private Node currentNode;
    private int size;

    public Playlist() {
        this.head = null;
        this.tail = null;
        this.currentNode = null;
        this.size = 0;
    }

    public boolean isEmpty() {return size == 0;}

    // Add song at the end of the playlist
    public void addSong(Song song) {
        Node newest = new Node(song, null);

        if (isEmpty()) {
            head = newest;
        }
        else {
            tail.setNext(newest);
        }
        tail = newest;
        System.out.printf("'%s' added to your music playlist%n", song.toString());
        size++;
    }

    // Removing a song based on the title and the artist
    public void removeSong(String title) {
        Node prevNode = head;
        Node cNode = head;

        // Starts from the head until one of the nodes' title matches our title (Inefficient :/)
        while (cNode != null) {
            if (Objects.equals(cNode.getSong().getTitle(), title)) {
                if (cNode == head) {
                    head = cNode.getNext();
                }
                else {
                    prevNode.setNext(cNode.getNext());
                }
                System.out.printf("'%s' removed from your music playlist%n", cNode.getSong().toString());
                size--;
                break;
            }
            prevNode = cNode;
            cNode = cNode.getNext();
        }

        if (cNode == null) {
            System.out.printf("'%s' is not on your music playlist%n", title);
        }

        // Check if the playlist is empty after a song is removed
        if (isEmpty()) {
            tail = null;
        }
    }

    public void playNext() {
        // Check if we have not played the playlist yet or we reached the end of the playlist
        if (currentNode == null || currentNode.next == null) {
            currentNode = head;
        }
        else {
            currentNode = currentNode.next;
        }

        System.out.printf("Now playing: '%s'%n", currentNode.getSong().toString());
    }

    public void displayPlaylist() {
        Node cNode = head;
        int index = 1;

        System.out.println("Your Music Playlist:");

        // Loop through all the songs in the playlist
        while (cNode != null) {
            System.out.printf("%d. %s%n", index, cNode.getSong().toString());
            cNode = cNode.getNext();
            index++;
        }
    }
}
