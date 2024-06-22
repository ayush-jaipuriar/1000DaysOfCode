class Solution {
    // Method to find the maximum product subarray
    public int maxProduct(int[] nums) {
        // If the input array is empty, return 0
        if (nums.length == 0)
            return 0;

        // Initialize variables to keep track of the maximum and minimum product so far,
        // and the overall maximum product found
        int max_so_far = nums[0];
        int min_so_far = nums[0]; // Also used to store the minimum product to handle negative numbers efficiently
        int result = max_so_far;

        // Iterate through the array starting from the second element
        for (int i = 1; i < nums.length; i++) {
            int curr = nums[i];

            // Calculate the temporary maximum product considering both multiplying by the current number
            // and keeping the current number as is (in case it's positive and can potentially increase the product)
            int temp_max = Math.max(curr, Math.max(max_so_far * curr, min_so_far * curr));

            // Update the minimum product similarly, but also consider multiplying by the current number
            // This helps in handling scenarios where multiplying by a negative number could lead to a smaller product
            min_so_far = Math.min(curr, Math.min(max_so_far * curr, min_so_far * curr));

            // Update the maximum product seen so far based on the temporary maximum calculated above
            max_so_far = temp_max;

            // Update the overall maximum product if the current maximum product seen so far is larger
            result = Math.max(max_so_far, result);
        }

        // Return the overall maximum product found
        return result;
    }
}