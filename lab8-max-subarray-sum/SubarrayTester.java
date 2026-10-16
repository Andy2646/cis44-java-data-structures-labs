import java.util.Random;

public class SubarrayTester {
    public static void main(String[] args) {
        int[] sizes = {1000, 5000, 10000, 50000, 100000};

        System.out.println("--- Maximum Subarray Sum Algorithm Comparison ---");

        for (int n : sizes) {
            System.out.println("\n--- Testing for array size n = " + n + " ---");

            // Both algorithms will test with the same array to ensure both sums are similar
            int[] randomArray = generateRandomArrayWithNegatives(n);

            long bfStartTime = System.nanoTime();
            int max1 = MaxSubarraySolver.bruteForceMaxSum(randomArray);
            long bfEndTime = System.nanoTime();
            System.out.println("Bruce Force: " + (bfEndTime - bfStartTime));
            System.out.println("Sum 1: " + max1);

            long kaStartTime = System.nanoTime();
            int max2 = MaxSubarraySolver.kadanesAlgorithmMaxSum(randomArray);
            long kaEndTime = System.nanoTime();
            System.out.println("Kadane's Algorithm: " + (kaEndTime - kaStartTime));
            System.out.println("Sum 2: " + max2);
        }
    }

    public static int[] generateRandomArrayWithNegatives(int size) {
        return new Random().ints(size, -11, 11).toArray();
    }
}
