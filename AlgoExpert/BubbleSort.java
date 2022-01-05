import java.util.Arrays;

public class BubbleSort {
	
	// Time Complexity : O(n^2) , O(n) if array is already sorted thanks to optimization
	// Space Complexity : O(1)

	public static int[] bubbleSort(int[] array) {
		int n = array.length;
		boolean performedSort = false;
		for (int i = 0; i < n; i++) {
			performedSort = false;
			for (int j = 0; j < n - i - 1; j++) {
				if (array[j] > array[j + 1]) {
					int temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
					performedSort = true;
				}
			}
			// No need to perform swaps if no two elements got swapped i.e array is already sorted
			if (!performedSort) {
				break;
			}
		}

		return array;
	}

	public static void main(String[] args) {
		int[] testArray = { 8, 5, 2, 9, 5, 6, 3 };
		int[] outputArray = bubbleSort(testArray);
		System.out.println(Arrays.toString(outputArray));
	}

}
