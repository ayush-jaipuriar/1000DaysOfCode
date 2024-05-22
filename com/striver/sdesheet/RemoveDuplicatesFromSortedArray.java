package com.striver.sdesheet;

class Solution {
    // Time Complexity : O(n)
    // Space Complexity : O(1); n is the length of the arr
    public int removeDuplicates(int[] arr) {
        // Using 2 pointer approach
        // Initializing both pointers to 1 since we know for sure that 0th Index will be
        // unique
        int leftPointer = 1;

        for (int rightPointer = 1; rightPointer < arr.length; rightPointer++) {
            // Case : We encountered a unique number
            if (arr[rightPointer] != arr[rightPointer - 1]) {
                arr[leftPointer] = arr[rightPointer];
                leftPointer++;
            }
        }

        return leftPointer;
    }
}