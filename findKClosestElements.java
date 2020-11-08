class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> list = new ArrayList<>();
        int position=0;
        int currentSum=0, sum=0;
        for (int i=0; i<k; i++) {
            currentSum+=Math.abs(x-arr[i]);
        }
        sum=currentSum;
        for (int i=1; i<=arr.length-k; i++) {
            currentSum-=Math.abs(x-arr[i-1]);
            currentSum+=Math.abs(x-arr[i+k-1]);
            if (currentSum<sum) {
                sum=currentSum;
                position=i;
            }
        }
        for (int i=0; i<k; i++) {
            list.add(arr[i+position]);
        }
        return list;
        
    }
}
