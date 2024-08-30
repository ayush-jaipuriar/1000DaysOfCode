package TUF;

class Solution {
    // Time Complexity : O(N)
    // Space Complexity : O(N); where N is the length of nums[]
    public int arraySum(int[] nums) {
        // Call the helper function starting from the first element
        return arraySumHelper(nums, 0);
    }

    // Helper function to recursively sum the array elements
    public int arraySumHelper(int[] nums, int index) {
        // Base case: if we've reached the end of the array
        if (index == nums.length) {
            return 0;
        }
        
        // Recursive case: sum the current element and recurse on the next
        return nums[index] + arraySumHelper(nums, index+1);
    }
}
