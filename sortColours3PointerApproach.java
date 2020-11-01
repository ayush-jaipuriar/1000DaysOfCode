class Solution {
    public void sortColors(int[] arr) {
        int left=0;
        int current=0;
        int right=arr.length-1;
        while (current<=right) {
            if (arr[current]==0) {
                int temp = arr[left];
                arr[left] = arr[current];
                arr[current]=temp;                
                left++;
                current++;
            } else if(arr[current]==2) {
                int temp=arr[right];
                arr[right] = arr[current];
                arr[current] = temp;                
                right--;
            } else {
                current++;
            }
        }
        
    }
}
