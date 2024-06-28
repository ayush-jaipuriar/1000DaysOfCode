import java.util.*;

class Program {
    // Time Complexity : O(N)
    // Space Complexity : O(N) ; N = length of nums
    public boolean zeroSumSubarray(int[] nums) {
        // Initialize a HashSet to keep track of sums we've seen so far
        Set<Integer> set = new HashSet<>();
        set.add(0); // Add 0 because a sum of 0 is always possible

        int currentSum = 0;

        // Iterate through each element in the array
        for (int i = 0; i < nums.length; i++) {
            currentSum += nums[i];

            // Check if the current sum has been seen before
            // If yes, it means there exists a subarray with sum 0
            if (set.contains(currentSum)) {
                return true;
            } else {
                // If not, add the current sum to our set
                set.add(currentSum);
            }
        }

        // If no such subarray is found, return false
        return false;
    }
}