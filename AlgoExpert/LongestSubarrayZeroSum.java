import java.util.HashMap;

/**
 * Finds the longest subarray with a zero sum in a given array.
 */
public class LongestSubarrayZeroSum {
    /**
     * Finds the length of the longest subarray with a zero sum.
     *
     * @param arr The input array.
     * @return The length of the longest subarray with a zero sum.
     */
    public static int findLongestSubarrayWithZeroSum(int[] arr) {
        // HashMap to store the cumulative sum as key and its index as value
        HashMap<Integer, Integer> sumIndexMap = new HashMap<>();
        int currentSum = 0; // Current cumulative sum
        int maxLength = 0; // Maximum length of the subarray with zero sum found so far

        // Iterate through each element in the array
        for (int i = 0; i < arr.length; i++) {
            // Update the current sum
            currentSum += arr[i];

            // If the current sum becomes zero, update the maximum length
            if (currentSum == 0) {
                maxLength = i + 1;
            }

            // Check if the current sum has appeared before
            Integer prevIndex = sumIndexMap.get(currentSum);
            if (prevIndex!= null) {
                // If yes, calculate the length of the subarray between the current and previous occurrence
                maxLength = Math.max(maxLength, i - prevIndex);
            } else {
                // Store the current sum and its index in the map
                sumIndexMap.put(currentSum, i);
            }
        }

        // Return the maximum length found
        return maxLength;
    }

    /**
     * Main method to test the findLongestSubarrayWithZeroSum function.
     */
    public static void main(String[] args) {
        // Input array
        int[] inputArray = { 15, -2, 2, -8, 1, 7, 10, 23 };
        // Find the length of the longest subarray with a zero sum
        int result = findLongestSubarrayWithZeroSum(inputArray);
        // Print the result
        System.out.println("Length of the longest subarray with zero sum: " + result);
    }
}