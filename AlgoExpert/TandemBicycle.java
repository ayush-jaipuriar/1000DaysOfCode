import java.util.*;

public class TandemBicycle {

    // Time Complexity : O(n log n)
    // Space Complexity : O(1) where n is the number of tandem bicycles
    public int tandemBicycle(int[] redShirtSpeeds, int[] blueShirtSpeeds, boolean fastest) {
        // Sort both arrays to ensure we always take the faster speed between two riders
        Arrays.sort(redShirtSpeeds);
        Arrays.sort(blueShirtSpeeds);

        // If fastest is true, reverse sort the blue shirt speeds array
        // This ensures that the slower rider is always behind the faster one
        if (fastest) {
            blueShirtSpeeds = reverseSort(blueShirtSpeeds);
        }

        // Initialize sum to keep track of total speed
        int sum = 0;

        // Iterate through each pair of riders
        for (int i = 0; i < redShirtSpeeds.length; i++) {
            // Add the maximum speed between the two riders to the sum
            sum += Math.max(redShirtSpeeds[i], blueShirtSpeeds[i]);
        }
        return sum;
    }

    // Reverse sorts an integer array in place
    public static int[] reverseSort(int[] arr) {
        int n = arr.length;
        int start = 0;
        int end = n - 1;

        while (start < end) {
            // Swap elements at start and end indices
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            // Move towards the center of the array
            start++;
            end--;
        }
        return arr;
    }
}