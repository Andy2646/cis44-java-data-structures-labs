public class Main {
    public static void main(String[] args) {
        // Create matrices
        int[][] array = new int[2][3];

        Matrix m1 = new Matrix(2,3);
        Matrix m2 = new Matrix(array);
        Matrix m3 = new Matrix(3,4);
        Matrix m4 = new Matrix(5,5);

        // Fill up matrices
        m1.populateRandom();
        m2.populateRandom();
        m3.populateRandom();
        m4.populateRandom();

        System.out.println("Creating 4 matrices:");
        System.out.println("Matrix 1:");
        System.out.println(m1.toString());
        System.out.println("Matrix 2:");
        System.out.println(m2.toString());
        System.out.println("Matrix 3:");
        System.out.println(m3.toString());
        System.out.println("Matrix 4:");
        System.out.println(m4.toString());

        // Add matrices
        try {
            System.out.println("Adding matrices 1 and 2:");
            System.out.println(m1.add(m2).toString());

            System.out.println("Adding matrices 1 and 3:");
            System.out.println(m1.add(m3).toString());
        }
        catch (IllegalArgumentException e) {
            System.out.println(e);
        }

        // Multiply matrices
        try {
            System.out.println("Adding matrices 2 and 3:");
            System.out.println(m2.multiply(m3).toString());

            System.out.println("Adding matrices 3 and 4:");
            System.out.println(m3.multiply(m4).toString());
        }
        catch (IllegalArgumentException e) {
            System.out.println(e);
        }
    }
}
