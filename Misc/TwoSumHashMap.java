import java.util.*;

class Program {
  public static int[] twoNumberSum(int[] arr, int targetSum) {		
    // Write your code here.
		Map<Integer, Integer> hashMap = new HashMap<>();
		int x = 0;
		int y = 0;
		int n = arr.length;
		// Initializing the hash map with key being array element value and value being its index
		
		for (int i=0; i<n; i++) {
			if (!hashMap.containsKey(arr[i])) {
				hashMap.put(arr[i], i);
			}
		}
		
		//Now, using the equation X + Y = targetSum so Y = targetSum - X
		// So for every element X in the array, if Y exists in hashMap then its a match
		
		for (int i=0; i<n; i++) {
			x = arr[i];
			y = targetSum - x;
			if (hashMap.containsKey(y) && x!=y) {
				return new int[] {arr[hashMap.get(y)], arr[i]};
			}
		}
		
    return new int[0];
  }
}
