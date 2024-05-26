package com.striver.sdesheet;

class Solution {
    /**
     * Checks if the array is sorted and rotated.
     *
     * An array is considered sorted and rotated if it follows the pattern of being a sorted array that has been shifted left or right.
     * For example, [15,18,2,3,6,12,8,9,1] is a sorted and rotated array because it represents the sorted array [1,2,3,4,5,6,7,8,9]
     * shifted left by 4 positions.
     *
     * The approach taken here is to iterate through the array once, comparing each element with its next element considering the wrap-around
     * due to rotation. If we find more than one pair of elements where the first is greater than the second, we conclude the array is not
     * sorted and rotated. Otherwise, it is.
     *
     * @param nums The input array to check.
     * @return true if the array is sorted and rotated, false otherwise.
     */
    public boolean check(int[] nums) {
        int count = 0; // Counter to keep track of how many times we find a number greater than the next (considering wrap-around).
        for (int i = 0; i < nums.length; i++) {
            // Check if the current number is greater than the next number, considering the array might be wrapped around due to rotation.
            if (nums[i] > nums[(i + 1) % nums.length]) {
                count++; // Increment the counter if the condition is met.
            }
        }
        // If the counter is less than or equal to 1, it means either the array was already sorted or there was only one instance of a number
        // being greater than the next, indicating a single point of rotation. Therefore, the array is considered sorted and rotated.
        return count <= 1;
    }
}