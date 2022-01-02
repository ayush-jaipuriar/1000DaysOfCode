import java.util.*;

class Program {
  public static int[] twoNumberSum(int[] array, int targetSum) {
    // Write your code here.
		int n = array.length;
		int sum = 0;
		int left = 0;
		int right = n - 1;
    
    //Sorting the array so that we can apply binary search 
    
		Arrays.sort(array);
    
		//Using the two pointer approach of binary search 
    
		while (left < right) {
			sum = array[left] + array[right];
			if (sum == targetSum) {
				return new int[] {array[left], array[right]};
			} else if (sum < targetSum) {
				left++;
			} else {
				right--;
			}
		}
    return new int[0];
  }
}
