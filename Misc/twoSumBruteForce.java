import java.util.*;

class Program {
  public static int[] twoNumberSum(int[] array, int targetSum) {
    // Write your code here.
		int[] list = new int[2];		
		int sum = 0;
		int n = array.length;
		for (int i=0; i<n-1; i++) {
			for (int j=i+1; j<n; j++) {
				sum = array[i] + array[j];
				if (sum == targetSum) {					
					return new int[] {array[i], array[j]};
				}
			}
		}
    return new int[0];
  }
}
