import java.util.*;

class Program {
    // Time Complexity : O(n^2)
    // Space Complexity : O(n)
    public static String longestPalindromicSubstring(String str) {
        // Initialize an array to keep track of the longest palindromic substring found so far
        int[] longestSubstring = { 0, 1 };

        // Iterate through each character in the string
        for (int i = 0; i < str.length(); i++) {
            // Calculate the longest palindromic substring that includes the current character
            int[] oddSubstringIndex = getLongestSubstringFrom(str, i - 1, i + 1);
            int[] evenSubstringIndex = getLongestSubstringFrom(str, i - 1, i);

            // Determine which substring (odd or even) is longer and update the longestSubstring array
            int[] currentLongestSubstringIndex = oddSubstringIndex[1] - oddSubstringIndex[0] > evenSubstringIndex[1]
                    - evenSubstringIndex[0]? oddSubstringIndex : evenSubstringIndex;
            longestSubstring = currentLongestSubstringIndex[1] - currentLongestSubstringIndex[0] > longestSubstring[1]
                    - longestSubstring[0]? currentLongestSubstringIndex : longestSubstring;
        }

        // Return the longest palindromic substring found
        return str.substring(longestSubstring[0], longestSubstring[1]);
    }

    // Helper method to find the longest palindromic substring from a given substring of the input string
    public static int[] getLongestSubstringFrom(String str, int leftIndex, int rightIndex) {
        // Expand around the center of the substring until a non-matching pair is found
        while (leftIndex >= 0 && rightIndex < str.length()) {
            if (str.charAt(leftIndex)!= str.charAt(rightIndex)) {
                break;
            }
            leftIndex--;
            rightIndex++;
        }
        // Return the start and end indices of the longest palindromic substring found
        return new int[] { leftIndex + 1, rightIndex };
    }
}