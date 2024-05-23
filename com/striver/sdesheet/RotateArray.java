package com.striver.sdesheet;

class Solution {
    // Time Complexity : O(n)
    // Space Complexity : O(1)
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        // Ensuring that k doesnt go out of bounds of input array length
        k = k % n;
        // Reversing the entire array first
        reverse(nums, 0, n - 1);

        // Reversing the first kth elements now, which were the last kth elements before
        reverse(nums, 0, k - 1);

        // Reversing the elements after kth index now
        reverse(nums, k, n - 1);

    }

    public void reverse(int[] nums, int i, int j) {
        while (i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
}
