import java.util.*;

class Program {
  public int[][] mergeOverlappingIntervals(int[][] intervals) {
    // Time Complexity: O(N log N) due to the dominant sorting step.
    // Space Complexity: O(N) for storing a copy of the intervals and the result.

    // Cloning to create a copy of the input array to avoid modifying the original
    int[][] sortedIntervals = intervals.clone();

    // Sort intervals based on the start time of each interval 
    Arrays.sort(sortedIntervals, (a, b) -> Integer.compare(a[0], b[0]));

    // Store the final merged intervals
    List<int[]> mergedIntervals = new ArrayList<>();

    // Start with the first interval in the sorted array
    int[] currentInterval = sortedIntervals[0]; 
    mergedIntervals.add(currentInterval);

    // Iterate through the remaining intervals in the sorted array
    for (int[] nextInterval : sortedIntervals) {
      int currentIntervalEnd = currentInterval[1];
      int nextIntervalStart = nextInterval[0];
      int nextIntervalEnd = nextInterval[1];

      // Check if the current interval and next interval overlap
      if (currentIntervalEnd >= nextIntervalStart) {
        // Merge: Update the end of the current interval to cover the next
        currentInterval[1] = Math.max(currentIntervalEnd, nextIntervalEnd);
      } else {
        // No overlap: Add the next interval as a new merged interval
        currentInterval = nextInterval;
        mergedIntervals.add(currentInterval);
      }
    }

    // Convert the list of merged intervals into an array for return 
    return mergedIntervals.toArray(new int[mergedIntervals.size()][]);
  }
}
