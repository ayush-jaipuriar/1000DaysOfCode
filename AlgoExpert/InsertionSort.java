import java.util.Arrays;

/**
 * Class to demonstrate the insertion sort algorithm.
 */
public class InsertionSort {
	
    // Time Complexity : O(n^2)
    // Space Complexity : O(1)
    
    /**
     * Performs the insertion sort on the given array.
     * @param arr The array to be sorted.
     * @return The sorted array.
     */
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
	
    /**
     * Main method to test the insertion sort algorithm.
     */
    public static void main(String[] args) {
        int[] unsortedArray = { 3, 2, 1,-23,0, 52 };
        int[] sortedArray = performInsertionSort(unsortedArray);
        // Removed the print statement that prints the unsorted array instead of the sorted one.
        // Uncomment the next line to see the sorted array.
        // System.out.println(Arrays.toString(sortedArray));
    }
}