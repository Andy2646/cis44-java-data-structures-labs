public class MaxSubarraySolver {
    /**
     * Finds the maximum subarray sum using a brute-force approach.
     * Theoretical Complexity: O(n^2)
     */
    public static int bruteForceMaxSum(int[] arr) {
        int maxSum = arr[0]; // primitive count: 2

        // Outer loop picks the starting point of the subarray
        for (int i = 0; i < arr.length; i++) { // primitive count: 2
            int currentSum = 0; // primitive count: n

            // Inner loop sums the subarray all the way to the ending point
            for (int j = i; j < arr.length; j++) { // primitive count: 2n
                currentSum += arr[j]; // primitive count: 2n(n to 0) (this makes time complexity as O(n ^ 2))

                // Check if this sum is greater than the max sum
                maxSum = Math.max(maxSum, currentSum); // primitive count: 4n(n to 0)
            }
        }

        return maxSum; // primitive count: 1
    }

    /**
     * Finds the maximum subarray sum using Kadane's Algorithm.
     * Theoretical Complexity: O(n)
     */
    public static int kadanesAlgorithmMaxSum(int[] arr) {
        // Stores the result (maximum sum found so far)
        int result = arr[0]; // primitive count: 2

        // Maximum sum of subarray ending at current position
        int maxEnding = arr[0]; // primitive count: 2

        for (int i = 1; i < arr.length; i++) { // primitive count: 2
            // Either extend the previous subarray or start new subarray from current element
            maxEnding = Math.max(maxEnding + arr[i], arr[i]); // primitive count: 5n

            // Update result if the new subarray sum is larger
            result = Math.max(result, maxEnding); // primitive count: 4n (So far, this makes the time complexity O(n))
        }

        return result; // primitive count: 1
    }
}
