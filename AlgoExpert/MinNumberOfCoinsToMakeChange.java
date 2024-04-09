import java.util.*;

class Program {
  // Time Complexity : O(nd) time ; n is the target amount and d is the number of coin denominations
  // Space Complexity : O(n) space
  public static int minNumberOfCoinsForChange(int n, int[] denoms) {
    int[] ways = new int[n+1];
    Arrays.fill(ways, Integer.MAX_VALUE);
    ways[0] = 0;
    int toCompare = 0;
    for (int denom : denoms) {
      for (int amount = 0; amount <= n; amount++) {
        if (denom <= amount) {
          if (ways[amount-denom] == Integer.MAX_VALUE) {
            toCompare = ways[amount-denom];
          } else {
            toCompare = 1 + ways[amount - denom];
          }
          ways[amount] = Math.min(ways[amount], toCompare);
        }
      }
    }

    return ways[n] != Integer.MAX_VALUE ? ways[n] : -1;
  }
}
