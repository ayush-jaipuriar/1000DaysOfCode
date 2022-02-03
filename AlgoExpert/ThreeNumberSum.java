import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeNumberSum {

	// This solution runs in O(n^2) timee and O(n) space where n is the length of
	// the array

	public static List<Integer[]> threeNumberSum(int[] array, int targetSum) {
		// First we sort the array in place in ascending order
		Arrays.sort(array);
		/*
		 * Now that we have sorted the array, we will loop till the array.length - 2
		 * index We will keep 3 pointers to the array i which will be the loop pointer
		 * start which will point to the next element to which i currently points at end
		 * which will always point to the last element of the array
		 * 
		 */
		List<Integer[]> resultList = new ArrayList<>();
		int i = 0;
		int start = 0;
		int end = array.length - 1;
		;
		int valueAti = 0;
		int valueAtStart = 0;
		int valueAtEnd = 0;
		int sum = 0;
		for (i = 0; i < array.length; i++) {
			start = i + 1;
			valueAti = array[i];
			while (start < end) {
				valueAtStart = array[start];
				valueAtEnd = array[end];
				sum = valueAti + valueAtStart + valueAtEnd;

				// There can be 3 cases now
				// Case 1: sum < target sum, in this case we will increment start pointer since
				// target sum is greater
				// Case 2: sum > target sum, in this case we will decrement end pointer since
				// target sum is smaller
				// Case 3: sum = target sum, in this case we will add arr{valueAti,
				// valueAtStart, and valueAtEnd} to result list

				if (sum < targetSum) {
					start++;
				} else if (sum > targetSum) {
					end--;
				} else {
					/*
					 * In the case of sum = targetSum we will increment start and decrement end
					 * because if we increment only sum will surely surpass target sum if we
					 * decrement only sum will surely fall behind target sum so to avoid these 2
					 * redundant steps, we increment and decrement the start and end at the same
					 * time
					 */
					resultList.add(new Integer[] { valueAti, valueAtStart, valueAtEnd });
					start++;
					end--;
				}
			}
		}
		return resultList;

	}

}
