class Solution {
    public boolean isHappy(int n) {
        Set<Integer> uniqueNumbers= new HashSet<>();
        while (true) {
            int num = n;
            int sum=0;
            while (num!=0) {
                sum+= (num%10)*(num%10);
                num/=10;
            }
            if (sum==1) {
                break;
            }
            if (!uniqueNumbers.contains(sum)) {
                uniqueNumbers.add(sum);
            } else {
                return false;
            }
            n=sum;
        }
        return true;
        
    }
}
