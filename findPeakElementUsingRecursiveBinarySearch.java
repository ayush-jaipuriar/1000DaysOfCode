class Solution {
    public int findPeakElement(int[] nums) {
        return search(nums,0, nums.length-1);
    }
    public int search(int[] arr, int left, int right) {
        if (left==right){
            return left;
        } 
        int mid = (left+right)/2;
        if (arr[mid]<arr[mid+1]) {
            return search (arr, mid+1, right);
        } 
        return search(arr, left, mid);
    }
}
