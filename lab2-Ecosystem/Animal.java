abstract class Animal {
    private boolean moved;

    public Animal() {
        this(false);
    }

    public Animal(boolean moved) {
        this.moved = moved;
    }

    public boolean isMoved() {
        return moved;
    }

    public abstract String toString();
}
