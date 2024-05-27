package com.striver.sdesheet;

class Solution {
    // Time Complexity : O(n)
    // Space Complexity : O(1)
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int[] resultArray = new int[n];
        int positiveIndex = 0;
        int negativeIndex = 1;

        for (int i = 0; i < n; i++) {
            int currentNum = nums[i];
            if (currentNum > 0) {
                // Case : Positive Number
                resultArray[positiveIndex] = currentNum;
                positiveIndex += 2;
            } else {
                // Case : Negative Number
                resultArray[negativeIndex] = currentNum;
                negativeIndex += 2;
            }
        }

        return resultArray;
    }
}