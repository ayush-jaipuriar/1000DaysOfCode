import java.util.*;

class Program {
    /**
     * Calculates the number of ways to make change for a given amount using a set of denominations.
     *
     * @param n The target amount for which we want to find the number of ways to make change.
     * @param denoms An array of denominations available to make change.
     * @return The number of distinct ways to make change for the amount {@code n} using the provided denominations.
     */
    public static int numberOfWaysToMakeChange(int n, int[] denoms) {
        // Initialize an array to keep track of the number of ways to make change for each amount up to n.
        int[] numOfWays = new int[n + 1];
        // Fill the array with zeros, except for the first index which represents the base case (amount 0).
        Arrays.fill(numOfWays, 0);
        numOfWays[0] = 1;

        // Iterate through each denomination.
        for (int denom : denoms) {
            // For each denomination, iterate through all amounts from 1 to n.
            for (int amount = 1; amount <= n; amount++) {
                // If the current denomination is less than or equal to the current amount,
                // add the number of ways to make change for the amount minus the denomination to the current amount's total.
                if (denom <= amount) {
                    numOfWays[amount] += numOfWays[amount - denom];
                }
            }
        }
        // Return the total number of ways to make change for the target amount n.
        return numOfWays[n];
    }
}