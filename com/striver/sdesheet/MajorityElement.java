package com.striver.sdesheet;

import java.util.Arrays;

class Solution {
    // Time Complexity : O(n)
    // Space Complexity : O(1)
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}