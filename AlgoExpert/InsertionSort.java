import java.util.Arrays;

public class InsertionSort {
	
	// Time Complexity : O(n^2)
	// Space Complexity : O(1)

	public static int[] performInsertionSort(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = i; j > 0; j--) {
				if (arr[j] < arr[j - 1]) {
					int temp = arr[j];
					arr[j] = arr[j - 1];
					arr[j - 1] = temp;
				}
			}
		}
		return arr;
	}

	public static void main(String[] args) {
		int[] unsortedArray = { 3, 2, 1,-23,0, 52 };
		int[] sortedArray = performInsertionSort(unsortedArray);
		System.out.println(Arrays.toString(unsortedArray));
	}

}
