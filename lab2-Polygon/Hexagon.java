public class Hexagon implements Polygon {
    protected double side;

    public Hexagon(double side) {
        this.side = side;
    }

    @Override
    public double area() {
        return (3 * side * side * Math.sqrt(3))/2;
    }

    @Override
    public double perimeter() {
        return 6 * side;
    }
}
