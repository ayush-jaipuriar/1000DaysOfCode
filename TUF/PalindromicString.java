package TUF;

class Solution {
    // Time Complexity : O(n)
    // Space Complexity : O(n)   
    public boolean palindromeCheck(String s) {
        return palindromeCheckHelper(s, 0, s.length()-1);
    }

    public boolean palindromeCheckHelper(String s, int left, int right) {
        if (left >= right) {
            return true;
        } 
        char leftChar = s.charAt(left);
        char rightChar = s.charAt(right);
        if (leftChar != rightChar) {
            return false;
        }
        return palindromeCheckHelper(s, left+1, right-1);
    }
}
