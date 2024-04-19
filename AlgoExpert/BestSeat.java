import java.util.*;

class Program {
  // Time Complexity : O(n)
  // Space Complexity : O(1); n is the number of seats in the array
  public int bestSeat(int[] seats) {
    int bestSeat = -1;
    int maxSpace = 0;
    int currentSpace = 0;
    int leftPointer = 0;
    int n = seats.length;
    while (leftPointer < n) {
      int rightPointer = leftPointer + 1;
      // Incrementing the rightPointer as long as it sees a 0
      while (rightPointer < n && seats[rightPointer] == 0) {
        rightPointer++;
      }
      // Calculating space between rightPoitner and leftPointer
      currentSpace = rightPointer - leftPointer - 1;
      if (currentSpace > maxSpace) {
        maxSpace = currentSpace;
        bestSeat = (rightPointer + leftPointer)/2;
      }

      leftPointer = rightPointer;
    }
    return bestSeat;
    
  }
}
