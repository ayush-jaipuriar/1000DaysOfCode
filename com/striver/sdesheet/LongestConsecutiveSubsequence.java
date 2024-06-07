package com.striver.sdesheet;

import java.util.HashMap;
import java.util.Map;

class Solution {
    // Time Complexity : O(n)
    // Space Complexity : O(n)
    public int longestConsecutive(int[] nums) {
        Map<Integer, Boolean> visitsMap = new HashMap<>();
        // Default Values in visitsMap will be nums element vs false(i.e not visited
        // yet)
        for (int num : nums) {
            if (!visitsMap.containsKey(num)) {
                visitsMap.put(num, false);
            }
        }

        int maxLength = 0;

        for (int i = 0; i < nums.length; i++) {
            int currentNumber = nums[i];
            int nextNumber = currentNumber + 1;

            int currentLength = 1;

            // Doing Forward Traverse
            while (visitsMap.containsKey(nextNumber) && visitsMap.get(nextNumber) == false) {
                visitsMap.put(nextNumber, true);
                nextNumber++;
                currentLength++;
            }

            // Doing Backward Traverse
            int previousNumber = currentNumber - 1;
            while (visitsMap.containsKey(previousNumber) && visitsMap.get(previousNumber) == false) {
                visitsMap.put(previousNumber, true);
                previousNumber--;
                currentLength++;
            }

            maxLength = Math.max(currentLength, maxLength);
        }

        return maxLength;
    }
}