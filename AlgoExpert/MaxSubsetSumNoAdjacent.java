import java.util.*;

class Program {
    // Time Complexity : O(N)
    // Space Complexity : O(1)
    public static int maxSubsetSumNoAdjacent(int[] array) {
        // Base Case : Length of array is 0
        if (array.length == 0) {
            return 0;
        } else if (array.length == 1) {
            // Base Case : Length of array is 1, we just return back the 1st element of the
            // array
            return array[0];
        }

        // To calculate the mmaxSubsetSumNoAdjacent, we can use this particular formula
        // maxSum : Math.max(array[i-1], array[i-2] + array[i])
        // we can store these two values in an array itself, so we wont need to create
        // an entire array for keeping track of the maxSum

        // second represents array[0]
        int second = array[0];
        // first represents max of max(array[0], array[1])
        int first = Math.max(array[0], array[1]);

        // Now we iterate through the array from i=2 and apply the
        // maxSubsetSumNoAdjacent Formula
        for (int i = 2; i < array.length; i++) {
            int current = Math.max(first, second + array[i]);
            second = first;
            first = current;
        }

        return first;

    }
}
