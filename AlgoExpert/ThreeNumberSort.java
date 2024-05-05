import java.util.*;

class Program {
    // Time Complexity : O(N)
    // Space Complexity : O(1); N is the size of the input array
    public int[] threeNumberSort(int[] array, int[] order) {
        // Using the divide the array into 3 seperate subarray approach
        int firstIndex = 0;
        int firstSortNum = order[0];
        int n = array.length;

        // Ensuring the 1st order number is in its correct position in the input array
        for (int i = 0; i < n; i++) {
            if (array[i] == firstSortNum) {
                swap(array, i, firstIndex);
                firstIndex++;
            }
        }

        int lastSortNum = order[2];
        int lastIndex = n - 1;
        // Ensuring the Nth order number is in its correct position in the input array
        for (int i = n - 1; i >= 0; i--) {
            if (array[i] == lastSortNum) {
                swap(array, i, lastIndex);
                lastIndex--;
            }
        }

        return array;
    }

    public void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
