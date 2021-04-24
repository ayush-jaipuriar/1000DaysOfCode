import java.util.*;

class Program {
  public static int[] twoNumberSum(int[] array, int targetSum) {
    // Write your code here.
		Set<Integer> hashSet = new HashSet<>();
		int x = 0;
		int y = 0;
		for (int i=0; i<array.length; i++) {
			x = array[i];
			y = targetSum - array[i];
			if (hashSet.contains(y)) {
				return new int[] {y, x};
			} else {
				hashSet.add(x);
			}
		}
    return new int[0];
  }
}
