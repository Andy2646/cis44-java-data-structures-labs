import java.util.Random;

public class DotProduct {
    public static void main(String[] args) {
        int n = 5;

        int[] a = new int[n];
        int[] b = new int[n];
        int[] c = new int[n];

        for (int i = 0; i < a.length; i++) {
            Random rand = new Random();
            a[i] = rand.nextInt(-10,10);
        }

        for (int i = 0; i < b.length; i++) {
            Random rand = new Random();
            b[i] = rand.nextInt(-10,10);
        }

        System.out.println("a\tb\tc");

        for (int i = 0; i < c.length; i++) {
            c[i] = a[i] * b[i];
            System.out.printf("%d\t%d\t%d%n", a[i], b[i], c[i]);
        }
    }
}
