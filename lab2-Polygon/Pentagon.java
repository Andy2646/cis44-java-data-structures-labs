public class Pentagon implements Polygon {
    protected double side;

    public Pentagon(double side) {
        this.side = side;
    }

    @Override
    public double area() {
        return (side * side * Math.sqrt(25 + 10 * Math.sqrt(5))) / 4;
    }

    @Override
    public double perimeter() {
        return 5*side;
    }
}
