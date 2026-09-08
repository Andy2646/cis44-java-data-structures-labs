import java.util.ArrayList;
import java.util.Scanner;

public class PolygonCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Polygon polygon;
        ArrayList<Double> sideLengths = new ArrayList<>();
        int sides = 0;

        String chosenPolygon = "";
        int response = 0;

        while (response > 9 || response < 1) {
            System.out.println("1 - Triangle");
            System.out.println("2 - Isosceles Triangle");
            System.out.println("3 - Equilateral Triangle");
            System.out.println("4 - Quadrilateral");
            System.out.println("5 - Rectangle");
            System.out.println("6 - Sqaure");
            System.out.println("7 - Pentagon");
            System.out.println("8 - Hexagon");
            System.out.println("9 - Octagon");
            System.out.print("Choose a polygon: ");

            response = Integer.parseInt(scanner.next());

            switch(response) {
                case 1 -> chosenPolygon = "Triangle";
                case 2 -> chosenPolygon = "IsoscelesTriangle";
                case 3 -> chosenPolygon = "EquilateralTriangle";
                case 4 -> chosenPolygon = "Quadrilateral";
                case 5 -> chosenPolygon = "Rectangle";
                case 6 -> chosenPolygon = "Square";
                case 7 -> chosenPolygon = "Pentagon";
                case 8 -> chosenPolygon = "Hexagon";
                case 9 -> chosenPolygon = "Octagon";
                default -> System.out.println("Invalid Option");
            }
        }

        switch (chosenPolygon) {
            case "Triangle"  -> sides = 3;
            case "IsoscelesTriangle", "Rectangle" -> sides = 2;
            case "EquilateralTriangle", "Square", "Pentagon", "Hexagon", "Octagon" -> sides = 1;
            case "Quadrilateral" -> sides = 4;
        }

        System.out.println("\n" + chosenPolygon + " chosen!");
        for (int i = 1; i <= sides; i++) {
            if (sides == 1)
                System.out.print("Enter their side Lengths: ");
            else
                System.out.printf("Enter Side Length %d: ", i);
            Double sideLength = Double.parseDouble(scanner.next());

            sideLengths.add(sideLength);
        }

        System.out.println("\n" + chosenPolygon + ":");
        switch (chosenPolygon) {
            case "Triangle" -> {
                polygon = new Triangle(sideLengths.get(0), sideLengths.get(1), sideLengths.get(2));
                checkPolygon(polygon);
            }
            case "IsoscelesTriangle" -> {
                polygon = new IsoscelesTriangle(sideLengths.get(0), sideLengths.get(1));
                checkPolygon(polygon);
            }
            case "EquilateralTriangle" -> {
                polygon = new EquilateralTriangle(sideLengths.getFirst());
                checkPolygon(polygon);
            }
            case "Quadrilateral" -> {
                polygon = new Quadrilateral(sideLengths.get(0),sideLengths.get(1),sideLengths.get(2),sideLengths.get(3));
                checkPolygon(polygon);
            }
            case "Rectangle" -> {
                polygon = new Rectangle(sideLengths.get(0), sideLengths.get(1));
                checkPolygon(polygon);
            }
            case "Square" -> {
                polygon = new Square(sideLengths.getFirst());
                checkPolygon(polygon);
            }
            case "Pentagon" -> {
                polygon = new Pentagon(sideLengths.getFirst());
                checkPolygon(polygon);
            }
            case "Hexagon" -> {
                polygon = new Hexagon(sideLengths.getFirst());
                checkPolygon(polygon);
            }
            case "Octagon" -> {
                polygon = new Octagon(sideLengths.getFirst());
                checkPolygon(polygon);
            }
        }

        scanner.close();
    }

    public static void checkPolygon(Polygon polygon) {
        if (polygon instanceof Triangle specificShape) {
            System.out.println("Area: " + specificShape.area());
            System.out.println("Perimeter: " + specificShape.perimeter());
        }
        else if (polygon instanceof Quadrilateral specificShape) {
            System.out.println("Area: " + specificShape.area());
            System.out.println("Perimeter: " + specificShape.perimeter());
        }
        else if (polygon instanceof Pentagon specificShape) {
            System.out.println("Area: " + specificShape.area());
            System.out.println("Perimeter: " + specificShape.perimeter());
        }
        else if (polygon instanceof Hexagon specificShape) {
            System.out.println("Area: " + specificShape.area());
            System.out.println("Perimeter: " + specificShape.perimeter());
        }
        else if (polygon instanceof Octagon specificShape) {
            System.out.println("Area: " + specificShape.area());
            System.out.println("Perimeter: " + specificShape.perimeter());
        }
    }
}
