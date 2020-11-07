class Solution {
    public List<Integer> findDuplicates(int[] arr) {
        List<Integer> list = new ArrayList<>();
        for (int i=0; i<arr.length; i++) {
            int temp = Math.abs(arr[i]);
            if (arr[temp-1]<0) {
                list.add(temp);
            } else {
                arr[temp-1]*=-1;
            }
        }
        return list;
        
    }
}
