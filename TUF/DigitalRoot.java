package TUF;
// Time Complexity: O(1) for best case, O(log N) for average and worst cases
// Space Complexity: O(1) for best case, O(log N) for average and worst cases

class Solution {
    public int addDigits(int num) {
        if (num < 10) {
            return num;
        }
        int sum = 0;
        int current = 0;
        while (num != 0) {
            current = num%10;
            sum+= current;
            num/=10;
        }
        return addDigits(sum);        
    }
}
