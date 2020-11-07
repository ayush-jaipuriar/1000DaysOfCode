// !!!!! Passes all test cases in Coding Blocks but fails some on Leetcode
class Solution {
    public int maxProduct(int[] nums) {
        if (nums.length==1) {
            return nums[0];
        }
        int negativeProduct=1, positiveProduct=1;
        int maxProduct=Integer.MIN_VALUE;
        boolean hasZero=false, hasPositive=false;
        for (int i: nums) {
            if (i>0) {
                hasPositive=true;
                positiveProduct*=i;
                if (negativeProduct!=1) {
                    negativeProduct*=i;
                } 
            } else if (i<0) {
                int temp = positiveProduct;
                positiveProduct = Math.max(1, negativeProduct*i);
                negativeProduct = temp * i;
            } else {
                positiveProduct=negativeProduct=1;
                hasZero=true;
            }
                maxProduct=Math.max(maxProduct, positiveProduct);            
            }
            if (maxProduct==1) {
                if(hasPositive) {
                    return maxProduct;
                } 
                if (hasZero) {
                    return 0;
                }
            }
        return maxProduct;
        
    }
}
