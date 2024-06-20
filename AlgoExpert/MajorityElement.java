import java.util.*;

class Program {
    // Time Complexity : O(n)
    // Space Complexity : O(1); n is the length of the array
    public int majorityElement(int[] array) {
        // Initialize count to 0 and answer to any element of the array
        int count = 0;
        int answer = 0;

        // Iterate through each element in the array
        for (int i = 0; i < array.length; i++) {
            // If count is 0, set the current element as the potential answer
            if (count == 0) {
                answer = array[i];
            }

            // Increment count if the current element matches the answer,
            // otherwise decrement it
            count = (array[i] == answer)? count + 1 : count - 1;
        }

        // Return the final answer after iterating through the entire array
        return answer;
    }
}