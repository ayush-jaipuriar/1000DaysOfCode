//Leetcode problem
class Solution {
    static int getFirstPosition(int[] nums, int target) {
        int start=0;
        int end=nums.length-1;
        int ans=-1;
        while (start<=end) {
            int mid = (start+end)/2;
            if (nums[mid]==target) {
                ans = mid;
                end=mid-1;                
            } else if (nums[mid]<target) {
                start=mid+1;                
            } else {
                end=mid-1;
            }
        }
        return ans;
    }
    
    static int getLastPosition(int[] nums, int target) {
        int start=0;
        int end=nums.length-1;
        int ans=-1;
        while (start<=end) {
            int mid=(start+end)/2;
            if (nums[mid]==target) {
                ans=mid;
                start=mid+1;
            }  else if (nums[mid]<target) {
                start=mid+1;
            } else {
                end=mid-1;
            }
        }
        return ans;
    }
    
    public int[] searchRange(int[] nums, int target) {
        int position1=-1, position2=-1;
        position1=getFirstPosition(nums,target);
        if (position1==-1) {
            return new int[] {-1,-1};
        }
        position2=getLastPosition(nums, target);
        return new int[] {position1, position2};
        
    }
}
