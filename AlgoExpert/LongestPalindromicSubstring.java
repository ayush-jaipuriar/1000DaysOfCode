import java.util.*;

class Program {
    // Time Complexity : O(n^2)
    // Space Complexity : O(n)
    public static String longestPalindromicSubstring(String str) {
        int[] longestSubstring = { 0, 1 };

        for (int i = 0; i < str.length(); i++) {
            int[] oddSubstringIndex = getLongestSubstringFrom(str, i - 1, i + 1);
            int[] evenSubstringIndex = getLongestSubstringFrom(str, i - 1, i);

            int[] currentLongestSubstringIndex = oddSubstringIndex[1] - oddSubstringIndex[0] > evenSubstringIndex[1]
                    - evenSubstringIndex[0] ? oddSubstringIndex : evenSubstringIndex;
            longestSubstring = currentLongestSubstringIndex[1] - currentLongestSubstringIndex[0] > longestSubstring[1]
                    - longestSubstring[0] ? currentLongestSubstringIndex : longestSubstring;
        }

        return str.substring(longestSubstring[0], longestSubstring[1]);
    }

    public static int[] getLongestSubstringFrom(String str, int leftIndex, int rightIndex) {
        while (leftIndex >= 0 && rightIndex < str.length()) {
            if (str.charAt(leftIndex) != str.charAt(rightIndex)) {
                break;
            }
            leftIndex--;
            rightIndex++;
        }
        return new int[] { leftIndex + 1, rightIndex };
    }
}
