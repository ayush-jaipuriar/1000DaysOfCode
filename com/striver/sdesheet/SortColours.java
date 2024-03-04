package com.striver.sdesheet;

import java.sql.Time;

public class SortColours {
    /*
     * *
     * Time Complexity:
     * 
     * O(n), where n is the length of the input array.
     * - We traverse the array once to count the occurrences of 0, 1, and 2.
     * - Then we traverse it again to overwrite the elements based on counts.
     *
     * Space Complexity: O(1), as we are not using any extra space.
     */

    public void sortColors(int[] nums) {
        int zeroCount = 0;
        int oneCount = 0;
        int twoCount = 0;

        // Count occurrences of 0, 1, and 2
        for (int i = 0; i < nums.length; i++) {
            switch (nums[i]) {
                case 0:
                    zeroCount++;
                    break;
                case 1:
                    oneCount++;
                    break;
                case 2:
                    twoCount++;
                    break;
            }
        }

        // Overwrite the array with 0s, 1s, and 2s based on counts
        int i = 0;
        while (zeroCount > 0) {
            nums[i] = 0;
            i++;
            zeroCount--;
        }
        while (oneCount > 0) {
            nums[i] = 1;
            i++;
            oneCount--;
        }
        while (twoCount > 0) {
            nums[i] = 2;
            i++;
            twoCount--;
        }
    }
}
