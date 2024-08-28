package TUF;

import java.util.Vector;

// Time Complexity: O(n), where n is the length of the input string
// Space Complexity: O(1) - No extra space used other than the input vector

class Solution {
    public Vector<Character> reverseString(Vector<Character> s) {
        reverseStringHelper(s, 0, s.size()-1);
        return s;
    }

    public void reverseStringHelper(Vector<Character> s, int left, int right) {
        if (left >= right) {
            return;
        }

        // Swap the characters
        char temp = s.get(left);
        s.set(left, s.get(right));
        s.set(right, temp);


        // Recursively call the function for the next pair
        reverseStringHelper(s, ++left, --right);
    }
}
