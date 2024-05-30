package com.striver.sdesheet;

class Solution {
    // Time Complexity : O(n)
    // Space Complexity : O(1); n is the length of the array
    public int removeDuplicates(int[] arr) {
        // Using 2 pointer approach
        // Initializing both pointers to 1 since we know for sure that 0th Index will be
        // unique
        int leftPointer = 1;

        // Iterate over the array starting from the second element
        for (int rightPointer = 1; rightPointer < arr.length; rightPointer++) {
            // Check if the current element is not equal to the previous one
            // This indicates a unique number
            if (arr[rightPointer] != arr[rightPointer - 1]) {
                // If true, copy the unique number to the position indicated by leftPointer
                // Then increment leftPointer to keep track of the next position for unique
                // numbers
                arr[leftPointer] = arr[rightPointer];
                leftPointer++;
            }
        }

        // Return the count of unique elements after removing duplicates
        return leftPointer;
    }
}