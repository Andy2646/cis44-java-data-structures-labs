class Bear extends Animal {
    public Bear() {
        super(false);
    }

    public Bear(boolean moved) {
        super(moved);
    }

    @Override
    public String toString() {
        return "B";
    }
}
