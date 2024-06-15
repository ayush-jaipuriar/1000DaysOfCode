// Time Complexity : O(n)
// Space Complexity : O(1); n is the number of seats in the array
public int bestSeat(int[] seats) {
  int bestSeat = -1; // Initialize bestSeat to -1, indicating no seat found yet
  int maxSpace = 0; // Initialize maxSpace to keep track of the maximum space found
  int currentSpace = 0; // Initialize currentSpace to calculate the space between two pointers
  int leftPointer = 0; // Initialize leftPointer to start scanning from the beginning of the array
  int n = seats.length; // Get the length of the seats array

  // Main loop to iterate through the seats array
  while (leftPointer < n) {
      int rightPointer = leftPointer + 1; // Initialize rightPointer one step ahead of leftPointer
      // Increment rightPointer as long as it encounters a 0 (empty seat)
      while (rightPointer < n && seats[rightPointer] == 0) {
          rightPointer++; // Move rightPointer forward until it finds a non-zero value
      }

      // Calculate the space between rightPointer and leftPointer
      currentSpace = rightPointer - leftPointer - 1; // Subtract 1 because we don't count the seat itself in the space

      // Check if the current space is greater than the maxSpace found so far
      if (currentSpace > maxSpace) {
          maxSpace = currentSpace; // Update maxSpace if currentSpace is larger
          bestSeat = (rightPointer + leftPointer)/2; // Calculate the middle index of the empty space
      }

      // Move leftPointer to the position where rightPointer was before incrementing it again
      leftPointer = rightPointer;
  }
  return bestSeat; // Return the index of the best seat found
}