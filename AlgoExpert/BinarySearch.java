
public class BinarySearch {
	public static int binarySearch(int[] array, int target) {
		// Time Complexity : O(n log n)
		// Space Complexity : O(1)
		int n = array.length;
		int start = 0;
		int end = n - 1;
		int mid = -1;
		int result = -1;
		while (start <= end) {
			mid = (start + end) / 2;
			if (target == array[mid]) {
				result = mid;
				break;
			}
			if (target < array[mid]) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return result;
	}

}
