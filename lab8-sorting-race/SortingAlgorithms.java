import java.util.Arrays;

public class SortingAlgorithms {
    /**
     * Implements the Selection Sort algorithm.
     * Theoretical Complexity: O(n^2)
     */
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            // Find the index of the smallest element in the unsorted array
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            // Swap the found minimum element with the current element
            if (minIndex != i) {
                int temp = arr[minIndex];
                arr[minIndex] = arr[i];
                arr[i] = temp;
            }
        }
    }

    /**
     * Implements the Insertion Sort algorithm.
     * Theoretical Complexity: O(n^2) / Best-Case: O(n)
     */
    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; ++i) {
            int key = arr[i];
            int j = i - 1;

            // Check if the previous element is greater than the current element
            // If so, then move the element to the back
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key; // replaced the next element with the current element
        }
    }

    /**
     * Implements the Merge Sort algorithm. Public-facing method.
     * Theoretical Complexity: O(n log n)
     */
    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return; // Already sorted
        }
        int[] temp = new int[arr.length];
        mergeSortRecursive(arr, temp, 0, arr.length - 1);
    }

    private static void mergeSortRecursive(int[] arr, int[] temp, int left, int right) {
        if (left < right) {
            // Find the midpoint to split the array
            int mid = left + (right - left) / 2;

            // Sort the left and right halves
            mergeSortRecursive(arr, temp, left, mid);
            mergeSortRecursive(arr, temp, mid + 1, right);

            // Merge the sorted halves back together
            merge(arr, temp, left, mid, right);
        }
    }

    private static void merge(int[] arr, int[] temp, int left, int mid, int right) {
        // Copy the current array into the temp array
        for (int i = left; i <= right; i++) {
            temp[i] = arr[i];
        }

        int i = left;      // Starting index for the left subarray
        int j = mid + 1;   // Starting index for the right subarray
        int k = left;      // Starting index for the merged original array

        // Compare elements from both halves and copy the smaller one back
        while (i <= mid && j <= right) {
            if (temp[i] <= temp[j]) { // If the left side is less than the right side
                arr[k] = temp[i];
                i++;
            } else {                 // If the less side is greater than the right side
                arr[k] = temp[j];
                j++;
            }
            k++; // Move to the next index of the merged original array
        }

        // Copy any remaining elements from the left subarray
        while (i <= mid) {
            arr[k] = temp[i];
            k++;
            i++;
        }
    }
}
