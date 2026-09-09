import java.util.Arrays;
import java.util.Random;

public class Matrix {
    private int[][] data;
    private final Random random = new Random();

    public Matrix(int rows, int cols) {
        this.data = new int[rows][cols];
    }

    // Initialize matrix with pre-existing array
    public Matrix(int[][] data) {
        this.data = data;
    }

    public void populateRandom() {
        for (int r = 0; r < data.length; r++) {
            for (int c = 0; c < data[0].length; c++) {
                data[r][c] = random.nextInt(11);
            }
        }
    }

    public Matrix add(Matrix other) throws IllegalArgumentException {
        if (data.length != other.data.length && data[0].length != other.data[0].length) {
            throw new IllegalArgumentException("Both matrices do not have the same dimensions");
        }

        Matrix sum = new Matrix(data.length, data[0].length);

        for (int r = 0; r < data.length; r++) {
            for (int c = 0; c < data[0].length; c++) {
                sum.data[r][c] = data[r][c] + other.data[r][c];
            }
        }

        return sum;
    }

    public Matrix multiply(Matrix other) throws IllegalArgumentException {
        if (data[0].length != other.data.length) {
            throw new IllegalArgumentException("The rows from this matrix does not match with columns from the other matrix");
        }

        Matrix product = new Matrix(data.length, other.data[0].length);

        for (int r = 0; r < data.length; r++) {
            for (int c = 0; c < other.data[0].length; c++) {
                for (int i = 0; i < data[0].length; i++) // Dot Product
                    product.data[r][c] += data[r][i] * other.data[i][c];
            }
        }

        return product;
    }

    @Override
    public String toString() {
        String str = "";

        for (int r = 0; r < data.length; r++) {
            for (int c = 0; c < data[0].length; c++) {
                if (c == 0)
                    str += String.format("|%2d", data[r][c]);
                else
                    str += String.format("%4d", data[r][c]);
            }
            str += "|\n";
        }

        return str;
    }
}
