import java.util.Arrays;
import java.util.Random;

public class SortingTester {
    public static void main(String[] args) {
        int[] sizes = {1000, 5000, 10000, 25000, 50000, 100000};

        System.out.println("--- The Sorting Race ---");

        for (int n : sizes) {
            System.out.println("\n--- Testing for array size n = " + n + " ---");

            System.out.println("Average Case:");
            runAndTimAllSorts(generateRandomArray(n));
            System.out.println("Best Case:");
            runAndTimAllSorts(generateSortedArray(n));
            System.out.println("Worse Case:");
            runAndTimAllSorts(generateReverseSortedArray(n));
        }
    }

    public static void runAndTimAllSorts(int[] arr) {
        long ssStartTime = System.nanoTime();
        SortingAlgorithms.selectionSort(arr);
        long ssEndTime = System.nanoTime();

        System.out.println("Selection Sort: " + (ssEndTime - ssStartTime));

        long isStartTime = System.nanoTime();
        SortingAlgorithms.insertionSort(arr);
        long isEndTime = System.nanoTime();

        System.out.println("Insertion Sort: " + (isEndTime - isStartTime));

        long msStartTime = System.nanoTime();
        SortingAlgorithms.mergeSort(arr);
        long msEndTime = System.nanoTime();

        System.out.println("Merge Sort: " + (msEndTime - msStartTime));
    }

    public static int[] generateRandomArray(int size) {
        // Create an array filled with streamed random integers
        int[] array = new Random().ints(size,0,size).toArray();

        return array;
    }

    public static int[] generateSortedArray(int size) {
        int[] array = new int[size];

        for (int i = 0; i < size; i++) {
            array[i] = i;
        }

        return array;
    }

    public static int[] generateReverseSortedArray(int size) {
        int[] array = new int[size];

        for (int i = 0; i < size; i++) {
            array[i] = size - i;
        }

        return array;
    }
}
