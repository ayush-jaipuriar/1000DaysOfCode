import java.util.Arrays;

public class BubbleSort {
	
	// Time Complexity : O(n^2) 
	// Space Complexity : O(1)

	public static int[] bubbleSort(int[] array) {
		int n = array.length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n - i - 1; j++) {
				if (array[j] > array[j + 1]) {
					int temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
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
