import java.util.*;

class Program {
  // Time Complexity : O(n)
  // Space Complexity : O(1); where n is the number of elements in the array
  public static boolean hasSingleCycle(int[] array) {
    int currentIndex = 0;
    int numOfElementsVisited = 0;
    int n = array.length;

    // Conditions : 1) After jumping through all the n elements in the array you reach the original starting index 2) n+1th element you jump through, should be the 1st element visited
    while (numOfElementsVisited < n) {
      // Condition 1 :
      if (currentIndex == 0 && numOfElementsVisited > 0) {
        // This means you have already visited more than 1 element and there is more than 1 cycle in the array
        return false;
      }
      // If we reach here it means we have not found more than 1 cycle yet
      numOfElementsVisited++;
      currentIndex = getNextIndex(array, currentIndex);
    }
    // If after complete traversal through all the elements of the array once, we reached the original position at the start of traversal, it means 
    // there was a single cycle in the array 
    return currentIndex == 0;
  }

  public static int getNextIndex(int[] array, int currentIndex) {
    int n = array.length;
    int nextIndex = (currentIndex + array[currentIndex]) % n;
    // Handling for negative numbers, if jump < 0, we will add n to it
    if (nextIndex < 0) {
      nextIndex = nextIndex + n;
    }
    return nextIndex;
  }
}
