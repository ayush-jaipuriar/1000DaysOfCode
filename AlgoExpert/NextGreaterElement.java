import java.util.*;

class Program {
    // Time Complexity : O(2n) i.e O(n)
    // Space Complexity : O(n); n is the number of elements in the array
    public int[] nextGreaterElement(int[] array) {
        // Initialize a stack to keep track of elements for which we need to find the next greater element
        List<Integer> stack = new ArrayList<>();
        int n = array.length;
        // Initialize the result array with -1, indicating no next greater element for all elements initially
        int[] resultArray = new int[n];
        Arrays.fill(resultArray, -1);

        // Iterate through the array twice to handle circular nature of the array
        for (int i = 0; i < 2 * n; i++) {
            int circularIndex = i % n; // Calculate the index in the circular array

            // While the stack is not empty and the top element of the stack is less than the current element
            while (stack.size() > 0 && array[stack.get(stack.size() - 1)] < array[circularIndex]) {
                // Pop the element from the stack and update its result in the result array
                int top = stack.get(stack.size() - 1);
                stack.remove(stack.size() - 1);
                resultArray[top] = array[circularIndex];
            }

            // Push the current element index into the stack
            stack.add(circularIndex);
        }

        // Return the result array containing the next greater element for each element in the input array
        return resultArray;
    }
}