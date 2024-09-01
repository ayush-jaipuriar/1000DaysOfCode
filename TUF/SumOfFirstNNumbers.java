package TUF;

class Solution {
    // Time Complexity: O(N)
    // Space Complexity: O(1)
    public int NnumbersSum(int N) {
        return nNumberSumHelper(N);
    }

    // Time Complexity: O(N)
    // Space Complexity: O(1)
    public int nNumberSumHelper(int n) {
        // Base case: If n is 1, return 1 because we need to sum 1 number
        if (n == 1) {
            return 1;
        }
        
        return n + nNumberSumHelper(n-1);
    }
}
