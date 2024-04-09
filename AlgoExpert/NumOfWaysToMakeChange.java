import java.util.*;

class Program {
    public static int numberOfWaysToMakeChange(int n, int[] denoms) {
        int[] numOfWays = new int[n + 1];
        Arrays.fill(numOfWays, 0);
        numOfWays[0] = 1;

        for (int denom : denoms) {
            for (int amount = 1; amount <= n; amount++) {
                if (denom <= amount) {
                    numOfWays[amount] += numOfWays[amount - denom];
                }
            }
        }
        return numOfWays[n];
    }
}
