class Solution {
    public void sortColors(int[] nums) {
        int countOfZero=0;
        int countOfOne=0;
        int countOfTwo=0;
        for (int i=0; i<nums.length; i++) {
            if (nums[i]==0) {
                countOfZero++;
            } else if (nums[i]==1) {
                countOfOne++;
            } else {
                countOfTwo++;
            }
        }
        for (int i=0; i<nums.length;i++) {
            if (countOfZero>0) {
                nums[i]=0;
                countOfZero--;
            } else if (countOfOne>0) {
                nums[i]=1;
                countOfOne--;
            } else {
                nums[i]=2;
            }
        }
        
    }
}
