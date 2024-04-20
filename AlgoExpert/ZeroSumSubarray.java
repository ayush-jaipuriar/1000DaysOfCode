import java.util.*;

class Program {
  // Time Complexity : O(N)
  // Space Complexity : O(N) ; N = length of nums
  public boolean zeroSumSubarray(int[] nums) {
    Set<Integer> set = new HashSet<>();
    set.add(0);

    int currentSum = 0;

    for (int i=0; i<nums.length; i++) {
      currentSum += nums[i];

      // Checking if we have encountered the same sum in any previous subarray or not
      // If we have that means current subarray is a zero sum subarray
      if (set.contains(currentSum)) {
        return true;
      } else {
        set.add(currentSum);
      }
    }

    return false;
  }
}
