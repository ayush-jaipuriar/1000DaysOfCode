package com.striver.sdesheet;

// Corrected import statement to remove unused import
import java.util.Arrays; // Added for sorting demonstration

public class SortColours {
    /*
     * Problem Statement:
     * Given an array with three types of integers (0, 1, and 2),
     * write a method to move all items such that 0 precedes 1 and 1 precedes 2.
     * You have to do this in-place without making a copy of the array.
     *
     * Approach:
     * - Count the occurrence of each number.
     * - Reconstruct the array according to the counts.
     */

    public static void sortColors(int[] nums) {
        int zeroCount = 0;
        int oneCount = 0;
        int twoCount = 0;

        // Count occurrences of 0, 1, and 2
        for (int num : nums) {
            switch (num) {
                case 0:
                    zeroCount++;
                    break;
                case 1:
                    oneCount++;
                    break;
                case 2:
                    twoCount++;
                    break;
            }
        }

        // Overwrite the array with 0s, 1s, and 2s based on counts
        int index = 0;
        while (zeroCount-- > 0) {
            nums[index++] = 0;
        }
        while (oneCount-- > 0) {
            nums[index++] = 1;
        }
        while (twoCount-- > 0) {
            nums[index++] = 2;
        }
    }

    // Example usage
    public static void main(String[] args) {
        int[] exampleArray = {2, 0, 2, 1, 0, 0, 1, 2};
        System.out.println("Before Sorting: " + Arrays.toString(exampleArray));
        sortColors(exampleArray);
        System.out.println("After Sorting: " + Arrays.toString(exampleArray));
    }
}