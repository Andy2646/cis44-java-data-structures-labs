public class Octagon implements Polygon {
    protected double side;

    public Octagon(double side) {
        this.side = side;
    }

    @Override
    public double area() {
        return 2 * side * side * (1 + Math.sqrt(2));
    }

    @Override
    public double perimeter() {
        return 8 * side;
    }
}
