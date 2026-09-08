
public class Quadrilateral implements Polygon {
    // What attributes do all quadrilaterals have?
    // Four sides
    protected double side1;
    protected double side2;
    protected double side3;
    protected double side4;

    public Quadrilateral(double side1, double side2, double side3, double side4) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
        this.side4 = side4;
    }

    @Override
    public double area() {
        // Since it is impossible to calculate the exact area with only side lengths, we used Brahmagupta's formula
        // Assume quadrilaterals are cyclic.
        double s = perimeter()/2;
        return Math.sqrt((s-side1)*(s-side2)*(s-side3)*(s-side4));
    }

    @Override
    public double perimeter() {
        return side1 + side2 + side3 + side4;
    }
}
