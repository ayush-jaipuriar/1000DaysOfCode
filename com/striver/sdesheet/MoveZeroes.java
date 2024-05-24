package com.striver.sdesheet;

import java.util.Arrays;

class Solution {
    // Time Complexity : O(N)
    // Space Complexity : O(1)
    public void moveZeroes(int[] nums) {
        int zeroIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[zeroIndex++] = nums[i];
            }
        }
        Arrays.fill(nums, zeroIndex, nums.length, 0);

    }
}