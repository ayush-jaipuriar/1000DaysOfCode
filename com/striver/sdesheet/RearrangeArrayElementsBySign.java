package com.striver.sdesheet;

class Solution {
    // Method to rearrange the array elements so that all positive numbers appear before negative numbers
    // Time Complexity : O(n)
    // Space Complexity : O(1)
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length; // Get the length of the input array
        int[] resultArray = new int[n]; // Initialize the result array with the same length as the input array
        
        // Two indices to keep track of where to place the next positive and negative number
        int positiveIndex = 0; 
        int negativeIndex = 1; 

        // Iterate over each element in the input array
        for (int i = 0; i < n; i++) {
            int currentNum = nums[i];
            
            // If the current number is positive, place it in the result array at the positive index position
            if (currentNum > 0) {
                // Case : Positive Number
                resultArray[positiveIndex] = currentNum;
                positiveIndex += 2; // Move the positive index two positions ahead (since we're placing both positive and negative numbers alternatively)
            } else {
                // Case : Negative Number
                resultArray[negativeIndex] = currentNum;
                negativeIndex += 2; // Move the negative index two positions ahead (same reason as above)
            }
        }
        
        // Return the rearranged array
        return resultArray;
    }
}