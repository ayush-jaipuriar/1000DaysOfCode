import java.util.Arrays;

public class FindThreeLargestNumbers {
	
	// Time Complexity : O(n) since we are traversing the array only once, sorting solution would be worse as it would be min O(n log n)
	// Space Complexity : O(1) since we are doing in place operations
	
	public static int[] findThreeLargestNumbers(int[] array) {
		int[] arr = {Integer.MIN_VALUE, Integer.MIN_VALUE,Integer.MIN_VALUE};
		for (int num : array) {
			calculateThreeLargest(arr, num);
		}
		return arr;	
	}
	
	public static void calculateThreeLargest(int[] arr, int num) {
		if (num >= arr[2]) {
			performRightShift(arr, num, 2);
		} else if (num >= arr[1]) {
			performRightShift(arr, num, 1);
		} else if (num >= arr[0]) {
			performRightShift(arr, num, 0);
		}		
	}
	
	public static void performRightShift(int[] arr, int num, int index) {
		for (int i=0; i<=index; i++) {
			if (i == index) {
				arr[i] = num;
			} else {
				arr[i] = arr[i+1];
			}
		}
	}
	
	public static void main(String[] args) {
		int[] testArray = {55, 43, 11, 3, -3, 10};
		int[] outputArray = findThreeLargestNumbers(testArray);
		System.out.println(Arrays.toString(outputArray));
	}
}
