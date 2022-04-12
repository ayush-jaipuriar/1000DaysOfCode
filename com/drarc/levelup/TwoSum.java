package com.drarc.levelup;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class TwoSum {
	// Time Complexity : O(n)
	// Space Complexity : O(n) where n is the size of the input array

	public static void main(String[] args) {
		int[] result = calculateTwoSum(new int[] {10,5,2,3,-6,9,11}, 4);
		for (int i=0; i<result.length; i++) {
			System.out.print(result[i] + " ");
		}
		
	}
	
	public static int[] calculateTwoSum(int[] arr, int target) {
		Set<Integer> set = new HashSet<>();
		int complement = -1;		
		for (int i=0; i<arr.length; i++) {
			// a + b = c then a = c - b
			complement = target - arr[i];
			if (set.contains(complement)) {
				return new int[] {complement, arr[i]};
			} else {
				set.add(arr[i]);
			}			
		}
		return new int[] {};
		
	}

}
