import java.util.*;

class Program {
    // Time Complexity : O(nd) time ; n is the target amount and d is the number of coin denominations
    // Space Complexity : O(n) space
    public static int minNumberOfCoinsForChange(int n, int[] denoms) {
        // Initialize an array to keep track of the minimum number of coins needed for each amount up to n
        int[] ways = new int[n+1];
        // Fill the array with Integer.MAX_VALUE initially, except for the first element which represents the base case (0 coins needed for amount 0)
        Arrays.fill(ways, Integer.MAX_VALUE);
        ways[0] = 0;

        // Iterate through each denomination
        for (int denom : denoms) {
            // For each denomination, iterate through all amounts up to n
            for (int amount = 0; amount <= n; amount++) {
                // If the current denomination is less than or equal to the current amount
                if (denom <= amount) {
                    // Check if we've found a better way to make change for the amount - denom
                    if (ways[amount-denom] == Integer.MAX_VALUE) {
                        // No previous solution found, so this is the first time we're considering this amount
                        continue; // Skip to the next iteration without updating ways[amount]
                    } else {
                        // We have a previous solution, compare it with the potential new solution
                        int toCompare = 1 + ways[amount - denom]; // Potential new solution
                        // Update ways[amount] only if the new solution is better
                        ways[amount] = Math.min(ways[amount], toCompare);
                    }
                }
            }
        }

        // After iterating through all denominations and amounts, check if there's a valid solution for making change
        // Return the minimum number of coins needed if a solution exists, otherwise return -1
        return ways[n]!= Integer.MAX_VALUE? ways[n] : -1;
    }
}