// Importing java.util package is not necessary as no classes from it are used in this code.
// Consider removing the import statement to clean up the code.

// This class contains the solution for finding the first duplicate value in an array.
class Program {
    // Function to find the first duplicate value in the given array.
    // Time complexity: O(n) because we iterate through the array once.
    // Space complexity: O(1) because we use a constant amount of space to store the result and temporary variables.
    public int firstDuplicateValue(int[] array) {
        // Initialize result to -1, indicating no duplicate found yet.
        int result = -1;
        // Iterate through each element in the array.
        for (int i = 0; i < array.length; i++) {
            // Get the absolute value of the current element.
            // This is done to ensure that negative indices are treated as positive.
            int num = Math.abs(array[i]);

            // Check if the value at the index (num - 1) is negative.
            // If it is, it means we've encountered this number before (as its index was marked negative).
            if (array[num - 1] < 0) {
                // Return the current number as the first duplicate.
                return num;
            } else {
                // If the value at the index (num - 1) is not negative, mark it as negative.
                // This is done to indicate that we've encountered this number before.
                array[num - 1] = array[num - 1] * -1;
            }
        }
        // If no duplicate is found, return -1.
        return result;
    }
}