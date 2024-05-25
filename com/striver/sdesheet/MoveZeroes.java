package com.striver.sdesheet;

import java.util.Arrays;

class Solution {
    // Time Complexity : O(N)
    // Space Complexity : O(1)
    public void moveZeroes(int[] nums) {
        // Initialize zeroIndex to keep track of where zeros should be placed after
        // moving non-zero elements
        int zeroIndex = 0;
        // Iterate through the array
        for (int i = 0; i < nums.length; i++) {
            // If the current element is not zero, move it to the position indicated by
            // zeroIndex
            // Then increment zeroIndex to ensure future non-zero elements are also moved
            // correctly
            if (nums[i] != 0) {
                nums[zeroIndex++] = nums[i];
            }
        }
        // After all non-zero elements have been moved, fill the rest of the array with
        // zeros starting from zeroIndex
        // This step ensures that all zeros are moved to the end of the array without
        // needing extra space
        Arrays.fill(nums, zeroIndex, nums.length, 0);
    }
}