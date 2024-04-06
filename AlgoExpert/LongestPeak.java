import java.util.*;

class Program {
    // Time Complexity : O(N)
    // Space Complexity : O(1); n is the length of the array
    public static int longestPeak(int[] array) {
        int longestPeakLength = 0;
        int n = array.length;
        int currentPeakLength = 0;
        int i = 1;
        while (i < n - 1) {
            // Checking if current element array[i] is a peak or not
            // peak condition : array[i-1] < array[i] and array[i] > array[i+1]
            boolean isPeak = array[i - 1] < array[i] && array[i] > array[i + 1];

            // If not peak then no point check length of current peak, increment i and
            // continue
            if (!isPeak) {
                i++;
                continue;
            }

            // Peak confirmed, now we will expand leftwards and rightwards and count the
            // length of the current peak
            int leftIdx = i - 2; // not doing i-1 since its already confirmed that array[i] is a peak which means
                                 // array[i-1] < array[i]
            while (leftIdx >= 0 && array[leftIdx] < array[leftIdx + 1]) {
                leftIdx--;
            }

            int rightIdx = i + 2; // not doing i+1 since its already confirmed that array[i] is a peak which means
                                  // array[i+1] < array[i]
            while (rightIdx < n && array[rightIdx] < array[rightIdx - 1]) {
                rightIdx++;
            }

            // Calculating the length of current peak using rightIdx and leftIdx
            currentPeakLength = rightIdx - leftIdx - 1;

            // Calculating the max peak length by comparing its value with currentPeakLength
            longestPeakLength = Math.max(longestPeakLength, currentPeakLength);
            i = rightIdx; // no need to check for elements before rightIdx again since they have already
                          // been checked
        }
        return longestPeakLength;
    }
}
