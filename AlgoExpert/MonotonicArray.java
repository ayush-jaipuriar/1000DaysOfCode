class Program {
  // Method to check if an array is monotonic
  // Time Complexity: O(n) where n is the length of the array
  // Space Complexity: O(1)
  public static boolean isMonotonic(int[] array) {
      boolean isNonIncreasing = true;
      boolean isNonDecreasing = true;

      // Iterate through the array starting from the second element
      for (int i = 1; i < array.length; i++) {
          // Check if the current element is less than the previous one
          // If so, it indicates a non-increasing sequence
          if (array[i] < array[i - 1]) {
              // Mark the array as not non-decreasing
              isNonDecreasing = false;
          } 
          // Check if the current element is greater than the previous one
          // If so, it indicates a non-decreasing sequence
          else if (array[i] > array[i - 1]) {
              // Mark the array as not non-increasing
              isNonIncreasing = false;
          }
      }

      // Return true if the array is either non-increasing or non-decreasing
      return isNonIncreasing || isNonDecreasing;
  }
}