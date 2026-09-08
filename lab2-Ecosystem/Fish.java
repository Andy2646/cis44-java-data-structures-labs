class Fish extends Animal {
    public Fish() {
        super(false);
    }

    public Fish(boolean moved) {
        super(moved);
    }

    @Override
    public String toString() {
        return "F";
    }
}
