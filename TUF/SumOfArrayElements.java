package TUF;

class Solution {
    // Time Complexity : O(N)
    // Space Complexity : O(N); where N is the length of nums[]
    public int arraySum(int[] nums) {
        return arraySumHelper(nums, 0);
    }

    public int arraySumHelper(int[] nums, int index) {
        if (index == nums.length) {
            return 0;
        }
        return nums[index] + arraySumHelper(nums, index+1);
    }
}