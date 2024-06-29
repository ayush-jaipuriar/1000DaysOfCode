package com.striver.sdesheet;

import java.util.HashMap;
import java.util.Map;

class Solution {
    // Time Complexity : O(n)
    // Space Complexity : O(n)
    public int longestConsecutive(int[] nums) {
        // Initialize maxLength to track the length of the longest consecutive elements
        // sequence found so far.
        int maxLength = 0;

        // Iterate through each number in the input array.
        for (int i = 0; i < nums.length; i++) {
            // Store the current number being examined.
            int currentNumber = nums[i];

            // Calculate the next number in the sequence.
            int nextNumber = currentNumber + 1;

            // Initialize currentLength to keep track of the length of the current sequence.
            int currentLength = 1;

            // Perform forward traversal to find consecutive numbers.
            while (visitsMap.containsKey(nextNumber) && !visitsMap.get(nextNumber)) { // Addressing SonarLint warning
                                                                                      // S1125 and S5411 by simplifying
                                                                                      // the boolean expression.
                visitsMap.put(nextNumber, true); // Mark the next number as visited.
                nextNumber++; // Move to the next number in the sequence.
                currentLength++; // Increment the length of the current sequence.
            }

            // Perform backward traversal to ensure we capture all consecutive numbers.
            int previousNumber = currentNumber - 1;
            while (visitsMap.containsKey(previousNumber) && !visitsMap.get(previousNumber)) {
                visitsMap.put(previousNumber, true); // Mark the previous number as visited.
                previousNumber--; // Move to the previous number in the sequence.
                currentLength++; // Increment the length of the current sequence.
            }

            // Update maxLength if the current sequence is longer than any previously found.
            maxLength = Math.max(currentLength, maxLength);
        }
    }
}