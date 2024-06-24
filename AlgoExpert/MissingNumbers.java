import java.util.*;

class Program {
    // Time Complexity : O(N)
    // Space Complexity : O(1)
    public int[] missingNumbers(int[] nums) {
        int total = 0;
        int n = nums.length;
        // Calculating the sum of range [1,n+2] inclusive
        for (int i=1; i<n + 3; i++) {
            total += i;
        }

        // Subtracting the actual numbers present in nums from the total to get the sum of the 2 missing numbers
        for (int i=0; i<n; i++) {
            total -= nums[i];
        }
        
        int missingNumberAverage = total / 2;

        int foundFirstHalfSum = 0;
        int foundSecondHalfSum = 0;
        // Iterating through each number in the input array
        for (int i=0; i<n; i++) {
            // Calculating the actual sum of the numbers of both sides of the average of the 2 missing numbers
            if (nums[i] <= missingNumberAverage) {
                foundFirstHalfSum += nums[i]; // Add the number to the sum of the first half
            } else {
                foundSecondHalfSum += nums[i]; // Add the number to the sum of the second half
            }
        }

        int expectedFirstHalfSum = 0;
        int expectedSecondHalfSum = 0;
        // Calculate the expected sum of the first half of the range, up to and including the average of the two missing numbers
        for (int i=1; i<=missingNumberAverage; i++) {
            expectedFirstHalfSum += i; // Add each number in the range to the expected sum of the first half
        }

        // Calculate the expected sum of the second half of the range, starting from the average of the two missing numbers + 1
        for (int i=missingNumberAverage+1; i<n+3; i++) {
            expectedSecondHalfSum += i; // Add each number in the range to the expected sum of the second half
        }

        // Return the difference between the expected and actual sums for both halves to find the two missing numbers
        return new int[]{expectedFirstHalfSum - foundFirstHalfSum, expectedSecondHalfSum - foundSecondHalfSum};
    }
}