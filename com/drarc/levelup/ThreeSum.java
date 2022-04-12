package com.drarc.levelup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeSum {
	/*
	 * Approach: Sort the array. Have a set of list of integers (threeSumSet), to
	 * store three sum cobos. Go through each item (i). For each item, have two
	 * pointers: one pointing to the next item (j), and another one pointing to the
	 * end of the array (k). Now, do a 2-way-sweep. While j and k doesn't meet, at
	 * each step calculate sum = (nums[i]+nums[j]+nums[k]). [Starting sweep from
	 * next item to prevent duplicate combos because of indexes like ( [i,j,k],
	 * [j,i,k]).] If sum == 0, we found a three-sum combo! Add it to the
	 * threeSumSet. If there is any duplicate combo because of different indexes but
	 * same items like ([i1, j1, k1], [i2, j2, k2], but i1==i2, j1==j2, k1==k2).
	 * This will automatically be taken care of by the set, as it analyzes the added
	 * Lists and makes sure there is no duplicate. If sum > 0, we should try
	 * decreasing the sum value. So we'll decrement k, as this should potentially
	 * result nums[k] being smaller than previous value, as the array is sorted. If
	 * sum < 0, because of the same reason, we'll increment j. Finally, we'll
	 * convert the threeSumSet to ArrayList and return.
	 * 
	 * Complexity analysis: Time: O(n^2), Space: O(n)
	 */

	public static void main(String[] args) {

	}

	public static List<List<Integer>> calculateThreeSum(int[] nums) {
		Set<List<Integer>> set = new HashSet<>();
		List<List<Integer>> list = new ArrayList<>();
		Arrays.sort(nums);
		int sum = 0;
		int n = nums.length;
		int j = 0;
		int k = 0;
		for (int i = 0; i < n - 2; i++) {
			j = i + 1;
			k = n - 1;
			while (j < k) {
				sum = nums[i] + nums[j] + nums[k];
				if (sum == 0) {
					set.add(Arrays.asList(nums[i], nums[j], nums[k]));
					j++;
					k--;
				} else if (sum < 0) {
					j++;
				} else if (sum > 0) {
					k--;
				}

			}
		}
		return new ArrayList<>(set);
	}

}
