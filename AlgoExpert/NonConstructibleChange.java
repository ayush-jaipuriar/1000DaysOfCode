import java.util.*;

class Program {
    // Time Complexity : O(n)
    // Space Complexity : O(1); n is the number of coins
    public int nonConstructibleChange(int[] coins) {
        int currentChange = 0;
        Arrays.sort(coins);

        for (int coin : coins) {
            // Case 1 : If coin > currentChange + 1, it means we cannot create the
            // currentChange+1 amount
            if (coin > currentChange + 1) {
                return currentChange + 1;
            }
            currentChange += coin;
        }

        return currentChange + 1;
    }
}
